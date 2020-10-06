package com.epam.string.view;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FilePrinter implements Printer {

    private final String fileName;

    public FilePrinter(String fileName) {

        this.fileName = fileName;
    }

    @Override
    public void print(String data) throws ViewException {

        BufferedWriter bufferedWriter = null;

        try {

            bufferedWriter = new BufferedWriter(new FileWriter(fileName));
            bufferedWriter.write(data);

        } catch (IOException e) {
            throw new ViewException(e);
        } finally {

            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace(); // log
                }
            }

        }

    }

}