package ru.salavatdautov.util;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

public class Request {
    public static final int BUFFER_SIZE = 8192;

    private final HttpURLConnection httpURLConnection;

    public Request(URL url) throws IOException {
        httpURLConnection = (HttpURLConnection) url.openConnection();
        setMethod("GET");
    }

    public Request(String url) throws IOException {
        this(new URL(url));
    }

    public void setMethod(String method) throws ProtocolException {
        httpURLConnection.setRequestMethod(method);
    }

    public void setProperty(String key, String value) {
        httpURLConnection.setRequestProperty(key, value);
    }

    public void connect() throws IOException {
        httpURLConnection.connect();
    }

    public int getStatus() throws IOException {
        return httpURLConnection.getResponseCode();
    }

    public String getContentType() {
        return httpURLConnection.getContentType();
    }

    public String getContentString() throws IOException {
        return Streams.toString(httpURLConnection.getInputStream());
    }

    public byte[] getContentBytes() throws IOException {
        return Streams.toByteArray(httpURLConnection.getInputStream());
    }

    public InputStream getInputStream() throws IOException {
        return httpURLConnection.getInputStream();
    }

    public void disconnect() {
        httpURLConnection.disconnect();
    }
}
