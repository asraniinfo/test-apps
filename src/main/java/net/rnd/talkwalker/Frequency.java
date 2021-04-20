package net.rnd.talkwalker;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Frequency {

    private static Map<String, Integer> getFrequency(String text) {
        StringUtils.normalizeSpace(text);
        List<String> wordList = Arrays.asList(text.trim().replaceAll("\\s{2,}", " ").toUpperCase(Locale.ROOT).split(" "));
        Map<String, Integer> wordFrequency = new HashMap<>();
        wordList.parallelStream().distinct().forEach(word -> wordFrequency.put(word, Collections.frequency(wordList, word)));
        return wordFrequency;
    }

    private static Map<String, Integer> getFrequencyOld(String text) {
        String[] words = text.trim().replaceAll("\\s{2,}", " ").split(" ");
        Map<String, Integer> wordFrequency = new HashMap<>();
        Arrays.stream(words).forEach(word -> {
            if (wordFrequency.containsKey(word)) {
                wordFrequency.put(word, wordFrequency.get(word) + 1);
            } else {
                wordFrequency.put(word, 1);
            }
        });
        return wordFrequency;
    }

    public static void main(String[] ar) {
        long start = System.nanoTime();
        long finish = System.nanoTime();

        System.out.println(getFrequency("Ankit  Agrawal   Ankit Agrawal   Jain  Saurabh  jain").toString());
        long timeElapsed = finish - start;
        System.out.println("1st: " + timeElapsed);

        start = System.nanoTime();
        System.out.println(getFrequencyOld("Ankit  Agrawal   Ankit  Agrawal   Jain  Saurabh  jain").toString());
        finish = System.nanoTime();
        timeElapsed = finish - start;
        System.out.println("2nd: " + timeElapsed);

        System.out.println(new String(" hello     there   ").trim().replaceAll("\\s{2,}", " "));

    }
}
