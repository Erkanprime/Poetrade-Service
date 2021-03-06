package se.nylander.webscraper.model.request;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

/**
 * Created by erik.nylander on 2016-04-25.
 */
public class TradeItemRequest {

    private String league;
    private String name;
    private String type;
    private String base;
    private Boolean corrupted;
    private Boolean identified;
    private Double minEdps;
    private Double maxEdps;
    private Double minPdps;
    private Double maxPdps;
    private Integer rarity;
    private Integer minIlvl;
    private Integer maxIlvl;

    private SocketRequest sockets;

    private List<RequirementRequest> requirements;

    private List<PropertyRequest> properties;

    private List<ModRequest> mods;


    public Integer getRarity() {
        return rarity;
    }

    public void setRarity(Integer rarity) {
        this.rarity = rarity;
    }

    public Integer getMinIlvl() {
        return minIlvl;
    }

    public void setMinIlvl(Integer minIlvl) {
        this.minIlvl = minIlvl;
    }

    public Integer getMaxIlvl() {
        return maxIlvl;
    }

    public void setMaxIlvl(Integer maxIlvl) {
        this.maxIlvl = maxIlvl;
    }

    public SocketRequest getSockets() {
        return sockets;
    }

    public void setSockets(SocketRequest sockets) {
        this.sockets = sockets;
    }

    public List<RequirementRequest> getRequirements() {
        return requirements;
    }

    public void setRequirements(List<RequirementRequest> requirements) {
        this.requirements = requirements;
    }

    public Boolean getIdentified() {
        return identified;
    }

    public void setIdentified(Boolean identified) {
        this.identified = identified;
    }

    public List<PropertyRequest> getProperties() {
        return properties;
    }

    public void setProperties(List<PropertyRequest> properties) {
        this.properties = properties;
    }

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

    public Boolean getCorrupted() {
        return corrupted;
    }

    public void setCorrupted(Boolean corrupted) {
        this.corrupted = corrupted;
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

    public Double getMinEdps() {
        return minEdps;
    }

    public void setMinEdps(Double minEdps) {
        this.minEdps = minEdps;
    }

    public Double getMaxEdps() {
        return maxEdps;
    }

    public void setMaxEdps(Double maxEdps) {
        this.maxEdps = maxEdps;
    }

    public Double getMinPdps() {
        return minPdps;
    }

    public void setMinPdps(Double minPdps) {
        this.minPdps = minPdps;
    }

    public Double getMaxPdps() {
        return maxPdps;
    }

    public void setMaxPdps(Double maxPdps) {
        this.maxPdps = maxPdps;
    }
}
