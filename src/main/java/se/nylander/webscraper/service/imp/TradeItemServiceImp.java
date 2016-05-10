package se.nylander.webscraper.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import se.nylander.webscraper.dao.TradeItemDao;
import se.nylander.webscraper.model.*;
import se.nylander.webscraper.model.request.TradeItemRequest;
import se.nylander.webscraper.model.response.SocketResponse;
import se.nylander.webscraper.model.response.TradeItemResponse;
import se.nylander.webscraper.service.TradeItemService;

import java.util.*;

/**
 * Created by erik.nylander on 2016-03-31.
 */
@Service
public class TradeItemServiceImp implements TradeItemService {

    @Autowired
    @Qualifier("tradeDao")
    private TradeItemDao tradeItemDao;

    @Override
    public List<TradeItemResponse> search(TradeItemRequest request) {
        Optional<List<TradeItem>> tradeItems = tradeItemDao.search(request);
        List<TradeItemResponse> tradeItemResponses = new ArrayList<>();
        if (tradeItems.isPresent()) {

            tradeItems.get().stream().forEach(tradeItem -> {
                TradeItemResponse response = new TradeItemResponse();
                response.setBase(tradeItem.getBase());
                response.setType(tradeItem.getType());
                response.setpDps(tradeItem.getpDps());
                response.seteDps(tradeItem.geteDps());
                response.setProperties(extractProperties(tradeItem.getProperty(), tradeItem.getType()));
                response.setRequirements(extractRequirements(tradeItem.getRequirement()));
                response.setMods(convertModsToString(tradeItem.getMod()));
                response.setShopOwner(tradeItem.getShopOwner());
                response.setPrice(tradeItem.getPrice());
                response.setIcon(tradeItem.getIcon());
                response.setIlvl(tradeItem.getiLvl());
                response.setIdentified(tradeItem.getIdentified());
                response.setCorrupted(tradeItem.getCorrupted());
                response.setVerified(tradeItem.getVerified());
                response.setName(tradeItem.getName());
                response.setSockets(extractSockets(tradeItem.getItemSockets()));
                response.setRarity(tradeItem.getRarity());
                tradeItemResponses.add(response);
            });

        }

        return tradeItemResponses;
    }

    private HashMap<String, String> extractProperties(Set<Property> properties, String type) {
        HashMap<String, String> map = new HashMap<>();

        properties.stream()
                .forEach(p -> {

                    if (!Objects.equals(p.getMiniValue(), p.getMaxiValue())) {
                        String propName = p.getPropName();

                        if(type.equalsIgnoreCase("Flask")){
                            propName = propName.replaceFirst("#", p.getMiniValue().toString().replace(".0", ""));
                            propName = propName.replaceFirst("#", p.getMaxiValue().toString().replace(".0", ""));
                            map.put(propName, null);
                        }else {
                            map.put(p.getPropName(), p.getMiniValue() + "-" + p.getMaxiValue());
                        }

                    } else {
                        if (p.getMiniValue() != null) {
                            if(type.equalsIgnoreCase("Flask")){
                                String propName = p.getPropName();
                                propName = propName.replaceFirst("#", p.getMiniValue().toString().replace(".0", ""));
                                map.put(propName, null);
                            }else{
                                map.put(p.getPropName(), p.getMiniValue().toString());
                            }
                        } else {
                            map.put(p.getPropName(), p.getTextValue() == null ? "": p.getTextValue());
                        }
                    }

                });

        return map;

    }

    private HashMap<String, Integer> extractRequirements(Set<Requirement> requirements) {
        HashMap<String, Integer> map = new HashMap<>();

        requirements.stream()
                .forEach(r -> map.put(r.getReqName(), r.getReqValue()));

        return map;
    }

    private List<String> convertModsToString(Set<Mod> mods) {
        List<String> stringMods = new ArrayList<>();
        for (Mod mod : mods) {
            String modText = mod.getModName();
            if (mod.getMiniValue() != null && mod.getMaxiValue() != null) {
                modText = modText.replaceFirst("#", mod.getMiniValue().toString().replace(".0", ""));
                modText = modText.replaceFirst("#", mod.getMaxiValue().toString().replace(".0", ""));
            }
            stringMods.add(modText);
        }
        return stringMods;
    }

    private List<SocketResponse> extractSockets(List<ItemSocket> sockets){
        List<SocketResponse> list = new ArrayList<>();
        sockets.stream().forEach(s -> list.add(new SocketResponse(s.getGroupId(),s.getColour())));
        return list;
    }
}
