package com.sidorov.test.word_processing;

import java.util.*;

public class WordProcessor implements WorkWithText {
    private static final char[] allVowels = {'а', 'е', 'ё', 'и', 'о', 'у', 'ы', 'э', 'ю', 'я',
            'А', 'Е', 'Ё', 'И', 'О', 'У', 'Ы', 'Э', 'Ю', 'Я'};

    @Override
    public int countNumberOfVowelsInText(String text) {
        int totalVowels = 0;

        for (char c : text.toCharArray()) {
            for (char vowel : allVowels) {
                if (c == vowel) {
                    totalVowels++;
                    break;
                }
            }
        }

        return totalVowels;
    }

    @Override
    public void printSortedToVowels(String text) {
        List<String> words = allWordsFromText(text);
        Map<String, Integer> wordVowelCounts = countVowelsInWords(words);
        List<String> sortedWords = sortWordsByVowelCount(words, wordVowelCounts);

        for (String word : sortedWords) {
            System.out.println(word + ": " + wordVowelCounts.get(word));
        }
    }
    private List<String> sortWordsByVowelCount(List<String> words, Map<String, Integer> wordVowelCounts) {
        Comparator<String> wordComparator = Comparator.comparingInt((String word) -> wordVowelCounts.get(word))
                .reversed()
                .thenComparingInt(words::indexOf);

        List<String> sortedWords = new ArrayList<>(words);
        sortedWords.sort(wordComparator);
        return sortedWords;
    }

    private Map<String, Integer> countVowelsInWords(List<String> words) {
        Map<String, Integer> wordVowelCounts = new HashMap<>();
        for (String word : words) {
            int count = countNumberOfVowelsInText(word);
            wordVowelCounts.put(word, count);
        }
        return wordVowelCounts;
    }

    private List<String> allWordsFromText(String text) {
        String[] words = text.split("\\s+");
        return new ArrayList<>(Arrays.asList(words));
    }
}
