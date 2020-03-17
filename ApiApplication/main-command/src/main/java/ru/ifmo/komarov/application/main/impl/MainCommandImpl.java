package ru.ifmo.komarov.application.main.impl;

import org.osgi.service.component.annotations.*;
import osgi.enroute.debug.api.Debug;
import ru.ifmo.komarov.application.main.MainCommand;
import ru.ifmo.komarov.application.service.NewsParser;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Component(service = MainCommand.class, property = {Debug.COMMAND_SCOPE + "=news", Debug.COMMAND_FUNCTION + "=stats"})
public class MainCommandImpl implements MainCommand {

    private static Map<String, NewsParser> services = new HashMap<>();

    @Reference(
            service = NewsParser.class,
            cardinality = ReferenceCardinality.AT_LEAST_ONE,
            bind = "bindService",
            unbind = "unbindService"
    )
    private void bindService(NewsParser service) {
        services.put(service.getName(), service);
    }

    private void unbindService(NewsParser service) {
        services.remove(service.getName());
    }


    @Override
    public void stats() {
        if (services.isEmpty()) {
            System.out.println("something wrong with lenta/aif parsers");
            return;
        }
        int counter = 0;
        List<String> serviceList = new ArrayList<>();
        System.out.println("Available data sources:");
        System.out.println("(0) all");
        for (Map.Entry<String, NewsParser> entry : services.entrySet()) {
            counter++;
            System.out.println(String.format("(%s) %s", counter, entry.getKey()));
            serviceList.add(entry.getKey());
        }
        System.out.print("enter the desired number: ");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        int index = Integer.parseInt(answer) - 1;
        if (index == -1) {
            for (String service : serviceList) {
                printStats(service);
            }
            System.out.println();
        } else {
            stats(serviceList.get(index));
            System.out.println();
        }
    }

    @Override
    public void stats(String sourceName) {
        if (sourceName == null || !services.containsKey(sourceName)) {
            System.out.println("The specified data source is unavailable.");
            return;
        }
        printStats(sourceName);
    }

    @Override
    public void stats(String... args) {
        System.out.println("Wrong number of arguments. Expected 1, got " + args.length);
    }

    private void printStats(String serviceName) {
        try {
            System.out.println();
            System.out.println("\t" + serviceName);

            NewsParser service = services.get(serviceName);
            List<String> sortedWordList = sortHeadlines(service.parseHeadlines());

            for (int i = 0; i < sortedWordList.size(); i++) {
                System.out.println((i + 1) + ") " + sortedWordList.get(i));
            }
        } catch (IOException e) {
            System.out.println("bad URLConnection with " + serviceName);
            e.printStackTrace();
        }
    }

    private static List<String> sortHeadlines(List<String> headlines) {
        Map<String, Integer> wordMap = new HashMap<>();
        List<String> result = new ArrayList<>();

        for (String curHeadline : headlines) {

            String[] curHeadlineWords = curHeadline
                    .toLowerCase()
                    .replaceAll("[^a-zA-Zа-яА-Я]", " ")
                    .trim()
                    .split("\\s+");
            for (String word : curHeadlineWords) {
                if (word.length() > 5) { //words with length less than 5 aren't interesting
                    wordMap.merge(word, 1, Integer::sum);
                }
            }
        }
        List<Map.Entry<String, Integer>> tenEntries =
                wordMap
                        .entrySet()
                        .stream()
                        .sorted(Comparator.comparingInt(w -> -w.getValue()))
                        .limit(10)
                        .collect(Collectors.toList());
        for (Map.Entry<String, Integer> entry : tenEntries) {
            result.add(entry.getKey());
        }
        return result;
    }
}
