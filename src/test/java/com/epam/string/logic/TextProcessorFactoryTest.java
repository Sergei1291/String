package com.epam.string.logic;

import com.epam.string.logic.impl.CharTextProcessor;
import com.epam.string.logic.impl.RegexTextProcessor;
import com.epam.string.logic.impl.StringTextProcessor;
import org.junit.Assert;
import org.junit.Test;

public class TextProcessorFactoryTest {

    private final TextProcessorFactory textProcessorFactory = new TextProcessorFactory();

    @Test
    public void createShouldReturnCharArrayTextProcessor() {
        //given
        TextProcessorType type = TextProcessorType.CHAR;
        //when
        TextProcessor textProcessor = textProcessorFactory.create(type);
        //then
        Assert.assertEquals(textProcessor.getClass(), CharTextProcessor.class);
    }

    @Test
    public void createShouldReturnRegexTextProcessor() {
        //given
        TextProcessorType type = TextProcessorType.REGEX;
        //when
        TextProcessor textProcessor = textProcessorFactory.create(type);
        //then
        Assert.assertEquals(textProcessor.getClass(), RegexTextProcessor.class);
    }

    @Test
    public void createShouldReturnCharStringTextProcessor() {
        //given
        TextProcessorType type = TextProcessorType.STRING;
        //when
        TextProcessor textProcessor = textProcessorFactory.create(type);
        //then
        Assert.assertEquals(textProcessor.getClass(), StringTextProcessor.class);
    }

}