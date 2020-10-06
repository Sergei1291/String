package com.epam.string.view;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FilePrinterTest {

    private final static String OUTPUT_FOR_TEST = "src/test/resources/outputFilePrinterTest.txt";

    @Test
    public void testPrintShouldWriteFile() throws ViewException {
        //given
        String data = "asd asd asd";
        FilePrinter filePrinter = new FilePrinter(OUTPUT_FOR_TEST);
        //when
        filePrinter.print(data);
        //then
        String expected = "asd asd asd";
        String actual = readFile(OUTPUT_FOR_TEST);
        Assert.assertEquals(expected, actual);
    }

    private String readFile(String fileName) throws ViewException {

        FileReader reader = null;
        StringBuilder fileTextBuilder = new StringBuilder();
        char[] currentSymbol = new char[1];

        try {

            reader = new FileReader(fileName);

            while (reader.read(currentSymbol) != (-1)) {
                fileTextBuilder.append(currentSymbol);
            }

        } catch (FileNotFoundException e) {
            throw new ViewException(e);
        } catch (IOException e) {
            throw new ViewException(e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        return new String(fileTextBuilder);
    }

}