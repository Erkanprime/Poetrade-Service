package se.nylander.webscraper.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import se.nylander.webscraper.dao.TradeItemDao;
import se.nylander.webscraper.model.request.TradeItemRequest;
import se.nylander.webscraper.model.response.TradeItemResponse;
import se.nylander.webscraper.service.TradeItemService;

import java.util.List;

/**
 * Created by erik.nylander on 2016-03-31.
 */
@Service
public class TradeItemServiceImp implements TradeItemService{

    @Autowired
    @Qualifier("tradeDao")
    private TradeItemDao tradeItemDao;

    @Override
    public List<TradeItemResponse> search(TradeItemRequest request) {
        tradeItemDao.search(request);
        return null;
    }
}
