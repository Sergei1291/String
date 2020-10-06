package com.epam.string.data.factory;

import com.epam.string.data.DataAcquirer;
import com.epam.string.data.impl.FileDataAcquirer;

public class FileDataAcquirerFactory implements DataAcquirerFactory {

    private final static String FILE_DATA_INPUT = "data.txt";

    @Override
    public DataAcquirer createDataAcquirer() {

        return new FileDataAcquirer(FILE_DATA_INPUT);
    }

}