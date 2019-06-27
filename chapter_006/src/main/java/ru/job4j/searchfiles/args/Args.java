package ru.job4j.searchfiles.args;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.regex.Matcher;


@Slf4j
public class Args extends ru.job4j.archive.Args {
    public Args(String... args) {
        super(args);
    }

    @Override
    public File directory() {
        String regex = "-d (.*)(?= -n)";
        Matcher matcherFileDir = getMatcher(regex, argsString);
        if (matcherFileDir.find()) {
            String pathToFile = matcherFileDir.group(1);
            return new File(pathToFile);
        } else {
            throw new IllegalArgumentException(argsString + " doesent include expression: " + regex);
        }
    }

    public String getFileName() {
        String regex = "-n (.*)(?= -[r,m,f])";
        Matcher matcher = getMatcher(regex, argsString);
        if (matcher.find()) {
            return matcher.group(1);
        } else {
            throw new IllegalArgumentException(argsString + " doesent include stipulated key");
        }

    }


    public String getWordFindWay() {
        String max = "(-m)";
        String fullmatch = "(-f)";
        String reg = "(-r)";
        String fullRegex = max + "|" + fullmatch + "|" + reg;
        Matcher matcher = getMatcher(fullRegex, argsString);
        if (matcher.find()) {
            return matcher.group();
        } else {
            throw new IllegalArgumentException(argsString + " doesent include stipulated key");
        }
    }

    public String getWriteFileName() {
        String regex = "-o (\\w+[.][a-z]+)";
        Matcher matcher = getMatcher(regex, argsString);
        if (matcher.find()) {
            return matcher.group(1);
        } else {
            throw new IllegalArgumentException(argsString + " no key to file Name");
        }
    }
}



