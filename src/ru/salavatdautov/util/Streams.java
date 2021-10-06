package ru.salavatdautov.util;

import java.io.*;

/**
 * Library of functions for working with streams.
 */
public class Streams {
    /**
     * Buffer size 8 KB, in my opinion, optimal.
     */
    private static final int BUFFER_SIZE = 8192;

    /**
     * Private constructor so you can't create an object.
     */
    private Streams() {
    }

    /**
     * Convert data from InputStream to OutputStream.
     *
     * @param inputStream  source
     * @param outputStream destination
     */
    public static void copyInputStreamToOutputStream(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] buffer = new byte[BUFFER_SIZE];
        int length;
        while ((length = inputStream.read(buffer)) > 0) {
            outputStream.write(buffer, 0, length);
        }
    }

    /**
     * Convert data from OutputStream to InputStream.
     *
     * @param outputStream source
     * @return result InputStream
     */
    public static InputStream toInputStream(OutputStream outputStream) {
        return new ByteArrayInputStream(toByteArray(outputStream));
    }

    /**
     * Convert data from InputStream to byte[].
     *
     * @param inputStream source
     * @return result byte[]
     */
    public static byte[] toByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(BUFFER_SIZE);
        copyInputStreamToOutputStream(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    /**
     * Convert data from OutputStream to byte[].
     *
     * @param outputStream source
     * @return result byte[]
     */
    public static byte[] toByteArray(OutputStream outputStream) {
        return ((ByteArrayOutputStream) outputStream).toByteArray();
    }

    /**
     * Convert data from InputStream to String.
     *
     * @param inputStream source
     * @return result String
     */
    public static String toString(InputStream inputStream) throws IOException {
        return new String(toByteArray(inputStream));
    }

    /**
     * Convert data from OutputStream to String.
     *
     * @param outputStream source
     * @return result String
     */
    public static String toString(OutputStream outputStream) {
        return new String(toByteArray(outputStream));
    }
}
