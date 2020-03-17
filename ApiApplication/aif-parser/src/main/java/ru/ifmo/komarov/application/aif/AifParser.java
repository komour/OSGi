package ru.ifmo.komarov.application.aif;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import ru.ifmo.komarov.application.apihelper.ApiHelper;
import ru.ifmo.komarov.application.service.NewsParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component()
public class AifParser implements NewsParser {

    @Override
    public String getName() {
        return "aif.ru";
    }

    @Reference
    ApiHelper apiHelper;

    @Override
    public List<String> parseHeadlines() throws IOException {

        String data = apiHelper.get("https://aif.ru/rss/news.php");
        Document document = Jsoup.parse(data);
        Elements headlines = document.select("item > title");

        List<String> result = new ArrayList<>();
        for (Element headline : headlines) {
            String elem = headline.text();
            // remove <![CDATA[
            result.add(elem.substring(9, elem.length() - 3));
        }

        return result;

    }
}
