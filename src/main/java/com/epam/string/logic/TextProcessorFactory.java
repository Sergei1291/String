package com.epam.string.logic;

import com.epam.string.logic.impl.CharTextProcessor;
import com.epam.string.logic.impl.RegexTextProcessor;
import com.epam.string.logic.impl.StringTextProcessor;

public class TextProcessorFactory {

    public TextProcessor create(TextProcessorType type) {

        switch (type) {
            case CHAR:
                return new CharTextProcessor();
            case REGEX:
                return new RegexTextProcessor();
            case STRING:
                return new StringTextProcessor();
            default:
                throw new IllegalArgumentException("Incorrect TextProcessorType" + type);
        }

    }

}