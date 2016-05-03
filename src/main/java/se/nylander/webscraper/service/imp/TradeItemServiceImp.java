package se.nylander.webscraper.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import se.nylander.webscraper.dao.TradeItemDao;
import se.nylander.webscraper.model.Mod;
import se.nylander.webscraper.model.Property;
import se.nylander.webscraper.model.Requirement;
import se.nylander.webscraper.model.TradeItem;
import se.nylander.webscraper.model.request.TradeItemRequest;
import se.nylander.webscraper.model.response.TradeItemResponse;
import se.nylander.webscraper.service.TradeItemService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Created by erik.nylander on 2016-03-31.
 */
@Service
public class TradeItemServiceImp implements TradeItemService{

    @Autowired
    @Qualifier("tradeDao")
    private TradeItemDao tradeItemDao;

    @Override
    public List<TradeItemResponse> search(TradeItemRequest request) {
        Optional<List<TradeItem>> tradeItems = tradeItemDao.search(request);
        List<TradeItemResponse> tradeItemResponses = new ArrayList<>();
        if(tradeItems.isPresent()){

            tradeItems.get().stream().forEach(tradeItem -> {
                TradeItemResponse response = new TradeItemResponse();
                response.setBase(tradeItem.getBase());
                response.setType(tradeItem.getType());
                response.setAps(extractPropValue("Attacks per Second", tradeItem.getProperty()));
                response.setDps(0d);
                response.setArmour(extractPropValue("Armour", tradeItem.getProperty()));
                response.setEvasion(extractPropValue("Evasion Rating", tradeItem.getProperty()));
                response.setEnergyshield(extractPropValue("Energy Shield", tradeItem.getProperty()));

                response.setQuality(extractPropValue("Quality", tradeItem.getProperty()));
                response.setStrengthReq(extractReqValue("Str", tradeItem.getRequirement()));
                response.setDexterityReq(extractReqValue("Dex", tradeItem.getRequirement()));
                response.setIntelligenceReq(extractReqValue("Int", tradeItem.getRequirement()));
                response.setLevelReq(extractReqValue("Level", tradeItem.getRequirement()));

                response.setMods(convertModsToString(tradeItem.getMod()));
                response.setFlavourText("Flavour Text");
                response.setShopOwner(tradeItem.getShopOwner());
                response.setPrice(tradeItem.getPrice());
                response.setIcon(tradeItem.getIcon());
                response.setIdentified(tradeItem.getIdentified());
                response.setCorrupted(tradeItem.getCorrupted());
                response.setVerified(tradeItem.getVerified());
                response.setName(tradeItem.getName());
                tradeItemResponses.add(response);
            });

        }

        return tradeItemResponses;
    }

    private Double extractPropValue(String propName, Set<Property> properties){
        return properties.stream()
                .filter(prop -> prop.getPropName().equalsIgnoreCase(propName))
                .map(Property::getMiniValue)
                .findFirst().orElse(0d);
    }

    private Double extractReqValue(String reqName, Set<Requirement> requirements){
        return requirements.stream()
                .filter(req -> req.getReqName().equalsIgnoreCase(reqName))
                .map(Requirement::getReqValue)
                .findFirst().orElse(0d);
    }

    private List<String> convertModsToString(Set<Mod> mods){
        List<String> stringMods = new ArrayList<>();
        for(Mod mod : mods){
            String modText = mod.getModName();
            if(mod.getMiniValue()!= null && mod.getMaxiValue() != null){
                modText = modText.replaceFirst("#", mod.getMiniValue().toString().replace(".0",""));
                modText = modText.replaceFirst("#", mod.getMaxiValue().toString().replace(".0",""));
            }
            stringMods.add(modText);
        }
        return stringMods;
    }
}
