package se.nylander.webscraper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Cody on 2016-04-13.
 */
@Controller
@RequestMapping("/home")
public class TestController {

    @RequestMapping("/test")
    public String test(){
        return "index";
    }
}
