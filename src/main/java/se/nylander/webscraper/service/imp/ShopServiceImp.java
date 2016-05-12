package se.nylander.webscraper.service.imp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import se.nylander.webscraper.dao.ShopDao;
import se.nylander.webscraper.model.Shop;
import se.nylander.webscraper.service.ShopService;

/**
 * Created by erik.nylander on 2016-03-31.
 */
@Service
public class ShopServiceImp implements ShopService {


    @Autowired
    @Qualifier("shopDao")
    private ShopDao shopDao;

    @Override
    public void saveOrUpdate(Shop shop) {
        shopDao.update(shop);
    }


}
