package se.nylander.webscraper.parser.jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import se.nylander.webscraper.model.Shop;
import se.nylander.webscraper.parser.jsoup.util.DocUtil;
import se.nylander.webscraper.service.ShopService;
import se.nylander.webscraper.util.ScraperConstants;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by erik.nylander on 2016-03-22.
 */
public class ForumLeagueParser {

    private HashMap<String, String> forumLinks = new HashMap<>();

    private static Logger log = LoggerFactory.getLogger(ForumLeagueParser.class);


    @Autowired
    @Qualifier("forumThreadParser")
    private ForumThreadParser forumThreadParser;

    @Autowired
    @Qualifier("shopService")
    private ShopService shopService;

    public ForumLeagueParser() {
    }

    /**
     * Fetches all trading-shop-league urls
     */
    public void initForumParsing() {
        try {
            final Document doc = DocUtil.getDocument("/forum");

            final Elements forumLinksElements = doc.getElementsByClass("forum_name").select("div.name");

            forumLinksElements.stream()
                    .filter(name -> name.text().contains("Shops"))
                    .forEach(link -> {
                        String name = link.text();
                        String href = link.getElementsByAttribute("href").get(0).attributes().get("href");
                        forumLinks.put(name, href);
                    });

        } catch (IOException e) {
            log.warn("Coulden't parse: " + ScraperConstants.URL + "/forum\n", e);
            ;
        }
    }

    /**
     * Fetches all trading-shop thread urls from a league
     */
    public void startForumParsing() {

        if (forumLinks.isEmpty()) {
            return;
        }

        List<String> shopLinks = new ArrayList<>();


        for (Map.Entry<String, String> entry : forumLinks.entrySet()) {
            final String league = entry.getKey();
            final String href = entry.getValue();
            Integer amountOfPages = league.equals(ScraperConstants.STANDARD_HARDCORE_LEAGUE)
                    || league.equals(ScraperConstants.STANDARD_LEAGUE) ? 1 : 2; //Mycket mindre indexering behövs på permantenta ligor

            for (int pageNumber = 1; pageNumber <= amountOfPages; pageNumber++) {


                log.info("###############################################");
                log.info("####### Processing league: " + league + "#### " + href + "/page/" + pageNumber);
                log.info("###############################################");

                try {
                    forumThreadParser.setCurrentLeague(league);
                    shopLinks = forumThreadParser.extractShopLinks(href + "/page/" + pageNumber);

                } catch (IOException e) {
                    log.warn("Coulden't parse/connect to League: " + ScraperConstants.URL + href + "/page/" + pageNumber + "\n", e);
                }

                // Parse the content of each thread-post
                if (!shopLinks.isEmpty()) {


                    for (String shopLink : shopLinks) {
                        log.info("###### Parsing forum thread: " + shopLink + " ######");
                        try {

                            forumThreadParser.readForumLinksShops(shopLink);

                        } catch (Exception e) {
                            log.warn("Couldent parse/connect to Thread: " + ScraperConstants.URL + shopLink + "\n" + e.getMessage());
                        }
                    }

                }


            }
        }
    }
}
