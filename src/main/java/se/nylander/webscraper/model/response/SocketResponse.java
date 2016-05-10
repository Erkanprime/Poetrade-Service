package se.nylander.webscraper.model.response;

/**
 * Created by Cody on 2016-05-10.
 */
public class SocketResponse {

    private Integer groupId;

    private String colour;

    public SocketResponse(Integer groupId, String colour) {
        this.groupId = groupId;
        this.colour = colour;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
}
