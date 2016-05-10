package se.nylander.webscraper.model;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by erik.nylander on 2016-02-22.
 */
@Entity
@Table(name = "SHOPS")
public class Shop implements Serializable{


    @Id
    private Long id;

    private String shopName;

    private String shopOwner;

    private String lastEdited;

    private String threadLink;

    private LocalDateTime timeOfIndexed;

    private String league;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TradeItem> tradeItems;


    public Shop(String shopName, String shopOwner, String lastEdited, String league, LocalDateTime timeOfIndexed){
        this.shopName = shopName;
        this.shopOwner = shopOwner;
        this.lastEdited = lastEdited;
        this.league = league;
        this.timeOfIndexed = timeOfIndexed;
    }

    public Shop() {
    }


    public List<TradeItem> getTradeItems() {
        return tradeItems;
    }

    public void setTradeItems(List<TradeItem> tradeItems) {
        this.tradeItems = tradeItems;
    }

    public String getLastEdited() {
        return lastEdited;
    }

    public String getShopName() {
        return shopName;
    }

    public String getShopOwner() {
        return shopOwner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLastEdited(String lastEdited) {
        this.lastEdited = lastEdited;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public void setShopOwner(String shopOwner) {
        this.shopOwner = shopOwner;
    }

    public LocalDateTime getTimeOfIndexed() {
        return timeOfIndexed;
    }

    public void setTimeOfIndexed(LocalDateTime timeOfIndexed) {
        this.timeOfIndexed = timeOfIndexed;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public String getThreadLink() {
        return threadLink;
    }

    public void setThreadLink(String threadLink) {
        this.threadLink = threadLink;
    }
}
