package se.nylander.webscraper.model;

import javax.persistence.*;

/**
 * Created by Cody on 2016-04-21.
 */
@Entity
@Table(name = "PROPERTIES")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String propName;

    private Double miniValue;

    private Double maxiValue;

    private String textValue;

    public Property(){}

    public String getTextValue() {
        return textValue;
    }

    public void setTextValue(String textValue) {
        this.textValue = textValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPropName() {
        return propName;
    }

    public void setPropName(String propName) {
        this.propName = propName;
    }

    public Double getMiniValue() {
        return miniValue;
    }

    public void setMiniValue(Double miniValue) {
        this.miniValue = miniValue;
    }

    public Double getMaxiValue() {
        return maxiValue;
    }

    public void setMaxiValue(Double maxiValue) {
        this.maxiValue = maxiValue;
    }
}
