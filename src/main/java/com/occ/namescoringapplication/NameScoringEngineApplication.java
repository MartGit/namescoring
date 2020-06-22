package com.occ.namescoringapplication;

import com.occ.namescoringapplication.loaddata.LoadDataService;
import com.occ.namescoringapplication.loaddata.LoadDataServiceImpl;
import com.occ.namescoringapplication.preparedata.PrepareDataService;
import com.occ.namescoringapplication.preparedata.PrepareDataServiceImpl;
import com.occ.namescoringapplication.processdata.ProcessDataService;
import com.occ.namescoringapplication.processdata.ProcessDataServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class NameScoringEngineApplication implements CommandLineRunner {

    final static Logger LOGGER = LoggerFactory.getLogger(NameScoringEngineApplication.class);

    public static void main(String[] args) {

        try {


            for (String arg : args) {
                System.out.println("Args is " + arg);
            }

            SpringApplication.run(NameScoringEngineApplication.class, args);
        } catch (Exception e) {

            e.getMessage();

            LOGGER.info("You Are Required to Enter the Name File Path");
        }
    }

    @Bean
    public LoadDataService getHDataLoadService(){
        return  new LoadDataServiceImpl();
    }

    @Bean
    public PrepareDataService getHDataPrepareService(){
        return  new PrepareDataServiceImpl();
    }

    @Bean
    public ProcessDataService getHProcessDataService(){
        return  new ProcessDataServiceImpl();
    }

    @Override
    public void run(String... args) throws Exception {

        String loadedData = getHDataLoadService().loadData(args[0]);

        List<String> preparedData = getHDataPrepareService().prepareData(loadedData);

        LOGGER.info("List of Names are " + preparedData);

        List<Integer> listOfScores = getHProcessDataService().calculateStoreForAList(preparedData);

        LOGGER.info("List of Score Is " + listOfScores);

        Integer totalScore = getHProcessDataService().calculateeScoreForAllNames(listOfScores);

        LOGGER.info("Sum of All Scores " + totalScore);

    }

}
