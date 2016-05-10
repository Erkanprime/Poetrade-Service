package se.nylander.webscraper.model;

import javax.persistence.*;

/**
 * Created by erik.nylander on 2016-02-19.
 */
@Entity
@Table(name = "ITEMSOCKETS")
public class ItemSocket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String colour;

    private Integer groupId;

    public ItemSocket(String color, Integer groupId){
        this.colour = color;
        this.groupId = groupId;
    }

    public ItemSocket() {
    }


    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemSocket that = (ItemSocket) o;

        return groupId != null ? groupId.equals(that.groupId) : that.groupId == null;

    }

    @Override
    public int hashCode() {
        return  31 * (groupId != null ? groupId.hashCode() : 0);
    }
}
