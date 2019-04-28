package ru.job4j.config;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.StringJoiner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Slf4j
public class Config {
    @Getter
    private final String path;
    private final Map<String, String> values = new ConcurrentHashMap<>();
    private final ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());


    public Config(String path) {
        this.path = path;
    }

    /**
     * Fill map by params from properties
     */
    public void load() throws InterruptedException {
        try (BufferedReader reader = new BufferedReader(new FileReader(this.path))) {
            ArrayList<String> strings = reader.lines().filter(s -> s.matches(".[^#]*")).collect(Collectors.toCollection(ArrayList::new));
            Pattern pattern = Pattern.compile("(.*)=(.*)");
            for (String currentLine : strings) {
                pool.submit(() -> {
                    Matcher matcher = pattern.matcher(currentLine);
                    while (matcher.find()) {
                        values.put(matcher.group(1), matcher.group(2));

                    }

                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (pool.isTerminated()) {
            log.info("All tasks is Done");
        } else {
            pool.awaitTermination(500, TimeUnit.MILLISECONDS);
            log.info("All tasks is Done");
        }
    }

    /**
     * Get value from config map
     *
     * @param key from map
     * @return value from map
     */
    public String value(String key) {
        return this.values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader reader = new BufferedReader(new FileReader(this.path))) {
            reader.lines().forEach(out::add);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }
}
