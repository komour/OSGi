package ru.ifmo.komarov.application.apihelper.impl;

import org.osgi.service.component.annotations.Component;
import ru.ifmo.komarov.application.apihelper.ApiHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

@Component()
public class ApiHelperImpl implements ApiHelper {

    public String get(String URLName) throws IOException {
        URL url = new URL(URLName);
        URLConnection urlConnection = url.openConnection();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

        StringBuilder content = new StringBuilder();
        String line;

        while ((line = bufferedReader.readLine()) != null) {
            content.append(line).append("\n");
        }
        bufferedReader.close();

        return content.toString();
    }

}
