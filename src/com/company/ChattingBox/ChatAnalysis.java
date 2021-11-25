package com.company.ChattingBox;

import java.util.*;

public class ChatAnalysis {

    private static List<List<String>> splittingWords(List <String> responseStorage){
        List <List<String>> splitWords = new ArrayList<>();
        for (String response : responseStorage){
            splitWords.add(List.of(response.toLowerCase().split(" ")));
        }
        return splitWords;
    }

    private static List<String> collapseListofList(List<List<String>> splitWords) {
        List<String> splitWordsCollapsed = new ArrayList<>();
        splitWords.forEach(splitWordsCollapsed::addAll);
        return splitWordsCollapsed;
    }

    private static HashSet<String> toMakeListWordsUnique(List<String> splitWordsCollapsed) {
        return new HashSet<>(splitWordsCollapsed);
    }

    public static HashMap<String, Integer> returnWordsWithFreq(List <String> responseStorage){
        List<List<String>> splitWords = splittingWords(responseStorage);
        List<String> splitWordsCollapsed = collapseListofList(splitWords);
        HashSet<String> uniqueWords = toMakeListWordsUnique(splitWordsCollapsed);
        HashMap <String, Integer> wordsAndFrequency = new HashMap<>();
        for (String wordInList : splitWordsCollapsed){
            Integer wordCount = 0;
            if (uniqueWords.contains(wordInList) && !wordsAndFrequency.containsKey(wordInList)){
                wordCount++;
                wordsAndFrequency.put(wordInList, wordCount);
            }else if (uniqueWords.contains(wordInList) && wordsAndFrequency.containsKey(wordInList)){
                wordCount = wordsAndFrequency.get(wordInList) + 1;
                wordsAndFrequency.put(wordInList, wordCount);
            }
        }
        return wordsAndFrequency;
    }


}
