package com.occ.namescoringapplication.preparedata;

import com.occ.namescoringapplication.utils.DataUtility;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrepareDataServiceImpl implements PrepareDataService {

    public List<String> prepareData(String loadedData) {


        Stream<String> words = Stream.of(loadedData);


        List<String> letterWord = words.map(w -> w.split(","))
                .flatMap(Arrays::stream)
                .sorted()
                .collect(Collectors.toList());

        List<String> listWithoutQuotes = DataUtility.removeQuotes(letterWord);

        return listWithoutQuotes;

    }

}
