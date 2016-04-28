package se.nylander.webscraper.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by erik.nylander on 2016-04-28.
 */
@Entity(name = "REQUIREMENT")
public class Requirement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String reqName;

    @Column
    private Double reqValue;

    public Requirement(){}

    public Requirement(String reqName, Double reqValue){
        this.reqName = reqName;
        this.reqValue = reqValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReqName() {
        return reqName;
    }

    public void setReqName(String reqName) {
        this.reqName = reqName;
    }

    public Double getReqValue() {
        return reqValue;
    }

    public void setReqValue(Double reqValue) {
        this.reqValue = reqValue;
    }
}
