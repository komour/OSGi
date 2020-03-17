package ru.ifmo.komarov.application.main;

public interface MainCommand {
    void stats();
    void stats(String sourceName);
    void stats (String... args);
}
