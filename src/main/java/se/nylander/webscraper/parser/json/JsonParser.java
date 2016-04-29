package se.nylander.webscraper.parser.json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import se.nylander.webscraper.util.ScraperConstants;
import se.nylander.webscraper.exception.JavascriptJsonFormatException;
import se.nylander.webscraper.model.ItemSocket;
import se.nylander.webscraper.model.Mod;
import se.nylander.webscraper.model.Property;
import se.nylander.webscraper.model.Requirement;
import se.nylander.webscraper.model.TradeItem;
import se.nylander.webscraper.util.TypeBaseUtil;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by erik.nylander on 2016-02-18.
 */
public class JsonParser {

    public JsonParser(){}

    public Optional<List<TradeItem>> processJsonItemDataString(String dirtyJson) {
        String json;
        try {
            json = dirtyJson.substring(dirtyJson.indexOf("[["), dirtyJson.indexOf(")).run"));
        } catch (IndexOutOfBoundsException e) {
            throw new JavascriptJsonFormatException(" Failed to parse Javascript Json Body ", e);
        }
        JSONArray arr = new JSONArray(json);
        List<String> items = new ArrayList<>();
        String cleanJson = "";

        for (int i = 0; i < arr.length(); i++) {

            // Ta bort dom första hak-lådorna
            try {
                String base = arr.get(i).toString();

                cleanJson = base.substring(base.indexOf("{"), base.lastIndexOf(",[]]"));

            } catch (StringIndexOutOfBoundsException e) {
                e.printStackTrace();
            }

            items.add(cleanJson);
        }

        return jsonParsing(items);
    }

    private static Optional<List<TradeItem>> jsonParsing(List<String> cleanJson) {
        List<TradeItem> tradeItems = new ArrayList<>();

        cleanJson.stream().forEach(item -> {
            TradeItem tradeItem = new TradeItem();

            JSONObject object = new JSONObject(item);

            tradeItem.setCorrupted(object.getBoolean(ScraperConstants.ITEM_CORRUPTED));
            tradeItem.setBase(parseTypeLine(object));
            if(tradeItem.getBase().contains("Superior")){
                tradeItem.setBase(tradeItem.getBase().replaceAll("Superior","").trim());
            }
            tradeItem.setIdentified(object.getBoolean(ScraperConstants.ITEM_IDENTIFIED));
            tradeItem.setIcon(object.getString(ScraperConstants.ITEM_ICON));
            tradeItem.setLeague(object.getString(ScraperConstants.ITEM_LEAGUE));
            tradeItem.setName(parseName(object));
            tradeItem.setVerified(object.getBoolean(ScraperConstants.ITEM_VERIFIED));
            tradeItem = parseProperties(object, tradeItem);
            tradeItem = parseMods(object, tradeItem);


            tradeItem = parseRequirments(object, tradeItem);
            tradeItem = parseSockets(object, tradeItem);
            tradeItem.setType(parseType(tradeItem.getBase()));
            tradeItems.add(tradeItem);

        });
        return Optional.of(tradeItems);
    }

    // Check if typeline contains >>
    private static String parseTypeLine(JSONObject object) {
        Optional<String> type = Optional.ofNullable(object.optString(ScraperConstants.ITEM_TYPE));

        Pattern pattern = Pattern.compile(ScraperConstants.NAME_TYPE_REGEX);
        Matcher matcher = pattern.matcher(type.get());
        return type.isPresent() && matcher.find() ?
                type.get().substring(matcher.start(), matcher.end()) : "";
    }

    // Check if name is empty or contains >>, if yes it returns typeline
    private static String parseName(JSONObject object) {
        Optional<String> name = Optional.ofNullable(object.optString(ScraperConstants.ITEM_NAME));


            Pattern pattern = Pattern.compile(ScraperConstants.NAME_TYPE_REGEX);
            Matcher matcher = pattern.matcher(name.get());

            return name.isPresent() && matcher.find() ?
                    name.get().substring(matcher.start(), matcher.end()) : parseTypeLine(object);

    }

    private static TradeItem parseMods(JSONObject object, TradeItem tradeItem) {

            Optional<JSONArray> implicitMods = Optional.ofNullable(object.optJSONArray(ScraperConstants.ITEM_IMPLICIT_MODS));
            Optional<JSONArray> explicitMods = Optional.ofNullable(object.optJSONArray(ScraperConstants.ITEM_EXPLICIT_MODS));
            Optional<JSONArray> craftedMods = Optional.ofNullable(object.optJSONArray(ScraperConstants.ITEM_CRAFTED_MODS));


            if (implicitMods.isPresent()) {

                tradeItem = manageModProperties(implicitMods.get(), tradeItem);
            }
            if (explicitMods.isPresent()) {

                tradeItem = manageModProperties(explicitMods.get(), tradeItem);

            }if (craftedMods.isPresent()) {

                tradeItem = manageModProperties(craftedMods.get(), tradeItem);
            }

        return tradeItem;
    }

    private static TradeItem parseProperties(JSONObject object, TradeItem tradeItem) {
            JSONArray properties = object.optJSONArray(ScraperConstants.ITEM_PROPERTIES);
            Set<Property> tradeItemProperties = new HashSet<>();

        if(properties != null){
                for (int i = 0; i < properties.length(); i++) {
                //Optional<String> value = properties.getJSONObject(i).getJSONArray("values").getJSONArray(0).toString();
                Property property = new Property();


                    Optional<JSONArray> values = Optional.ofNullable(properties.getJSONObject(i).getJSONArray("values"));
                    Optional<String> value = Optional.ofNullable(values.isPresent() && !values.get().isNull(0)
                            ? values.get()
                            .getJSONArray(0).optString(0)
                            : null
                    );

                if(value.isPresent()){
                    Pattern pattern = Pattern.compile(ScraperConstants.MOD_REGEX);
                    Matcher matcher = pattern.matcher(value.get());

                    Optional<Double> optionalMinValue = Optional.ofNullable(matcher.find()
                            ? Double.parseDouble(value.get().substring(matcher.start(), matcher.end()))
                            : null
                    );

                    Optional<Double> optionalMaxValue = Optional.ofNullable(matcher.find()
                            ? Double.parseDouble(value.get().substring(matcher.start(), matcher.end()))
                            : optionalMinValue.isPresent()
                            ? optionalMinValue.get()
                            : null
                    );

                    property.setMiniValue(optionalMinValue.isPresent() ? optionalMinValue.get() : null);
                    property.setMaxiValue(optionalMaxValue.isPresent() ? optionalMaxValue.get() : null);
                    property.setNumberValue(optionalMinValue.isPresent() && optionalMaxValue.isPresent());
                    property.setTextValue(!property.getNumberValue() ? value.get() : null);

                }else {
                    property.setNumberValue(false);
                }

                    String name = properties.getJSONObject(i).getString("name");
                    property.setPropName(name);
                    tradeItemProperties.add(property);
                }

               tradeItem.setProperty(tradeItemProperties);
            }
        return tradeItem;
    }

    private static TradeItem parseRequirments(JSONObject object, TradeItem tradeItem) {

        Optional<JSONArray> requirements = Optional.ofNullable(object.optJSONArray(ScraperConstants.ITEM_REQUIRMENT));
        Set<Requirement> reqList = new HashSet<>();
        if(requirements.isPresent()){
            for (int i = 0; i < requirements.get().length(); i++) {

                final String name = requirements.get().getJSONObject(i).getString("name");
                final Double value = requirements.get().getJSONObject(i).getJSONArray("values").getJSONArray(0).getDouble(0);
                reqList.add(new Requirement(name, value));

            }
            tradeItem.setRequirement(reqList);
        }
        return tradeItem;

    }

    private static TradeItem parseSockets(JSONObject object, TradeItem tradeItem) {
        try {
            JSONArray sockets = object.getJSONArray(ScraperConstants.ITEM_SOCKETS);
            Set<ItemSocket> socketsAndLinks = new HashSet<>();

            for (int i = 0; i < sockets.length(); i++) {
                JSONObject socket = sockets.getJSONObject(i);
                Integer socketGroup = socket.getInt("group");
                String socketColor;

                switch (socket.getString("attr")){
                case "D":
                    socketColor = "Green";
                    break;
                case "I":
                    socketColor = "Blue";
                    break;
                case "S":
                    socketColor = "Red";
                    break;
                default:
                    socketColor = "White";
                    break;
                }
                tradeItem.addItemSocket(socketGroup, socketColor);

            }
        } catch (JSONException e) {
            return tradeItem;
        }
        return tradeItem;
    }

    private static TradeItem manageModProperties(JSONArray mods , TradeItem tradeItem) {
        Set<Mod> modList = new HashSet<>();

        for (int i = 0; i < mods.length(); i++) {

            String modName = mods.getString(i);
            Pattern pattern = Pattern.compile(ScraperConstants.MOD_REGEX);
            Matcher matcher = pattern.matcher(modName);


            Optional<Double> optionalMinValue = Optional.ofNullable(matcher.find()
                    ? Double.parseDouble(modName.substring(matcher.start(), matcher.end()))
                    : null
            );

            Optional<Double> optionalMaxValue = Optional.ofNullable(matcher.find()
                    ? Double.parseDouble(modName.substring(matcher.start(), matcher.end()))
                    : optionalMinValue.isPresent()
                                      ? optionalMinValue.get()
                                      : null
            );

            //Ta bort nummer för att göra mod-namnet generiskt
            modName = modName.replaceAll("(\\d+)","#");
            final Mod currentMod = new Mod(modName, optionalMinValue.isPresent()
                                            ? optionalMinValue.get()
                                            : null
                                        , optionalMaxValue.isPresent()
                                            ? optionalMaxValue.get()
                                            : null);

            Optional<Mod> existingMod = modList.stream()
                                                 .filter(mod -> mod.equals(currentMod))
                                                 .findFirst();


            if(existingMod.isPresent()) {
                Double existingModMinValue = existingMod.get().getMiniValue();
                Double existingModMaxValue = existingMod.get().getMaxiValue();

                if(existingModMinValue != null && currentMod.getMiniValue() != null) {
                    existingMod.get().setMiniValue(existingModMinValue + currentMod.getMiniValue());
                }
                if(existingModMaxValue != null && currentMod.getMaxiValue() != null){
                    existingMod.get().setMaxiValue(existingModMaxValue + currentMod.getMaxiValue());
                }

                modList.add(existingMod.get());
            } else {
                modList.add(currentMod);
            }

        }
        tradeItem.setMod(modList);
        return tradeItem;
    }

    private static String parseType(String base){

        Optional<String> type = TypeBaseUtil.getTypeForItem(base);

        return type.isPresent() ? type.get() : null;
    }

}
