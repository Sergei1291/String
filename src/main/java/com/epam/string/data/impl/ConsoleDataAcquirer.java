package com.epam.string.data.impl;

import com.epam.string.data.DataAcquirer;
import com.epam.string.data.DataException;

import java.util.Scanner;

public class ConsoleDataAcquirer implements DataAcquirer {

    @Override
    public String read() throws DataException {

        Scanner scanner = null;

        try {
            scanner = new Scanner(System.in);
            return scanner.nextLine();

        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

    }

}