package se.nylander.webscraper.service.imp;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import se.nylander.webscraper.dao.ShopDao;
import se.nylander.webscraper.model.Shop;
import se.nylander.webscraper.service.ShopService;

import java.util.Optional;

/**
 * Created by erik.nylander on 2016-03-31.
 */
@Service
public class ShopServiceImp implements ShopService{

    private static Logger log = Logger.getLogger(ShopServiceImp.class);

    @Autowired
    @Qualifier("shopDao")
    private ShopDao shopDao;

    @Override
    public void saveOrUpdate(Shop shop) {
        Optional<Shop> optional = getShopByThreadAndLeague(shop.getLeague(), shop.getThreadLink());

        if(optional.isPresent()){
            log.info(shop.getThreadLink() + " Already exists, Merging shop...");
            shop.setId(optional.get().getId());
            shopDao.update(shop);
        }else {
            shopDao.save(shop);
        }
    }



    @Override
    public Optional<Shop> getLatestIndexed(String league) {
            try {
                return Optional.ofNullable(shopDao.getLatestIndexed(league));
            } catch (IndexOutOfBoundsException e) {
                return Optional.empty();
            }
    }

    @Override
    public Optional<Shop> getShopByThreadAndLeague(String league, String thread) {
        try {

            return Optional.ofNullable(shopDao.getShopByThreadAndLeague(league, thread));

        } catch (IndexOutOfBoundsException e) {
            return Optional.empty();
        }
    }

}
