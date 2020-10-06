package com.epam.string.logic.impl;

import com.epam.string.logic.TextProcessor;

public class StringTextProcessor implements TextProcessor {

    private final static String NOT_WORD_ELEMENT = "[^a-zA-Z]+";
    private final static String WORD = "[a-zA-Z]+";

    @Override
    public String process(String text, int lengthWord, String replacement) {

        if (text.isEmpty()) {
            return text;
        }

        String[] words = text.split(NOT_WORD_ELEMENT);
        replace(words, lengthWord, replacement);
        String[] notWords = text.split(WORD);

        int quantityWord = words.length;
        int quantityNotWord = notWords.length;

        String processedText;

        if ((quantityWord == 1) && (quantityNotWord == 0)) {
            processedText = words[0];
        } else if ((quantityWord == 0) && (quantityNotWord == 1)) {
            processedText = notWords[0];
        } else if (quantityNotWord > quantityWord) {
            notWords = removeFirstElement(notWords);
            processedText = buildResult(words, notWords);
        } else if (quantityNotWord < quantityWord) {
            words = removeFirstElement(words);
            processedText = buildResult(notWords, words);
        } else {

            String firstSymbolText = text.substring(0, 1);
            boolean isLetterTextFirstSymbol = firstSymbolText.matches(WORD);

            if (isLetterTextFirstSymbol) {
                processedText = buildResult(notWords, words);
            } else {
                processedText = buildResult(words, notWords);
            }

        }

        return processedText;
    }

    private void replace(String[] words, int lengthWord, String replacement) {

        String currentWord;

        for (int i = 0; i < words.length; i++) {
            currentWord = words[i];
            if (currentWord.length() == lengthWord) {
                words[i] = replacement;
            }
        }

    }

    private String buildResult(String[] partOne, String[] partTwo) {

        StringBuilder resultBuilder = new StringBuilder();

        for (int i = 0; i < partOne.length; i++) {
            resultBuilder.append(partOne[i]);
            resultBuilder.append(partTwo[i]);
        }

        return new String(resultBuilder);
    }

    private String[] removeFirstElement(String[] data) {

        String[] result = new String[data.length - 1];

        for (int i = 1; i < data.length; i++) {
            result[i - 1] = data[i];
        }

        return result;
    }

}