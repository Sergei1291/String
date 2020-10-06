package com.epam.string.data.impl;

import com.epam.string.data.DataAcquirer;
import com.epam.string.data.DataException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileDataAcquirer implements DataAcquirer {

    private final String fileName;

    public FileDataAcquirer(String fileName) {

        this.fileName = fileName;
    }

    @Override
    public String read() throws DataException {

        FileReader reader = null;
        StringBuilder data = new StringBuilder();
        char[] currentSymbol = new char[1];

        try {

            reader = new FileReader(fileName);

            while (reader.read(currentSymbol) != (-1)) {
                data.append(currentSymbol);
            }

        } catch (FileNotFoundException e) {
            throw new DataException(e);
        } catch (IOException e) {
            throw new DataException(e);
        } finally {

            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace(); // log
                }
            }

        }

        return new String(data);
    }

}