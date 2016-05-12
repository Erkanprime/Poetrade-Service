package se.nylander.webscraper.dao.imp;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.nylander.webscraper.dao.ShopDao;
import se.nylander.webscraper.model.Shop;

import javax.persistence.*;

/**
 * Created by erik.nylander on 2016-04-04.
 */
@Repository
@Transactional
public class ShopDaoImp implements ShopDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Shop shop) {

        em.persist(shop);
    }


    @Override
    public void update(Shop shop) {
        em.merge(shop);
    }


}
