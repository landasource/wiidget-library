package com.landasource.wiidget.library.util;

import java.io.InputStream;
import java.util.Scanner;

/**
 * @author Zsolt Lengyel (zsolt.lengyel.it@gmail.com)
 */
public class StreamConverter {

    public static String toString(final InputStream inputStream) {

        // TODO support other encodings
        final Scanner scanner = new Scanner(inputStream, "UTF-8");

        final String inputStreamString = scanner.useDelimiter("\\A").next();

        scanner.close();

        return inputStreamString;
    }

}
