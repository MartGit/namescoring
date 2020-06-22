package com.occ.namescoringapplication.processdata;

import java.util.List;

public interface ProcessDataService {

    List<Integer> calculateStoreForAList(List<String> allWords);

    Integer calculateeScoreForAllNames(List<Integer> allScores);
}
