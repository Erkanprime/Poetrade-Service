package se.nylander.webscraper.model.response;

import java.util.List;

/**
 * Created by erik.nylander on 2016-04-27.
 */
public class TradeItemResponse {

    private String icon;
    private String name;
    private String type;
    private String base;
    private Double quality;
    private String shopOwner;
    private String price;
    private Double dps;
    private Double aps;
    private Double levelReq;
    private Double armour;
    private Double energyshield;
    private Double evasion;
    private Double strengthReq;
    private Double dexterityReq;
    private Double intelligenceReq;
    private String flavourText;
    private Boolean corrupted;
    private Boolean verified;
    private Boolean identified;
    private List<String> mods;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Double getQuality() {
        return quality;
    }

    public void setQuality(Double quality) {
        this.quality = quality;
    }

    public String getShopOwner() {
        return shopOwner;
    }

    public void setShopOwner(String shopOwner) {
        this.shopOwner = shopOwner;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Double getDps() {
        return dps;
    }

    public void setDps(Double dps) {
        this.dps = dps;
    }

    public Double getAps() {
        return aps;
    }

    public void setAps(Double aps) {
        this.aps = aps;
    }

    public Double getLevelReq() {
        return levelReq;
    }

    public void setLevelReq(Double levelReq) {
        this.levelReq = levelReq;
    }

    public Double getArmour() {
        return armour;
    }

    public void setArmour(Double armour) {
        this.armour = armour;
    }

    public Double getEnergyshield() {
        return energyshield;
    }

    public void setEnergyshield(Double energyshield) {
        this.energyshield = energyshield;
    }

    public Double getEvasion() {
        return evasion;
    }

    public void setEvasion(Double evasion) {
        this.evasion = evasion;
    }

    public Double getStrengthReq() {
        return strengthReq;
    }

    public void setStrengthReq(Double strengthReq) {
        this.strengthReq = strengthReq;
    }

    public Double getDexterityReq() {
        return dexterityReq;
    }

    public void setDexterityReq(Double dexterityReq) {
        this.dexterityReq = dexterityReq;
    }

    public Double getIntelligenceReq() {
        return intelligenceReq;
    }

    public void setIntelligenceReq(Double intelligenceReq) {
        this.intelligenceReq = intelligenceReq;
    }

    public String getFlavourText() {
        return flavourText;
    }

    public void setFlavourText(String flavourText) {
        this.flavourText = flavourText;
    }

    public List<String> getMods() {
        return mods;
    }

    public void setMods(List<String> mods) {
        this.mods = mods;
    }

    public Boolean getCorrupted() {
        return corrupted;
    }

    public void setCorrupted(Boolean corrupted) {
        this.corrupted = corrupted;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public Boolean getIdentified() {
        return identified;
    }

    public void setIdentified(Boolean identified) {
        this.identified = identified;
    }
}
