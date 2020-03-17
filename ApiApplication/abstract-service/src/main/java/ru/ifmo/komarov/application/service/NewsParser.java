package ru.ifmo.komarov.application.service;

import java.io.IOException;
import java.util.List;

public interface NewsParser {
    String getName();
    List<String> parseHeadlines() throws IOException;
}
