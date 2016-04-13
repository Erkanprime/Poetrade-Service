package se.nylander.webscraper.service;

import se.nylander.webscraper.model.Shop;

import java.util.Optional;

/**
 * Created by erik.nylander on 2016-03-31.
 */
public interface ShopService {

    void saveOrUpdate(Shop shop);

    Optional<Shop> getLatestIndexed(String league);

    Optional<Shop> getShopByThreadAndLeague(String league, String thread);


}
