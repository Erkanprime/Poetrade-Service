package se.nylander.webscraper.config;

/**
 * Created by erik.nylander on 2016-03-07.
 */
public final class ScraperConstants {

    public static final String SHOP_POSTED_BY = "posted-by";
    public static final String ITEM_FRAGMENT = "itemFragment";
    public static final String MOD_REGEX = "^[+-]?\\d+|\\d+"; // %?

    public static final String ITEM_CORRUPTED = "corrupted";
    public static final String ITEM_TYPE = "typeLine";
    public static final String ITEM_LEVEL_REQUIRMENT = "requirements";
    public static final String ITEM_IMPLICIT_MODS = "implicitMods";
    public static final String ITEM_EXPLICIT_MODS = "explicitMods";

    public static final String ITEM_CRAFTED_MODS = "craftedMods";

    public static final String ITEM_SOCKETS = "sockets";
    public static final String ITEM_LEAGUE = "league";
    public static final String ITEM_VERIFIED = "verified";
    public static final String ITEM_ICON = "icon";
    public static final String ITEM_IDENTIFIED = "identified";
    public static final String ITEM_NAME = "name";
    public static final String ITEM_PROPERTIES = "properties";

    public static final String ITEM_UNDEFINED = "Undefined";

    public static final String URL = "http://www.pathofexile.com";

    public static final String STANDARD_HARDCORE_LEAGUE = "Hardcore Trading - Shops";
    public static final String STANDARD_LEAGUE = "Standard Trading - Shops";

    public static final String EXTRACT_JSON_REGEX = "require\\(\\[\\\"PoE\\/Item\\/DeferredItemRenderer\\\"\\], function\\(R\\) \\{ \\(new R\\((.*?)\\)\\)\\.run\\(\\)\\; \\}\\)\\;";


}
