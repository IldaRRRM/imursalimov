package ru.job4j.tracker.config;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class TrackerConfig {

    private final Properties properties;

    public TrackerConfig(String path) throws IOException {
        this.properties = new Properties();
        readProperties(path);
    }

    private void readProperties(String path) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)))) {
            this.properties.load(reader);
            log.info("Properties from {} has been read.", path);
        }
    }

    public String getUrl() {
        return this.properties.getProperty("url");
    }

    public String getUserName() {
        return this.properties.getProperty("username");
    }

    public String getPassword() {
        return this.properties.getProperty("password");
    }

    public String getDriverClassName() {
        return this.properties.getProperty("driver-class-name");
    }

    public String getPostgresAddres() {
        String regex = "(.*[\\d])";
        Pattern compile = Pattern.compile(regex);
        String url = this.properties.getProperty("url");
        Matcher matcher = compile.matcher(url);
        if (matcher.find()) {
            return matcher.group();
        } else {
            log.warn("No match by pattern = {} in Url = {} ", regex, url);
            log.warn("Return empty String!");
            return "";
        }
    }

    public String getDatabaseName() {
        String result = "";
        String regex = "\\w+$";
        String url = getUrl();
        Matcher matcher = Pattern.compile(regex).matcher(url);
        if (matcher.find()) {
            result = matcher.group();
        } else {
            log.warn("No match by pattern = {} in Url = {} ", regex, url);
            log.warn("Return empty String!");
        }
        return result;
    }
}
