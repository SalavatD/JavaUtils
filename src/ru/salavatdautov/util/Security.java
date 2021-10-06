package ru.salavatdautov.util;

import java.security.SecureRandom;

/**
 * Class for storing cryptographic functions
 */
public class Security {
    /**
     * Alphabet
     */
    private static final String ALPHANUM = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    /**
     * Cryptographically strong random number generator
     */
    private static final SecureRandom secureRandom = new SecureRandom();

    /**
     * Private constructor so you can't create an object.
     */
    private Security() {
    }

    /**
     * Generates a random string of the required length
     *
     * @param length required string length.
     * @return result String
     */
    public static String getRandomString(int length) {
        StringBuilder stringBuilder = new StringBuilder(length);
        for (int i = 0; i < length; i++)
            stringBuilder.append(ALPHANUM.charAt(secureRandom.nextInt(ALPHANUM.length())));
        return stringBuilder.toString();
    }
}
