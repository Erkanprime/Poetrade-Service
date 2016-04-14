package se.nylander.webscraper.dao;

import se.nylander.webscraper.model.Shop;

/**
 * Created by erik.nylander on 2016-04-04.
 */
public interface ShopDao {

    void save(Shop shop);

    Shop getLatestIndexed(String league);

    Shop getShopByThreadAndLeague(String league, String thread);

    void update(Shop shop);
}
