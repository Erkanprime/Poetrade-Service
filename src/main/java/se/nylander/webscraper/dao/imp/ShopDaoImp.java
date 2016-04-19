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
      //  em.getEntityManagerFactory().getCache().evictAll();
    }

    @Override
    public Shop getLatestIndexed(String league) {
        Query q = em.createQuery("Select s from Shop s where s.league = :league order by s.timeOfIndexed desc", Shop.class);
        q.setParameter("league", league);
        q.setMaxResults(1);
        return (Shop) q.getResultList().get(0);
    }

    @Override
    public Shop getShopByThreadAndLeague(String league, String thread) {
        Query q = em.createQuery("Select s from Shop s where s.league = :league and s.threadLink = :threadLink", Shop.class);
        q.setParameter("league", league);
        q.setParameter("threadLink", thread);
        q.setMaxResults(1);
        return (Shop) q.getResultList().get(0);
    }

    @Override
    public void update(Shop shop) {
        em.merge(shop);
    }


}
