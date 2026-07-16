package service;

import static constant.AppConstants.DELIMITERS;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Provides word and character counting logic.
 */
public class WordCountService {

    /**
     * Counts how many times each word appears.
     * Words are converted to lowercase before
     * counting.
     *
     * @param content the text to analyze
     * @return map of words to their counts
     */
    public Map<String, Integer> countWords(
            String content) {
        Map<String, Integer> wordMap =
                new HashMap<>();
        if (content == null
                || content.trim().isEmpty()) {
            return wordMap;
        }

        StringTokenizer tokenizer =
                new StringTokenizer(
                        content, DELIMITERS);
        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken()
                    .toLowerCase();
            wordMap.put(word,
                    wordMap.getOrDefault(word, 0)
                            + 1);
        }
        return wordMap;
    }

    /**
     * Counts how many times each character appears.
     * Space characters are ignored.
     *
     * @param content the text to analyze
     * @return map of characters to their counts
     */
    public Map<Character, Integer> countCharacters(
            String content) {
        Map<Character, Integer> charMap =
                new HashMap<>();
        if (content == null) {
            return charMap;
        }

        char[] characters = content.toCharArray();
        for (char ch : characters) {
            if (Character.isWhitespace(ch)) {
                continue;
            }
            charMap.put(ch,
                    charMap.getOrDefault(ch, 0) + 1);
        }
        return charMap;
    }
}
