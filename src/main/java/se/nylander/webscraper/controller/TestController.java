package se.nylander.webscraper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import se.nylander.webscraper.model.Shop;
import se.nylander.webscraper.model.TradeItem;
import se.nylander.webscraper.model.request.TradeItemRequest;
import se.nylander.webscraper.service.TradeItemService;

import java.util.ArrayList;
import java.util.List;


@Controller
public class TestController {

    @Autowired
    @Qualifier("tradeService")
    private TradeItemService tradeItemService;

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ResponseBody
    public List<TradeItem> search(@RequestBody TradeItemRequest tradeItemRequest){
        List<TradeItem> result = new ArrayList<>();
        tradeItemService.search(tradeItemRequest);
        return result;
    }

    @RequestMapping("/")
    public String home() {
        return "index";
    }

}
