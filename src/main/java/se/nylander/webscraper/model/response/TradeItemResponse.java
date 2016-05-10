package se.nylander.webscraper.model.response;

import java.util.HashMap;
import java.util.List;

/**
 * Created by erik.nylander on 2016-04-27.
 */
public class TradeItemResponse {

    private String icon;
    private String name;
    private String type;
    private String base;
    private String shopOwner;
    private String price;
    private Double pDps;
    private Double eDps;
    private Boolean corrupted;
    private Boolean verified;
    private Boolean identified;
    private Integer ilvl;
    private Integer rarity;
    private List<String> mods;
    private HashMap<String, String> properties;
    private HashMap<String, Integer> requirements;
    private List<SocketResponse> sockets;

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

    public Double getpDps() {
        return pDps;
    }

    public void setpDps(Double pDps) {
        this.pDps = pDps;
    }

    public Double geteDps() {
        return eDps;
    }

    public void seteDps(Double eDps) {
        this.eDps = eDps;
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

    public HashMap<String, String> getProperties() {
        return properties;
    }

    public void setProperties(HashMap<String, String> properties) {
        this.properties = properties;
    }

    public HashMap<String, Integer> getRequirements() {
        return requirements;
    }

    public void setRequirements(HashMap<String, Integer> requirements) {
        this.requirements = requirements;
    }

    public Integer getIlvl() {
        return ilvl;
    }

    public void setIlvl(Integer ilvl) {
        this.ilvl = ilvl;
    }

    public List<SocketResponse> getSockets() {
        return sockets;
    }

    public void setSockets(List<SocketResponse> sockets) {
        this.sockets = sockets;
    }

    public Integer getRarity() {
        return rarity;
    }

    public void setRarity(Integer rarity) {
        this.rarity = rarity;
    }
}
