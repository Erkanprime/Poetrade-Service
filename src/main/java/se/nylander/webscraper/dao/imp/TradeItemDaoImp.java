package se.nylander.webscraper.dao.imp;

import org.springframework.stereotype.Repository;
import se.nylander.webscraper.dao.TradeItemDao;
import se.nylander.webscraper.model.Mod;
import se.nylander.webscraper.model.Property;
import se.nylander.webscraper.model.Requirement;
import se.nylander.webscraper.model.TradeItem;
import se.nylander.webscraper.model.request.ModRequest;
import se.nylander.webscraper.model.request.ParameterRequest;
import se.nylander.webscraper.model.request.RequirementRequest;
import se.nylander.webscraper.model.request.SocketRequest;
import se.nylander.webscraper.model.request.TradeItemRequest;

import javax.persistence.*;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.LinkedList;
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

        List<Predicate> predicates = new LinkedList<>();


        predicates.add(criteriaBuilder.equal(root.get("league"), request.getLeague()));

        if(request.getName() != null){
            predicates.add(criteriaBuilder.like(root.get("name"), "%"+request.getName()+"%"));
        }


        if(request.getType() != null){
            predicates.add(criteriaBuilder.equal(root.get("type"), request.getType()));
        }

        if(request.getBase() != null) {
            predicates.add(criteriaBuilder.equal(root.get("base"), request.getBase()));
        }


        if(request.getIdentified() != null){
            predicates.add(criteriaBuilder.equal(root.get("identified"), request.getIdentified()));
        }

        if(request.getCorrupted() != null){
            predicates.add(criteriaBuilder.equal(root.get("corrupted"), request.getCorrupted()));
        }

        if(request.getParameters().size() > 0){

            for(ParameterRequest p : request.getParameters()){
                Join<TradeItem, Property> prop = root.joinSet("property");

                predicates.add(
                        criteriaBuilder.and(
                            criteriaBuilder.equal(prop.get("propName"),p.getName()),
                            criteriaBuilder.ge(prop.get("miniValue"),p.getMinValue() == null ? 0 : p.getMinValue()),
                            criteriaBuilder.le(prop.get("maxiValue"),p.getMaxValue() == null ? 10000 : p.getMaxValue()))
                );

            }

        }
        if(request.getRequirements().size() > 0) {

            for (RequirementRequest r : request.getRequirements()) {
                Join<TradeItem, Requirement> req = root.joinSet("requirement");

                predicates.add(
                        criteriaBuilder.and(
                            criteriaBuilder.equal(req.get("reqName"), r.getName()),
                            criteriaBuilder.ge(req.get("reqValue"), r.getMinValue() == null ? 0 : r.getMinValue()),
                            criteriaBuilder.le(req.get("reqValue"), r.getMaxValue() == null ? 10000 : r.getMaxValue()))
                );

            }

        }

        if(request.getMods().size() > 0) {

            for (ModRequest m : request.getMods()) {

                Join<TradeItem, Mod> mod = root.joinSet("mod");
                predicates.add(
                        criteriaBuilder.and(
                            criteriaBuilder.equal(mod.get("modName"), m.getName()),
                            criteriaBuilder.ge(mod.get("miniValue"), m.getMinValue() == null ? 0 : m.getMinValue()),
                            criteriaBuilder.le(mod.get("maxiValue"), m.getMaxValue() == null ? 10000 : m.getMaxValue()))
                );

            }

        }

        cq.select(root)
                .where(predicates.toArray(new Predicate[predicates.size()]));

        TypedQuery<TradeItem> typedQuery = em.createQuery(cq);

        return Optional.of(typedQuery
                .setFirstResult(0)
                .setMaxResults(50)
                .getResultList()
        );

    }


}
