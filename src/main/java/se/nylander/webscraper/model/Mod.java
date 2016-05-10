package se.nylander.webscraper.model;

import javax.persistence.*;

/**
 * Created by erik.nylander on 2016-04-06.
 */
@Entity
@Table(name = "MODS")
public class Mod {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Double miniValue;

    private Double maxiValue;

    private String modName;

    private Integer modOrder;

    public Mod(String modName, Double miniValue, Double maxiValue, Integer modOrder){
        this.modName = modName;
        this.miniValue = miniValue;
        this.maxiValue = maxiValue;
        this.modOrder = modOrder;
    }

    public Mod(){}

    public Long getId() {
        return id;
    }

    public String getModName() {
        return modName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setModName(String modName) {
        this.modName = modName;
    }

    public void setMaxiValue(Double maxiValue) {
        this.maxiValue = maxiValue;
    }

    public void setMiniValue(Double miniValue) {
        this.miniValue = miniValue;
    }

    public Double getMaxiValue() {
        return maxiValue;
    }

    public Double getMiniValue() {
        return miniValue;
    }

    public Integer getModOrder() {
        return modOrder;
    }

    public void setModOrder(Integer modOrder) {
        this.modOrder = modOrder;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Mod){
            Mod mod = (Mod) obj;
            return this.modName.equals(mod.modName);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return modName.hashCode();
    }
}
