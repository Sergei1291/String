package com.epam.string.logic.impl;

import org.junit.Assert;
import org.junit.Test;

public class RegexTextProcessorTest {

    private final RegexTextProcessor regexTextProcessor = new RegexTextProcessor();

    @Test
    public void processShouldReturnEqualStringWhenDataIsEmpty() {
        //given
        String data = "";
        int lengthWord = 3;
        String replacement = "R";
        //when
        String actual = regexTextProcessor.process(data, lengthWord, replacement);
        //then
        String expected = "";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void processShouldReturnEqualStringWhenDataNotWord() {
        //given
        String data = "123";
        int lengthWord = 3;
        String replacement = "R";
        //when
        String actual = regexTextProcessor.process(data, lengthWord, replacement);
        //then
        String expected = "123";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void processShouldReturnEqualStringWhenDataWord() {
        //given
        String data = "aaa";
        int lengthWord = 3;
        String replacement = "R";
        //when
        String actual = regexTextProcessor.process(data, lengthWord, replacement);
        //then
        String expected = "R";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void processShouldReturnEqualStringWithoutChanges() {
        //given
        String data = "aaa aaaa aaaaa aaaaaa a";
        int lengthWord = 2;
        String replacement = "R";
        //when
        String actual = regexTextProcessor.process(data, lengthWord, replacement);
        //then
        String expected = "aaa aaaa aaaaa aaaaaa a";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void processShouldReturnEqualStringWhenDataWordNotWord() {
        //given
        String data = "a aaa aaaa aaaaa aaaaaa!";
        int lengthWord = 3;
        String replacement = "R";
        //when
        String actual = regexTextProcessor.process(data, lengthWord, replacement);
        //then
        String expected = "a R aaaa aaaaa aaaaaa!";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void processShouldReturnEqualStringWhenDataNotWordWord() {
        //given
        String data = "4a aaa aaaa aaaaa aaaaaa";
        int lengthWord = 5;
        String replacement = "R";
        //when
        String actual = regexTextProcessor.process(data, lengthWord, replacement);
        //then
        String expected = "4a aaa aaaa R aaaaaa";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void processShouldReturnEqualStringWhenDataWordNotWordWord() {
        //given
        String data = "a aaa aaaa aaaaa aaaaaa aaa";
        int lengthWord = 3;
        String replacement = "R";
        //when
        String actual = regexTextProcessor.process(data, lengthWord, replacement);
        //then
        String expected = "a R aaaa aaaaa aaaaaa R";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void processShouldReturnEqualStringWhenDataNotWordWordNotWord() {
        //given
        String data = "4a aaa aaaa aaaaa aaaaaa!";
        int lengthWord = 5;
        String replacement = "R";
        //when
        String actual = regexTextProcessor.process(data, lengthWord, replacement);
        //then
        String expected = "4a aaa aaaa R aaaaaa!";
        Assert.assertEquals(expected, actual);
    }

}