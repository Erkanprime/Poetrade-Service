package se.nylander.webscraper.model.request;

import java.util.List;

/**
 * Created by erik.nylander on 2016-04-25.
 */
public class TradeItemRequest {

    private String league;
    private String name;
    private String type;
    private String base;
    private Double minQuality;
    private Double maxQuality;
    private Double minLevel;
    private Double maxLevel;
    private Double minArmour;
    private Double maxArmour;
    private Double minEnergy;
    private Double maxEnergy;
    private Double minEvasion;
    private Double maxEvasion;
    private Double minStrength;
    private Double maxStrength;
    private Double minDexterity;
    private Double maxDexterity;
    private Double minIntelligence;
    private Double maxIntelligence;
    private Double minDps;
    private Double maxDps;
    private Double minAps;
    private Double maxAps;

    private Boolean corrupted;
    private Boolean identified;
    private List<ModRequest> mods;

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
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

    public Double getMinLevel() {
        return minLevel;
    }

    public void setMinLevel(Double minLevel) {
        this.minLevel = minLevel;
    }

    public Double getMaxLevel() {
        return maxLevel;
    }

    public void setMaxLevel(Double maxLevel) {
        this.maxLevel = maxLevel;
    }

    public Double getMinArmour() {
        return minArmour;
    }

    public void setMinArmour(Double minArmour) {
        this.minArmour = minArmour;
    }

    public Double getMinEnergy() {
        return minEnergy;
    }

    public void setMinEnergy(Double minEnergy) {
        this.minEnergy = minEnergy;
    }

    public Double getMinEvasion() {
        return minEvasion;
    }

    public void setMinEvasion(Double minEvasion) {
        this.minEvasion = minEvasion;
    }

    public Boolean getCorrupted() {
        return corrupted;
    }

    public void setCorrupted(Boolean corrupted) {
        this.corrupted = corrupted;
    }

    public Double getMinDps() {
        return minDps;
    }

    public void setMinDps(Double minDps) {
        this.minDps = minDps;
    }

    public List<ModRequest> getMods() {
        return mods;
    }

    public void setMods(List<ModRequest> mods) {
        this.mods = mods;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Double getMaxArmour() {
        return maxArmour;
    }

    public void setMaxArmour(Double maxArmour) {
        this.maxArmour = maxArmour;
    }

    public Double getMaxEnergy() {
        return maxEnergy;
    }

    public void setMaxEnergy(Double maxEnergy) {
        this.maxEnergy = maxEnergy;
    }

    public Double getMaxEvasion() {
        return maxEvasion;
    }

    public void setMaxEvasion(Double maxEvasion) {
        this.maxEvasion = maxEvasion;
    }

    public Double getMinStrength() {
        return minStrength;
    }

    public void setMinStrength(Double minStrength) {
        this.minStrength = minStrength;
    }

    public Double getMaxStrength() {
        return maxStrength;
    }

    public void setMaxStrength(Double maxStrength) {
        this.maxStrength = maxStrength;
    }

    public Double getMinDexterity() {
        return minDexterity;
    }

    public void setMinDexterity(Double minDexterity) {
        this.minDexterity = minDexterity;
    }

    public Double getMaxDexterity() {
        return maxDexterity;
    }

    public void setMaxDexterity(Double maxDexterity) {
        this.maxDexterity = maxDexterity;
    }

    public Double getMinIntelligence() {
        return minIntelligence;
    }

    public void setMinIntelligence(Double minIntelligence) {
        this.minIntelligence = minIntelligence;
    }

    public Double getMaxIntelligence() {
        return maxIntelligence;
    }

    public void setMaxIntelligence(Double maxIntelligence) {
        this.maxIntelligence = maxIntelligence;
    }

    public Double getMaxDps() {
        return maxDps;
    }

    public void setMaxDps(Double maxDps) {
        this.maxDps = maxDps;
    }

    public Double getMinAps() {
        return minAps;
    }

    public void setMinAps(Double minAps) {
        this.minAps = minAps;
    }

    public Double getMaxAps() {
        return maxAps;
    }

    public void setMaxAps(Double maxAps) {
        this.maxAps = maxAps;
    }

    public Double getMinQuality() {
        return minQuality;
    }

    public void setMinQuality(Double minQuality) {
        this.minQuality = minQuality;
    }

    public Double getMaxQuality() {
        return maxQuality;
    }

    public void setMaxQuality(Double maxQuality) {
        this.maxQuality = maxQuality;
    }

    public Boolean getIdentified() {
        return identified;
    }

    public void setIdentified(Boolean identified) {
        this.identified = identified;
    }
}
