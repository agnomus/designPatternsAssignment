package net.media.training.live.dip;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;

public class NetworkAndDatabaseEncoder implements EncodingModule{
    public URL buildUrl(String protocol, String host, String file) {
        URL url = null;
        try {
            url = new URL(protocol, host, file);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }

    public InputStream getInputStream() {
        InputStream in = null;
        URL url = buildUrl("http", "myfirstappwith.appspot.com", "index.html");
        try {
            in = url.openStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return in;
    }

    public StringBuilder buildString(InputStream in) {
        InputStreamReader reader = new InputStreamReader(in);
        StringBuilder inputString1 = new StringBuilder();
        try {
            int c;
            c = reader.read();
            while (c != -1) {
                inputString1.append((char) c);
                c = reader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputString1;
    }

    @Override
    public void encode() {
        InputStream in = getInputStream();
        StringBuilder inputString1 = buildString(in);
        String inputString = inputString1.toString();
        String encodedString = Base64.getEncoder().encodeToString(inputString.getBytes());
        MyDatabase database = new MyDatabase();
        database.write(encodedString);
    }
}