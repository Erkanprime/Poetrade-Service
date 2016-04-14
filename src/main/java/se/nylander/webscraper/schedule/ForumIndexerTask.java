package se.nylander.webscraper.schedule;

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import se.nylander.webscraper.parser.jsoup.ForumLeagueParser;

/**
 * Created by erik.nylander on 2016-03-31.
 */

@Component
@EnableScheduling
public class ForumIndexerTask {

    private static Logger log = LoggerFactory.getLogger(ForumIndexerTask.class);

    @Autowired
    @Qualifier("forumLeagueParser")
    private ForumLeagueParser indexer;

    @Scheduled(fixedDelay = 60000 * 10)
    public void indexForumThreads() {
        BasicConfigurator.configure();
        log.info("\n###### Starting Indexer Schedule job ######\n");
        //ForumLeagueParser indexer = new ForumLeagueParser();
        indexer.initForumParsing();
        indexer.startForumParsing();
        log.info("###### Ending Indexer Schedule job ######");
    }

}
