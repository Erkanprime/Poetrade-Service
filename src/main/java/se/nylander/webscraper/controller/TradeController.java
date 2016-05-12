package se.nylander.webscraper.controller;

import jdk.nashorn.internal.runtime.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import se.nylander.webscraper.model.Shop;
import se.nylander.webscraper.model.TradeItem;
import se.nylander.webscraper.model.request.TradeItemRequest;
import se.nylander.webscraper.model.response.TradeItemResponse;
import se.nylander.webscraper.service.TradeItemService;

import java.util.ArrayList;
import java.util.List;


@Controller
public class TradeController {

    @Autowired
    @Qualifier("tradeService")
    private TradeItemService tradeItemService;

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<List<TradeItemResponse>> search(@RequestBody TradeItemRequest tradeItemRequest){
        List<TradeItemResponse> result = tradeItemService.search(tradeItemRequest);
        ResponseEntity<List<TradeItemResponse>> responseEntity;

        if(result.isEmpty()){
            responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            responseEntity = ResponseEntity.status(HttpStatus.OK).body(result);
        }

        return responseEntity;
    }




    @RequestMapping("/")
    public String home() {
        return "index";
    }


}
