package com.epam.string.data.impl;

import com.epam.string.data.DataException;
import org.junit.Assert;
import org.junit.Test;

public class FileDataAcquirerTest {

    private final static String DATA = "src/test/resources/dataTestDataAcquirer.txt";
    private final static String FILE_NOT_EXIST = "src/test/resources/doesNotExist.txt";

    @Test
    public void testReadShouldReturnEqualObject() throws DataException {
        //given
        FileDataAcquirer dataAcquirer = new FileDataAcquirer(DATA);
        //when
        String actual = dataAcquirer.read();
        //then
        String expected = "abc abc abc";
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = DataException.class)
    public void testCreateShouldThrewExceptionWhenFileNotExist() throws DataException {
        //given
        FileDataAcquirer dataAcquirer = new FileDataAcquirer(FILE_NOT_EXIST);
        //when
        String actual = dataAcquirer.read();
    }

}