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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SHOP_ID")
    private Shop shop;

    @Column(name = "CORRUPTED")
    private Boolean corrupted;

    @Column(name = "ITEM_TYPE")
    private String itemType;

    @Column(name = "LEVEL_REQ")
    private Integer levelRequirment;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Mod> mod = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemSocket> itemSockets = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Property> property = new ArrayList<>();

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

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public Integer getLevelRequirment() {
        return levelRequirment;
    }

    public void setLevelRequirment(Integer levelRequirment) {
        this.levelRequirment = levelRequirment;
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

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
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

    public Set<Mod> getMods() {
        return mod;
    }

    public List<Property> getProperty() {
        return property;
    }

    public void setProperty(List<Property> property) {
        this.property = property;
    }

    @Override
    public String toString() {
        return "TradeItem{" +
                "corrupted=" + corrupted +
                ", itemType='" + itemType + '\'' +
                ", levelRequirment=" + levelRequirment +
                ",\n itemSockets=" + itemSockets +
                ", league='" + league + '\'' +
                ", verified=" + verified +
                ",\n icon='" + icon + '\'' +
                ", identified=" + identified +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}' +
                "\n";
    }
}
