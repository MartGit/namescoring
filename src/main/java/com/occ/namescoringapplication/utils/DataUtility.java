package com.occ.namescoringapplication.utils;

import java.util.List;
import java.util.stream.Collectors;

public class DataUtility {

    public static List<String> removeQuotes(List<String> listWithQoutes) {

            return listWithQoutes.stream()
                    .map(s -> s.replaceAll("\"", ""))
                    .collect(Collectors.toList());
        }
}
