package se.nylander.webscraper.service.imp;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import se.nylander.webscraper.dao.ShopDao;
import se.nylander.webscraper.model.Shop;
import se.nylander.webscraper.schedule.ForumIndexerTask;
import se.nylander.webscraper.service.ShopService;

/**
 * Created by erik.nylander on 2016-03-31.
 */
@Service
public class ShopServiceImp implements ShopService {

    private static Logger log = LoggerFactory.getLogger(ShopServiceImp.class);

    @Autowired
    @Qualifier("shopDao")
    private ShopDao shopDao;

    @Override
    public void saveOrUpdate(Shop shop) {
        log.info("Saving shop : " + shop.getShopName()+ " with, " + shop.getTradeItems().size() + " tradeitems");
        shopDao.update(shop);
    }


}
