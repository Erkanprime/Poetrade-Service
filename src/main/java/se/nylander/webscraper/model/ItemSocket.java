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

    @Column(name = "COLOUR", nullable = true)
    private String colour;

    @Column(name = "GROUP_ID", nullable = true)
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

}
