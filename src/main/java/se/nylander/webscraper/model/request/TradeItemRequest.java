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
    private Boolean corrupted;
    private Boolean identified;
    private SocketRequest sockets;
    private List<RequirementRequest> requirements;
    private List<ParameterRequest> parameters;
    private List<ModRequest> mods;

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

    public List<ParameterRequest> getParameters() {
        return parameters;
    }

    public void setParameters(List<ParameterRequest> parameters) {
        this.parameters = parameters;
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


}
