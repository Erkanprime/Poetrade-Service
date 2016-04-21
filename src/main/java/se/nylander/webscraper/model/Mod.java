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

    @Column
    private Double miniValue;

    @Column
    private Double maxiValue;

    @Column
    private String modName;

    public Mod(String modName, Double miniValue, Double maxiValue){
        this.modName = modName;
        this.miniValue = miniValue;
        this.maxiValue = maxiValue;
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
