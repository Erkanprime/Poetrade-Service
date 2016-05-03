package se.nylander.webscraper.service;

import se.nylander.webscraper.model.request.TradeItemRequest;
import se.nylander.webscraper.model.response.TradeItemResponse;

import java.util.List;
import java.util.Optional;

/**
 * Created by erik.nylander on 2016-03-31.
 */
public interface TradeItemService {

    List<TradeItemResponse> search(TradeItemRequest request);

}
