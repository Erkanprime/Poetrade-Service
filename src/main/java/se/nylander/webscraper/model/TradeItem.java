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
    @Column(name = "TRADEITEM_ID", nullable = false)
    private Long id;

    //@ManyToOne(fetch = FetchType.EAGER)
    //@JoinColumn(name = "SHOP_OWNER")
    @Column
    private String shopOwner;

    @Column(name = "CORRUPTED")
    private Boolean corrupted;

    @Column(name = "BASE")
    private String base;

    @Column(name = "TYPE")
    private String type;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Mod> mod = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ItemSocket> itemSockets = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Property> property = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Requirement> requirement = new HashSet<>();

    @Column(name = "LEAGUE")
    private String league;

    @Column(name = "VERIFIED")
    private Boolean verified;

    @Column(name = "ICON", length = 500)
    private String icon;

    @Column(name = "IDENTIFIED")
    private Boolean identified;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PRICE", nullable = true)
    private String price;


    public TradeItem(String league, String name) {
        this.league = league;
        this.name = name;
    }
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

    public Set<ItemSocket> getItemSockets() {
        return itemSockets;
    }

    public void addItemSocket(Integer groupId, String colour) {
        this.itemSockets.add(new ItemSocket(colour, groupId));
    }

    public void setItemSockets(Set<ItemSocket> itemSockets) {
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
}
