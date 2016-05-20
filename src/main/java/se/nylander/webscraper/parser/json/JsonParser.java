package se.nylander.webscraper.parser.json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.util.StringUtils;
import se.nylander.webscraper.exception.JavascriptJsonFormatException;
import se.nylander.webscraper.model.*;
import se.nylander.webscraper.util.ScraperConstants;
import se.nylander.webscraper.util.TypeBaseUtil;

import java.security.Principal;
import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by erik.nylander on 2016-02-18.
 */
public class JsonParser {

    public JsonParser() {
    }

    public List<TradeItem> processJsonItemDataString(String dirtyJson) {
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

    private static List<TradeItem> jsonParsing(List<String> cleanJson) {
        List<TradeItem> tradeItems = new ArrayList<>();

        cleanJson.stream().forEach(item -> {
            TradeItem tradeItem = new TradeItem();

            JSONObject object = new JSONObject(item);

            tradeItem.setCorrupted(object.getBoolean(ScraperConstants.ITEM_CORRUPTED));
            tradeItem = parseBaseType(tradeItem, object);
            tradeItem.setiLvl(object.optInt(ScraperConstants.ITEM_ILVL));
            tradeItem.setIdentified(object.getBoolean(ScraperConstants.ITEM_IDENTIFIED));
            tradeItem.setIcon(object.getString(ScraperConstants.ITEM_ICON));
            tradeItem.setLeague(object.getString(ScraperConstants.ITEM_LEAGUE));
            tradeItem.setName(parseName(object));
            tradeItem.setVerified(object.getBoolean(ScraperConstants.ITEM_VERIFIED));
            tradeItem = parseProperties(object, tradeItem);
            tradeItem = !tradeItem.getType().equalsIgnoreCase("Divination Card") ?
                        parseMods(object, tradeItem) : tradeItem;

            tradeItem = parseRequirments(object, tradeItem);
            tradeItem = parseSockets(object, tradeItem);
            tradeItem = calculateDps(tradeItem);
            tradeItem.setRarity(object.optInt("frameType"));

            tradeItems.add(tradeItem);

        });
        return tradeItems;
    }

    private static String parseTypeLine(JSONObject object) {
        Optional<String> type = Optional.ofNullable(object.optString(ScraperConstants.ITEM_TYPE));

        Pattern pattern = Pattern.compile(ScraperConstants.NAME_TYPE_REGEX);
        Matcher matcher = pattern.matcher(type.get());
        return type.isPresent() && matcher.find() ?
                type.get().substring(matcher.start(), matcher.end()) : null;
    }

    private static String parseName(JSONObject object) {
        Optional<String> name = Optional.ofNullable(object.optString(ScraperConstants.ITEM_NAME));


        Pattern pattern = Pattern.compile(ScraperConstants.NAME_TYPE_REGEX);
        Matcher matcher = pattern.matcher(name.get());

        // Om inget namn finns(Vanligtvis vita och blå items?) sätt typeline till namn
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

        }
        if (craftedMods.isPresent()) {

            tradeItem = manageModProperties(craftedMods.get(), tradeItem);
        }

        return tradeItem;
    }

    private static TradeItem parseProperties(JSONObject object, TradeItem tradeItem) {
        JSONArray properties = object.optJSONArray(ScraperConstants.ITEM_PROPERTIES);
        Set<Property> tradeItemProperties = new HashSet<>();

        if (properties != null) {
            for (int i = 0; i < properties.length(); i++) {
                Property property = new Property();


                Optional<JSONArray> values = Optional.ofNullable(properties.getJSONObject(i).getJSONArray("values"));

                if (values.isPresent()) {

                    Integer length = values.get().length();
                    Pattern pattern;
                    Matcher matcher;
                    for (int x = 0; x < length; x++) {
                        String value = values.get().getJSONArray(x).optString(0);
                        pattern = Pattern.compile("\\d+-\\d+");
                        matcher = pattern.matcher(value);
                        Double minValue = null;
                        Double maxValue = null;

                        // Om property = Adds 10-20 ..
                        if (matcher.find()) {
                            pattern = Pattern.compile(ScraperConstants.MOD_REGEX);
                            matcher = pattern.matcher(value);
                            minValue = matcher.find() ? Double.valueOf(value.substring(matcher.start(), matcher.end()))
                                    : null;

                            maxValue = matcher.find() ? Double.valueOf(value.substring(matcher.start(), matcher.end()))
                                    : null;

                            Double oldMinValue = property.getMiniValue();
                            Double oldMaxValue = property.getMaxiValue();

                            if (minValue != null) {
                                property.setMiniValue(oldMinValue == null ?
                                        minValue : minValue + oldMinValue);
                            }
                            if (maxValue != null) {
                                property.setMaxiValue(oldMaxValue == null ?
                                        maxValue : maxValue + oldMaxValue);
                            }

                        } else {
                            pattern = Pattern.compile(ScraperConstants.MOD_REGEX);

                            if (length == 1) {
                                matcher = pattern.matcher(value);
                                minValue = matcher.find() ? Double.valueOf(value.substring(matcher.start(), matcher.end()))
                                        : null;
                                property.setMiniValue(minValue);
                                property.setMaxiValue(minValue);


                            } else
                                // Specialfall för flaskor?
                                if (length == 2) {
                                    matcher = pattern.matcher(value);
                                    minValue = matcher.find() ? Double.valueOf(value.substring(matcher.start(), matcher.end()))
                                            : null;
                                    property.setMiniValue(minValue);

                                    String secondValue = values.get().getJSONArray(x + 1).optString(0);
                                    matcher = pattern.matcher(secondValue);
                                    maxValue = matcher.find() ? Double.valueOf(secondValue.substring(matcher.start(), matcher.end()))
                                            : null;
                                    property.setMaxiValue(maxValue);

                                }

                        }

                        if (minValue == null && maxValue == null) {
                            property.setTextValue(value);
                        }
                        if (length == 2) {
                            break;
                        }

                    }
                    String propName = properties.getJSONObject(i).getString("name");

                    if (tradeItem.getType() != null && tradeItem.getType().equalsIgnoreCase("Flask")) {
                        if (!StringUtils.hasLength(propName)) {
                            propName = values.get().getJSONArray(0).optString(0);

                        }
                        propName = propName.replaceAll("(%\\d)|(\\d+)", "#");
                    }


                    property.setPropName(propName);

                }

                tradeItemProperties.add(property);
            }

            tradeItem.setProperty(tradeItemProperties);
        }
        return tradeItem;
    }

    private static TradeItem parseRequirments(JSONObject object, TradeItem tradeItem) {

        Optional<JSONArray> requirements = Optional.ofNullable(object.optJSONArray(ScraperConstants.ITEM_REQUIRMENT));
        Set<Requirement> reqList = new HashSet<>();
        if (requirements.isPresent()) {
            for (int i = 0; i < requirements.get().length(); i++) {

                final String name = requirements.get().getJSONObject(i).getString("name");
                final Integer value = requirements.get().getJSONObject(i).getJSONArray("values").getJSONArray(0).getInt(0);
                reqList.add(new Requirement(name, value));

            }
            tradeItem.setRequirement(reqList);
        }
        return tradeItem;

    }

    private static TradeItem parseSockets(JSONObject object, TradeItem tradeItem) {

        Optional<JSONArray> sockets = Optional.ofNullable(object.optJSONArray(ScraperConstants.ITEM_SOCKETS));
        if (sockets.isPresent()) {
            for (int i = 0; i < sockets.get().length(); i++) {
                JSONObject socket = sockets.get().getJSONObject(i);
                Integer socketGroup = socket.getInt("group");
                String socketColor;

                switch (socket.getString("attr")) {
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


            Integer highestlinked = tradeItem.getItemSockets().stream().map(s ->
                    Collections.frequency(tradeItem.getItemSockets(), s))
                    .filter(i -> i > 1)
                    .max(Integer::compareTo)
                    .orElse(0);

            tradeItem.setHighestLink(highestlinked);
        }

        return tradeItem;
    }

    private static TradeItem manageModProperties(JSONArray mods, TradeItem tradeItem) {

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
            modName = modName.replaceAll("(\\d*\\.?\\d+)", "#");
            final Mod currentMod = new Mod(modName, optionalMinValue.isPresent()
                    ? optionalMinValue.get() : null
                    , optionalMaxValue.isPresent()
                    ? optionalMaxValue.get() : null,
                    i);

            Optional<Mod> existingMod = tradeItem.getMod().stream()
                    .filter(mod -> mod.equals(currentMod))
                    .findFirst();


            if (existingMod.isPresent()) {
                Double existingModMinValue = existingMod.get().getMiniValue();
                Double existingModMaxValue = existingMod.get().getMaxiValue();

                if (existingModMinValue != null && currentMod.getMiniValue() != null) {
                    existingMod.get().setMiniValue(existingModMinValue + currentMod.getMiniValue());
                }
                if (existingModMaxValue != null && currentMod.getMaxiValue() != null) {
                    existingMod.get().setMaxiValue(existingModMaxValue + currentMod.getMaxiValue());
                }

                tradeItem.addMod(existingMod.get());
            } else {
                tradeItem.addMod(currentMod);
            }

        }
        return tradeItem;
    }

    private static TradeItem parseBaseType(TradeItem tradeItem, JSONObject object) {
        Optional<String> typeLine = Optional.ofNullable(object.optString(ScraperConstants.ITEM_TYPE));

        Optional<String> type = TypeBaseUtil.getType(typeLine.get());
        Optional<String> base = TypeBaseUtil.getBase(typeLine.get());

        tradeItem.setType(type.isPresent() ? type.get() : null);
        tradeItem.setBase(base.isPresent() ? base.get() : null);

        return tradeItem;
    }

    private static TradeItem calculateDps(TradeItem tradeItem) {
        Set<Property> properties = tradeItem.getProperty();

        Optional<Double> aps = getApsFromProperties(properties);
        if (aps.isPresent()) {

            Optional<Double> pDps = getDamageFromProperties(properties, "Physical Damage");
            tradeItem.setpDps(pDps.isPresent()
                    ? (pDps.get() / 2 * aps.get())
                    : null);

            Optional<Double> eDps = getDamageFromProperties(properties, "Elemental Damage");
            tradeItem.seteDps(eDps.isPresent()
                    ? (eDps.get() / 2 * aps.get())
                    : null);

        }

        return tradeItem;
    }

    private static Optional<Double> getDamageFromProperties(Set<Property> properties, String damageType) {
        return properties.stream()
                .filter(p -> p.getPropName().equalsIgnoreCase(damageType))
                .map(d -> d.getMiniValue() + d.getMaxiValue())
                .findFirst();
    }

    private static Optional<Double> getApsFromProperties(Set<Property> properties) {
        return properties.stream()
                .filter(p -> p.getPropName().equalsIgnoreCase("Attacks per Second"))
                .map(Property::getMiniValue)
                .findFirst();
    }

}
