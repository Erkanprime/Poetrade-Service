package se.nylander.webscraper.dao.imp;

import org.springframework.stereotype.Repository;
import se.nylander.webscraper.dao.TradeItemDao;
import se.nylander.webscraper.model.TradeItem;
import se.nylander.webscraper.model.request.ParameterRequest;
import se.nylander.webscraper.model.request.RequirementRequest;
import se.nylander.webscraper.model.request.SocketRequest;
import se.nylander.webscraper.model.request.TradeItemRequest;

import javax.persistence.EntityManager;
import javax.persistence.Parameter;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

/**
 * Created by erik.nylander on 2016-04-04.
 */
@Repository
public class TradeItemDaoImp implements TradeItemDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public Optional<List<TradeItem>> search(TradeItemRequest request) {
        /*
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<TradeItem> cq = cb.createQuery(TradeItem.class);
        Root<TradeItem> item = cq.from(TradeItem.class);

        Predicate condition1 = cb.equal(item.get("name"), "Sol Gnarl");
        Predicate condition2 = cb.equal(item.get("league"), "Perandus");

        cq.where(condition1);
        cq.where(condition2);

        List<TradeItem> items = em.createQuery(cq).getResultList();
        */
        return null;
    }


}
