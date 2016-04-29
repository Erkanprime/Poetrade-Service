package se.nylander.webscraper.dao.imp;

import org.springframework.stereotype.Repository;
import se.nylander.webscraper.dao.TradeItemDao;
import se.nylander.webscraper.model.Mod;
import se.nylander.webscraper.model.TradeItem;
import se.nylander.webscraper.model.request.ModRequest;
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
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
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

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<TradeItem> cq = criteriaBuilder.createQuery(TradeItem.class);

        Root<TradeItem> root = cq.from(TradeItem.class);
        Join<TradeItem, Mod> mod = root.join("mod");
        Join<TradeItem, Mod> req = root.join("requirement");
        Join<TradeItem, Mod> prop = root.join("property");
        //Join<TradeItem, Mod> sockets = root.join("itemSockets");
        List<Predicate> predicates = new ArrayList<>();


        if(request.getName() != null){
            predicates.add(criteriaBuilder.like(root.get("name"), request.getName()));
        }

        predicates.add(criteriaBuilder.like(root.get("league"), request.getLeague()));

        if(request.getBase() != null) {
            predicates.add(criteriaBuilder.like(root.get("base"), request.getBase()));
        }

        if(request.getIdentified() != null){
            predicates.add(criteriaBuilder.equal(root.get("identified"), request.getIdentified()));
        }
        if(request.getCorrupted() != null){
            predicates.add(criteriaBuilder.equal(root.get("corrupted"), request.getCorrupted()));
        }

        for(ParameterRequest p : request.getParameters()){
            predicates.add(criteriaBuilder.equal(prop.get("propName"),p.getName()));
            predicates.add(criteriaBuilder.ge(prop.get("miniValue"),p.getMinValue() == null ? 0 : p.getMinValue()));
            predicates.add(criteriaBuilder.le(prop.get("maxiValue"),p.getMaxValue() == null ? 10000 : p.getMaxValue()));
        }
        for(RequirementRequest r : request.getRequirements()){
            predicates.add(criteriaBuilder.equal(req.get("reqName"),r.getName()));
            predicates.add(criteriaBuilder.ge(req.get("miniValue"),r.getMinValue() == null ? 0 : r.getMinValue()));
            predicates.add(criteriaBuilder.le(req.get("maxiValue"),r.getMaxValue() == null ? 10000 : r.getMaxValue()));
        }
        //TODO: Ändra sockets klassen
        for(ModRequest m :request.getMods()){
            predicates.add(criteriaBuilder.equal(mod.get("modName"), m.getName()));
            predicates.add(criteriaBuilder.ge(mod.get("miniValue"),m.getMinValue() == null ? 0 : m.getMinValue()));
            predicates.add(criteriaBuilder.le(mod.get("maxiValue"),m.getMaxValue() == null ? 10000 : m.getMaxValue()));
        }

        //List<Predicate> predicates = getQuery(request, criteriaBuilder, cq);

        for(Predicate predicate : predicates){
            cq.where(criteriaBuilder.and(predicate));
        }
        cq.distinct(true);


        List<TradeItem> items = em.createQuery(cq).getResultList();

        return null;
    }

    private List<Predicate> getQuery(TradeItemRequest request, CriteriaBuilder criteriaBuilder,  CriteriaQuery<TradeItem> cq){
        Root<TradeItem> root = cq.from(TradeItem.class);
        Join<TradeItem, Mod> mod = root.join("mod");
        Join<TradeItem, Mod> req = root.join("requirement");
        Join<TradeItem, Mod> prop = root.join("property");
        Join<TradeItem, Mod> sockets = root.join("itemSockets");
        List<Predicate> predicates = new ArrayList<>();


        if(request.getName() != null){
            predicates.add(criteriaBuilder.like(root.get("name"), request.getName()));
        }

        predicates.add(criteriaBuilder.like(root.get("league"), request.getLeague()));

        if(request.getBase() != null) {
            predicates.add(criteriaBuilder.like(root.get("itemType"), request.getBase()));
        }

        if(request.getIdentified() != null){
            predicates.add(criteriaBuilder.equal(root.get("identified"), request.getIdentified()));
        }
        if(request.getCorrupted() != null){
            predicates.add(criteriaBuilder.equal(root.get("corrupted"), request.getCorrupted()));
        }

        for(ParameterRequest p : request.getParameters()){
            predicates.add(criteriaBuilder.equal(prop.get("propName"),p.getName()));
            predicates.add(criteriaBuilder.ge(prop.get("miniValue"),p.getMinValue() == null ? 0 : p.getMinValue()));
            predicates.add(criteriaBuilder.le(prop.get("maxiValue"),p.getMaxValue() == null ? 10000 : p.getMaxValue()));
        }
        for(RequirementRequest r : request.getRequirements()){
            predicates.add(criteriaBuilder.equal(req.get("reqName"),r.getName()));
            predicates.add(criteriaBuilder.ge(req.get("miniValue"),r.getMinValue() == null ? 0 : r.getMinValue()));
            predicates.add(criteriaBuilder.le(req.get("maxiValue"),r.getMaxValue() == null ? 10000 : r.getMaxValue()));
        }
        //TODO: Ändra sockets klassen
        for(ModRequest m :request.getMods()){
            predicates.add(criteriaBuilder.equal(mod.get("modName"), m.getName()));
            predicates.add(criteriaBuilder.ge(mod.get("miniValue"),m.getMinValue() == null ? 0 : m.getMinValue()));
            predicates.add(criteriaBuilder.le(mod.get("maxiValue"),m.getMaxValue() == null ? 10000 : m.getMaxValue()));
        }

        return predicates;

    }


}
