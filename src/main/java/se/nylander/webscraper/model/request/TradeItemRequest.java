package se.nylander.webscraper.model.request;

import java.util.List;

/**
 * Created by erik.nylander on 2016-04-25.
 */
public class TradeItemRequest {

    private String league;
    private String name;
    private String type;
    private Integer minLevel;
    private Integer maxLevel;
    private Integer minArmour;
    private Integer minEnergyshield;
    private Integer minEvasion;
    private Boolean corrupted;
    private Double minDps;
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

    public Integer getMinLevel() {
        return minLevel;
    }

    public void setMinLevel(Integer minLevel) {
        this.minLevel = minLevel;
    }

    public Integer getMaxLevel() {
        return maxLevel;
    }

    public void setMaxLevel(Integer maxLevel) {
        this.maxLevel = maxLevel;
    }

    public Integer getMinArmour() {
        return minArmour;
    }

    public void setMinArmour(Integer minArmour) {
        this.minArmour = minArmour;
    }

    public Integer getMinEnergyshield() {
        return minEnergyshield;
    }

    public void setMinEnergyshield(Integer minEnergyshield) {
        this.minEnergyshield = minEnergyshield;
    }

    public Integer getMinEvasion() {
        return minEvasion;
    }

    public void setMinEvasion(Integer minEvasion) {
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
}
