package se.nylander.webscraper.parser.jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.StringUtils;
import se.nylander.webscraper.exception.NoItemDataException;
import se.nylander.webscraper.model.Shop;
import se.nylander.webscraper.model.TradeItem;
import se.nylander.webscraper.parser.json.JsonParser;
import se.nylander.webscraper.parser.jsoup.util.DocUtil;
import se.nylander.webscraper.service.ShopService;
import se.nylander.webscraper.util.ScraperConstants;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by erik.nylander on 2016-03-22.
 */
public class ForumThreadParser {

    @Autowired
    @Qualifier("jsonParser")
    private JsonParser jsonParser;

    private String currentLeague;

    @Autowired
    @Qualifier("shopService")
    private ShopService shopService;

    public void setCurrentLeague(String currentLeague) {
        this.currentLeague = currentLeague;
    }

    public List<String> extractShopLinks(String href) throws IOException {
        Document htmlBody;
        try {
            htmlBody = DocUtil.getDocument(href);

            //div.title
            Elements tableTitles = htmlBody.getElementById("view_forum_table").select("tr");


            List<String> threads = tableTitles.stream()
                    .filter(tr -> !tr.select("div.sticky.off").isEmpty())
                    .map(title -> title.select("div.title").get(0).child(0).attributes().get("href"))
                    .collect(Collectors.toList());
            return threads;
        } catch (IOException e) {
            throw e;
        }

    }

    public Shop readForumLinksShops(String href) throws Exception {
        String dirtyJson;
        Document htmlBody = null;
        try {
            htmlBody = DocUtil.getDocument(href);

            dirtyJson = htmlBody
                    .select("script")
                    .stream()
                    .map(script -> script.toString())
                    .filter(data -> data.contains("DeferredItemRenderer"))
                    .findFirst()
                    .get();

        } catch (Exception e) {
            throw e instanceof NoSuchElementException
                    ? new NoItemDataException("No item data present in shop")
                    : e;
        }

        Shop currentShop = extractShopMetaInfo(htmlBody);
        currentShop.setThreadLink(href);
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(currentShop.getThreadLink());
        currentShop.setId(matcher.find() ?
                Long.valueOf(currentShop.getThreadLink().substring(matcher.start(), matcher.end()))
                : null);

        List<TradeItem> tradeItems = jsonParser.processJsonItemDataString(dirtyJson);


        tradeItems.stream()
                .forEach(item ->
                        item.setShopOwner(currentShop.getShopOwner())
                );

        currentShop.setTradeItems(mapItemPrices(htmlBody, tradeItems));

        shopService.saveOrUpdate(currentShop);
        return currentShop;
    }

    private Shop extractShopMetaInfo(Document htmlBody) {
        String postedByDiv = htmlBody.getElementsByClass(ScraperConstants.SHOP_POSTED_BY).get(0).getElementsByTag("span").text();
        String shopOwner = postedByDiv.substring(0, postedByDiv.indexOf(" "));
        String lastEdited = postedByDiv.substring(postedByDiv.indexOf(" "));
        String shopName = htmlBody.select("h1.topBar").get(0).ownText();

        return new Shop(shopName, shopOwner, lastEdited, currentLeague, LocalDateTime.now());
    }

    private List<TradeItem> mapItemPrices(Document htmlbody, List<TradeItem> tradeItems) {

        HashMap<Integer, String> map = new HashMap<>();

        List<Node> nodes = htmlbody.select("div.content").first().childNodes();
        Integer lastRead = null;
        String price = null;

        for (Node node : nodes) {

            if (node instanceof Element) {
                Element element = (Element) node;

                if (element.hasClass("spoiler")) {
                    map = handleSpoilerElements(element, map);

                } else if (element.hasClass("itemFragment")) {
                    lastRead = getItemId(element.id());
                }

            } else if (node instanceof TextNode) {
                TextNode text = (TextNode) node;
                if (StringUtils.hasLength(text.text().trim())) {

                    price = checkPrice(text.text());
                    map = addToMap(price, lastRead, map);
                }

            }

        }

        return mapPricesAndTradeItems(map, tradeItems);
    }

    private HashMap<Integer, String> handleSpoilerElements(Element element, HashMap<Integer, String> map) {
        Elements elements = element.select("div.spoilerContent,div.spoilerTitle:matches(~)");
        Integer lastRead = null;
        String price = null;

        for (Element spoilerElement : elements) {
            if (spoilerElement.hasClass("spoilerTitle")) {
                price = spoilerElement.childNodes().stream()
                        .map(c -> (Element) c)
                        .filter(t -> checkPrice(t.text()) != null)
                        .map(n -> n.text())
                        .findFirst()
                        .orElse(null);

            } else if (spoilerElement.hasClass("spoilerContent")) {

                for (Node childNode : spoilerElement.childNodes()) {

                    if (childNode instanceof Element) {
                        Element spoilerItem = (Element) childNode;

                        //Priser för alla items i spoiler diven
                        if (spoilerItem.hasClass("itemFragment")) {
                            lastRead = getItemId(spoilerItem.id());
                            map = addToMap(price, lastRead, map);
                        }
                    } else
                        // Om ett item har ett individuelt pris i en spoilerDiv med generelt pris, överrider värdet i mapen
                        if (childNode instanceof TextNode) {
                            TextNode text = (TextNode) childNode;
                            if (StringUtils.hasLength(text.text().trim())) {

                                String indiviualPrice = checkPrice(text.text());
                                map = addToMap(indiviualPrice, lastRead, map);

                            }

                        }

                }
            }
        }

        return map;
    }

    private HashMap<Integer, String> addToMap(String price, Integer lastRead, HashMap<Integer, String> map) {
        if (lastRead != null) {
            map.put(lastRead, price);
        }
        return map;
    }

    private String checkPrice(String text) {
        text = text.trim();
        Pattern pattern = Pattern.compile(ScraperConstants.PRICE_REGEX);
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            return text.substring(matcher.start(), matcher.end());
        }
        return null;
    }

    private Integer getItemId(String id) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(id);
        if (matcher.find()) {
            return Integer.parseInt(id.substring(matcher.start(), matcher.end()));
        }
        return null;
    }

    private List<TradeItem> mapPricesAndTradeItems(HashMap<Integer, String> map, List<TradeItem> tradeItems) {

        map.entrySet().stream().forEach(entry -> {
            tradeItems.get(entry.getKey()).setPrice(entry.getValue());
        });

        return tradeItems;
    }

    /*
    public static void main(String[] args) throws Exception {

        ForumThreadParser parser = new ForumThreadParser();
        parser.readForumLinksShops("/forum/view-thread/1659933");
    }
    */


}
