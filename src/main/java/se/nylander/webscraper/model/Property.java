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

    @Column
    private String propName;

    @Column
    private Double miniValue;

    @Column
    private Double maxiValue;

    @Column
    private String textValue;

    @Column
    private Boolean isNumberValue;

    public Property(){}

    public Boolean getNumberValue() {
        return isNumberValue;
    }

    public void setNumberValue(Boolean numberValue) {
        isNumberValue = numberValue;
    }

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
