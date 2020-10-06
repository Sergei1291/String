package com.epam.string.data.factory;

import com.epam.string.data.DataAcquirer;
import com.epam.string.data.impl.ConsoleDataAcquirer;

public class ConsoleDataAcquirerFactory implements DataAcquirerFactory {

    @Override
    public DataAcquirer createDataAcquirer() {

        return new ConsoleDataAcquirer();
    }

}