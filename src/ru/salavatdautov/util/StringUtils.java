package ru.salavatdautov.util;

/**
 * Class for functions for work with strings
 */
public class StringUtils {
    /**
     * Private constructor so you can't create an object.
     */
    private StringUtils() {
    }

    /**
     * Repeats the original string count times
     *
     * @param string source string
     * @param count  number of repetitions
     * @return result String
     */
    public static String createString(String string, int count) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            result.append(string);
        }
        return result.toString();
    }
}
