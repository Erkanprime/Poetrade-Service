package se.nylander.webscraper.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.nylander.webscraper.dao.TradeItemDao;
import se.nylander.webscraper.service.TradeItemService;

/**
 * Created by erik.nylander on 2016-03-31.
 */
@Service
public class TradeItemServiceImp implements TradeItemService{

    @Autowired
    private TradeItemDao tradeItemDao;
}
