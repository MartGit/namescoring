package com.occ.namescoringapplication.namescoringutil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Example {

    public static void main(String args[]) throws IOException {
        String filePath = null;
        if (args[0] == null || args[0].isEmpty()) {
            System.out.println("Please Enter the Names File Path Enclosed in Double Quotes");
        }
        else {
            filePath = args[0];
        }

        List<String> allLines = readAllLinesFromFile(filePath);
        allLines.forEach(System.out::println);
        System.out.println("**********************");

        List<String> listWithoutQuotes = removeQuotes(allLines);
        listWithoutQuotes.forEach(System.out::println);
        System.out.println("*****************");

        List<String> allWords = getAllWordsFromEachLineSorted(listWithoutQuotes);
        System.out.println(allWords);
        System.out.println("****************");

        List<Integer> scores = calculateStoreForAList(allWords);
        System.out.println(scores);
    }
    static List<String> readAllLinesFromFile(String fileName) throws IOException{
        return Files.readAllLines(Paths.get(fileName));
    }
    public static List<String> removeQuotes(List<String> listWithQoutes) {
        return listWithQoutes.stream()
                .map(s -> s.replaceAll("\"", ""))
                .collect(Collectors.toList());
    }
    public static List<String> getAllWordsFromEachLineSorted(List<String> lines) {
        return lines.stream()
                .map(s -> s.split("\\s*,\\s*"))
                .flatMap(Arrays::stream)
                .sorted()
                .collect(Collectors.toList());
    }

    static int calculateScore(String word){




        return word.chars()
                .map(i ->
                        {
                            if (i == 'A') {
                                i = 1;
                            } else if (i == 'B') {

                                i = 2;
                            } else if (i == 'C') {

                                i = 3;
                            } else if (i == 'D') {

                                i = 4;
                            } else if (i == 'E') {

                                i = 5;
                            } else if (i == 'F') {

                                i = 6;
                            } else if (i == 'G') {

                                i = 7;
                            } else if (i == 'H') {

                                i = 8;
                            } else if (i == 'I') {

                                i = 9;
                            } else if (i == 'J') {

                                i = 10;
                            } else if (i == 'K') {

                                i = 11;
                            } else if (i == 'L') {

                                i = 12;
                            } else if (i == 'M') {

                                i = 13;
                            } else if (i == 'N') {

                                i = 14;
                            } else if (i == 'O') {

                                i = 15;
                            } else if (i == 'P') {

                                i = 16;
                            } else if (i == 'Q') {

                                i = 17;
                            } else if (i == 'R') {

                                i = 18;
                            } else if (i == 'S') {

                                i = 19;
                            } else if (i == 'T') {

                                i = 20;
                            } else if (i == 'U') {

                                i = 21;
                            } else if (i == 'V') {

                                i = 21;
                            } else if (i == 'W') {

                                i = 23;
                            } else if (i == 'X') {

                                i = 24;
                            } else if (i == 'Y') {

                                i = 25;
                            } else if (i == 'Z') {

                                i = 26;
                            }
                            return i;
                        }

                )
                .sum();
    }

    static List<Integer> calculateStoreForAList(List<String> allWords){


        return allWords.stream()
                .map(str -> (calculateScore(str)* (allWords.indexOf(str)+1)))
                .collect(Collectors.toList());
    }
}
