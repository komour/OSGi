package ru.ifmo.komarov.application.lenta;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import ru.ifmo.komarov.application.apihelper.ApiHelper;
import ru.ifmo.komarov.application.service.NewsParser;
import org.json.JSONObject;
import org.json.JSONArray;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component()
public class LentaParser implements NewsParser {

    @Override
    public String getName() {
        return "lenta.ru";
    }

    @Reference
    private ApiHelper apiHelper;

    @Override
    public List<String> parseHeadlines() throws IOException {
        String data = apiHelper.get("https://api.lenta.ru/lists/latest");

        JSONObject json = new JSONObject(data);
        JSONArray headlines = json.getJSONArray("headlines");

        List<String> result = new ArrayList<>();
        for (int i = 0; i < headlines.length(); i++) {
            result.add(headlines.getJSONObject(i).getJSONObject("info").getString("title"));
        }
        return result;
    }
}
