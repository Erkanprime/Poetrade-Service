package se.nylander.webscraper.dao.imp;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.nylander.webscraper.dao.TradeItemDao;
import se.nylander.webscraper.model.*;
import se.nylander.webscraper.model.request.ModRequest;
import se.nylander.webscraper.model.request.PropertyRequest;
import se.nylander.webscraper.model.request.RequirementRequest;
import se.nylander.webscraper.model.request.TradeItemRequest;

import javax.persistence.*;
import javax.persistence.criteria.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * Created by erik.nylander on 2016-04-04.
 */
@Repository
@Transactional
public class TradeItemDaoImp implements TradeItemDao{

    private static final Double defaultMin = 0d;
    private static final Double defaultMax = 10000d;


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

        if(request.getRarity() != null) {
            predicates.add(criteriaBuilder.equal(root.get("rarity"), request.getRarity()));
        }

        if(request.getMinIlvl() != null){

            predicates.add(criteriaBuilder.ge(root.get("iLvl"), request.getMinIlvl()));
        }
        if(request.getMaxIlvl() != null){

            predicates.add(criteriaBuilder.le(root.get("iLvl"), request.getMaxIlvl()));
        }


        if(request.getIdentified() != null){
            predicates.add(criteriaBuilder.equal(root.get("identified"), request.getIdentified()));
        }

        if(request.getCorrupted() != null){
            predicates.add(criteriaBuilder.equal(root.get("corrupted"), request.getCorrupted()));
        }

        if(request.getMinPdps() != null){

            predicates.add(criteriaBuilder.ge(root.get("pDps"), request.getMinPdps()));
        }
        if(request.getMaxPdps() != null){

            predicates.add(criteriaBuilder.le(root.get("pDps"), request.getMaxPdps()));
        }
        if(request.getMinEdps() != null){

            predicates.add(criteriaBuilder.ge(root.get("eDps"), request.getMinEdps()));
        }
        if(request.getMaxEdps() != null){

            predicates.add(criteriaBuilder.le(root.get("eDps"), request.getMaxEdps()));
        }
        if(request.getSockets().getSocketMinValue() != null){
            predicates.add(
                    criteriaBuilder.ge(
                            criteriaBuilder.size(root.get("itemSockets")), request.getSockets().getSocketMinValue()
                    )

            );
        }
        if(request.getSockets().getSocketMaxValue() != null){
            predicates.add(
                    criteriaBuilder.le(
                            criteriaBuilder.size(root.get("itemSockets")), request.getSockets().getSocketMaxValue()
                    )

            );
        }

        if(request.getSockets().getLinksMinValue() != null){
            predicates.add(criteriaBuilder.ge(root.get("highestLink"), request.getSockets().getLinksMinValue()));
        }

        if(request.getSockets().getLinksMaxValue() != null){
            predicates.add(criteriaBuilder.le(root.get("highestLink"), request.getSockets().getLinksMaxValue()));
        }


        if(request.getProperties().size() > 0){

            for(PropertyRequest p : request.getProperties()){
                Join<TradeItem, Property> prop = root.joinSet("property");

                predicates.add(
                        criteriaBuilder.and(
                            criteriaBuilder.equal(prop.get("propName"),p.getName()),
                            criteriaBuilder.ge(prop.get("miniValue"),p.getMinValue() == null ? defaultMin : p.getMinValue()),
                            criteriaBuilder.le(prop.get("maxiValue"),p.getMaxValue() == null ? defaultMax : p.getMaxValue()))
                );

            }

        }
        if(request.getRequirements().size() > 0) {

            for (RequirementRequest r : request.getRequirements()) {
                Join<TradeItem, Requirement> req = root.joinSet("requirement");

                predicates.add(
                        criteriaBuilder.and(
                            criteriaBuilder.equal(req.get("reqName"), r.getName()),
                            criteriaBuilder.ge(req.get("reqValue"), r.getMinValue() == null ? defaultMin : r.getMinValue()),
                            criteriaBuilder.le(req.get("reqValue"), r.getMaxValue() == null ? defaultMax : r.getMaxValue()))
                );

            }

        }

        if(request.getMods().size() > 0) {

            for (ModRequest m : request.getMods()) {

                Join<TradeItem, Mod> mod = root.joinSet("mod");
                predicates.add(
                        criteriaBuilder.and(
                            criteriaBuilder.equal(mod.get("modName"), m.getName()),
                            criteriaBuilder.ge(mod.get("miniValue"), m.getMinValue() == null ? defaultMin : m.getMinValue()),
                            criteriaBuilder.le(mod.get("maxiValue"), m.getMaxValue() == null ? defaultMax : m.getMaxValue()))
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
