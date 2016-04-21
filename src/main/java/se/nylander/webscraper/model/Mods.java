package se.nylander.webscraper.model;

import javax.persistence.*;

/**
 * Created by erik.nylander on 2016-04-06.
 */
@Entity
@Table(name = "MODS")
public class Mods {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MOD_ID")
    private Long id;

    @Column(name = "MIN_VALUE", nullable = true)
    private Double minValue;

    @Column(name = "MAX_VALUE", nullable = true)
    private Double maxValue;

    @Column(name = "MOD_NAME")
    private String modName;



    public Mods(String modName, Double minValue, Double maxValue){
        this.modName = modName;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public Mods(){}

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

    public void setMaxValue(Double maxValue) {
        this.maxValue = maxValue;
    }

    public void setMinValue(Double minValue) {
        this.minValue = minValue;
    }

    public Double getMaxValue() {
        return maxValue;
    }

    public Double getMinValue() {
        return minValue;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Mods){
            Mods mod = (Mods) obj;
            return this.modName.equals(mod.modName);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return modName.hashCode();
    }
}
