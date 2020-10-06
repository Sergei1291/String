package com.epam.string;

import com.epam.string.data.DataAcquirer;
import com.epam.string.data.DataException;
import com.epam.string.data.factory.DataAcquirerFactory;
import com.epam.string.data.factory.FileDataAcquirerFactory;
import com.epam.string.logic.TextProcessor;
import com.epam.string.logic.TextProcessorFactory;
import com.epam.string.logic.TextProcessorType;
import com.epam.string.view.FilePrinter;
import com.epam.string.view.Printer;
import com.epam.string.view.ViewException;

public class Main {

    private final static String FILE_OUTPUT = "output.txt";

    public static void main(String[] args) throws DataException, ViewException {

        //acquire data text
        DataAcquirerFactory dataAcquirerFactory = new FileDataAcquirerFactory();
        DataAcquirer dataAcquirer = dataAcquirerFactory.createDataAcquirer();
        String text = dataAcquirer.read();

        //process data
        TextProcessorType textProcessorType = TextProcessorType.STRING;
        TextProcessorFactory textProcessorFactory = new TextProcessorFactory();
        TextProcessor textProcessor = textProcessorFactory.create(textProcessorType);

        int lengthWord = 3;
        String replacement = "KYKY";

        String processedData = textProcessor.process(text, lengthWord, replacement);

        //view result
        Printer printer = new FilePrinter(FILE_OUTPUT);
        printer.print(processedData);

    }

}