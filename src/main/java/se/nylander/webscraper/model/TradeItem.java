package se.nylander.webscraper.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 * Created by erik.nylander on 2016-02-19.
 */
@Entity
@Table(name = "TRADEITEMS")
public class TradeItem implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String shopOwner;

    private Boolean corrupted;

    private String base;

    private String type;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("modOrder ASC")
    private Set<Mod> mod = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemSocket> itemSockets = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Property> property = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Requirement> requirement = new HashSet<>();

    private String league;

    private Boolean verified;

    @Column(length = 500)
    private String icon;

    private Boolean identified;

    private String name;

    private String price;

    private Integer iLvl;

    private Double pDps;

    private Double eDps;

    private Integer highestLink;

    private Integer rarity;

    public TradeItem(){}

    public String getPrice() { return price; }

    public void setPrice(String price) { this.price = price; }

    public Boolean getCorrupted() {
        return corrupted;
    }

    public void setCorrupted(Boolean corrupted) {
        this.corrupted = corrupted;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public List<ItemSocket> getItemSockets() {
        return itemSockets;
    }

    public void addItemSocket(Integer groupId, String colour) {
        this.itemSockets.add(new ItemSocket(colour, groupId));
    }

    public void setItemSockets(List<ItemSocket> itemSockets) {
        this.itemSockets = itemSockets;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Boolean getIdentified() {
        return identified;
    }

    public void setIdentified(Boolean identified) {
        this.identified = identified;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShopOwner() {
        return shopOwner;
    }

    public void setShopOwner(String shopOwner) {
        this.shopOwner = shopOwner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMod(Set<Mod> mods) {
        this.mod = mods;
    }

    public Set<Mod> getMod() {
        return mod;
    }

    public void addMod(Mod mod){
        this.mod.add(mod);
    }

    public Set<Property> getProperty() {
        return property;
    }

    public void setProperty(Set<Property> property) {
        this.property = property;
    }



    public Set<Requirement> getRequirement() {
        return requirement;
    }

    public void setRequirement(Set<Requirement> requirement) {
        this.requirement = requirement;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getiLvl() {
        return iLvl;
    }

    public void setiLvl(Integer iLvl) {
        this.iLvl = iLvl;
    }

    public Double getpDps() {
        return pDps;
    }

    public void setpDps(Double pDps) {
        this.pDps = pDps;
    }

    public Double geteDps() {
        return eDps;
    }

    public void seteDps(Double eDps) {
        this.eDps = eDps;
    }

    public Integer getHighestLink() {
        return highestLink;
    }

    public void setHighestLink(Integer highestLink) {
        this.highestLink = highestLink;
    }

    public Integer getRarity() {
        return rarity;
    }

    public void setRarity(Integer rarity) {
        this.rarity = rarity;
    }
}
