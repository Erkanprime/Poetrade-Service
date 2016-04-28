package se.nylander.webscraper.dao;

import se.nylander.webscraper.model.TradeItem;
import se.nylander.webscraper.model.request.TradeItemRequest;

import java.util.List;
import java.util.Optional;

/**
 * Created by erik.nylander on 2016-04-04.
 */
public interface TradeItemDao {

    Optional<List<TradeItem>> search(TradeItemRequest request);
}
