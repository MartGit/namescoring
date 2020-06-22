package com.occ.namescoringapplication.processdata;

import com.occ.namescoringapplication.namescoringutil.NameScoringService;
import com.occ.namescoringapplication.namescoringutil.NameScoringServiceImpl;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.stream.Collectors;

public class ProcessDataServiceImpl implements ProcessDataService{


    @Bean
    public NameScoringService getHNameScoringService() {
        return  new NameScoringServiceImpl();
    }

    public List<Integer> calculateStoreForAList(List<String> allWords) {
         List<Integer> listOfScores = allWords.stream()
                .map(str -> getHNameScoringService().calculateScore(str)*(allWords.indexOf(str)+1))
                .collect(Collectors.toList());
        return listOfScores;
    }


   public Integer calculateeScoreForAllNames(List<Integer> allScores){
        return allScores.stream()
                .reduce(0, Integer::sum);
    }

}
