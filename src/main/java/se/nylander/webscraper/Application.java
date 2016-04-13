package se.nylander.webscraper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import se.nylander.webscraper.dao.ShopDao;
import se.nylander.webscraper.dao.imp.ShopDaoImp;
import se.nylander.webscraper.parser.json.JsonParser;
import se.nylander.webscraper.parser.jsoup.ForumLeagueParser;
import se.nylander.webscraper.parser.jsoup.ForumThreadParser;
import se.nylander.webscraper.service.ShopService;
import se.nylander.webscraper.service.imp.ShopServiceImp;

/**
 * Created by erik.nylander on 2016-03-16.
 */


@SpringBootApplication
@EnableScheduling
public class Application {

    public static void main(String args[]) throws Exception{
        SpringApplication.run(Application.class);
    }

    @Bean
    public ForumLeagueParser forumLeagueParser() {
        return new ForumLeagueParser();
    }

    @Bean
    public ForumThreadParser forumThreadParser() {
        return new ForumThreadParser();
    }

    @Bean
    public ShopService shopService(){
        return new ShopServiceImp();
    }

    @Bean
    public ShopDao shopDao() {
        return new ShopDaoImp();
    }

    @Bean
    public JsonParser jsonParser(){
        return new JsonParser();
    }
}
