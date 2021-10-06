package ru.salavatdautov.util;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Class for functions for work with arrays
 */
public class ArrayUtils {
    /**
     * Private constructor so you can't create an object.
     */
    private ArrayUtils() {
    }

    /**
     * Concatenate two arrays
     *
     * @param first  first array
     * @param second second array
     * @return result as Object[] containing elements from first and second arrays
     */
    public static Object[] concatenate(Object[] first, Object[] second) {
        return Stream.concat(Arrays.stream(first), Arrays.stream(second)).toArray(Object[]::new);
    }

    /**
     * @param bytes source byte array
     * @return int[] containing unsigned values
     */
    public static int[] toUnsigned(byte[] bytes) {
        int[] result = new int[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            result[i] = bytes[i] & 0xFF;
        }
        return result;
    }

    /**
     * Transform a byte array to hexadecimal string
     *
     * @param bytes source
     * @return hex String
     */
    public static String hexlify(byte[] bytes) {
        final char[] HEX_NUMBERS = "0123456789abcdef".toCharArray();
        char[] result = new char[bytes.length * 2];
        for (int i = 0; i < bytes.length; i++) {
            int v = bytes[i] & 0xFF;
            result[i * 2] = HEX_NUMBERS[v >>> 4];
            result[i * 2 + 1] = HEX_NUMBERS[v & 0x0F];
        }
        return new String(result);
    }

    public static byte[] removeFirstElements(byte[] array, int count) {
        return Arrays.copyOfRange(array, count, array.length);
    }
}
