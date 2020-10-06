package com.epam.string.logic.impl;

import com.epam.string.logic.TextProcessor;

public class CharTextProcessor implements TextProcessor {

    private final static int NUM_SYMBOL_A = 65;
    private final static int NUM_SYMBOL_Z = 90;
    private final static int NUM_SYMBOL_a = 97;
    private final static int NUM_SYMBOL_z = 122;

    @Override
    public String process(String data, int lengthWord, String replacement) {

        char[] dataSymbols = data.toCharArray();
        char[] replacementSymbols = replacement.toCharArray();
        char[] result = new char[0];

        int indexDataSymbols = 0;

        while (indexDataSymbols < dataSymbols.length) {

            if (isWordSymbol(dataSymbols[indexDataSymbols])) {

                int lengthCurrentWord = findLengthWord(dataSymbols, indexDataSymbols);

                if (lengthCurrentWord == lengthWord) {
                    //paste replacement
                    result = addArray(result, replacementSymbols);
                    indexDataSymbols = indexDataSymbols + lengthCurrentWord;
                } else {
                    //paste current word from dataSymbols
                    for (int i = 0; i < lengthCurrentWord; i++) {
                        result = addSymbol(result, dataSymbols[indexDataSymbols]);
                        indexDataSymbols++;
                    }
                }

            } else {
                //paste current symbol from dataSymbols
                result = addSymbol(result, dataSymbols[indexDataSymbols]);
                indexDataSymbols++;
            }

        }

        return new String(result);
    }

    private boolean isWordSymbol(char symbol) {

        boolean flagLowerLetter = (symbol >= NUM_SYMBOL_a) && (symbol <= NUM_SYMBOL_z);
        boolean flagUpperLetter = (symbol >= NUM_SYMBOL_A) && (symbol <= NUM_SYMBOL_Z);

        return (flagUpperLetter || flagLowerLetter);
    }

    private int findLengthWord(char[] data, int startPositionWord) {

        int lengthWord = 0;
        int index = startPositionWord;

        while ((index < data.length) && (isWordSymbol(data[index]))) {
            lengthWord++;
            index++;
        }

        return lengthWord;
    }

    private char[] addSymbol(char[] data, char symbol) {

        char[] result = new char[data.length + 1];

        for (int i = 0; i < data.length; i++) {
            result[i] = data[i];
        }

        int indexLastElement = result.length - 1;
        result[indexLastElement] = symbol;

        return result;
    }

    private char[] addArray(char[] data, char[] arraySymbols) {

        char[] result = data;

        for (int i = 0; i < arraySymbols.length; i++) {
            result = addSymbol(data, arraySymbols[i]);
        }

        return result;
    }

}