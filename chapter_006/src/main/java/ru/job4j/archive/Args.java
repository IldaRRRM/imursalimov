package ru.job4j.archive;

import lombok.Getter;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Args {
    @Getter
    protected final String argsString;

    public Args(String... args) {
        this.argsString = Arrays.toString(args).replaceAll(",", "");
    }

    /**
     * get directory from args, which will be archive
     *
     * @return directory
     */
    public File directory() {
        String regex = "-d (.*) (?=-e)";
        Matcher matcherFileDir = getMatcher(regex, argsString);
        if (matcherFileDir.find()) {
            String pathToFile = matcherFileDir.group(1);
            return new File(pathToFile);
        } else {
            throw new IllegalArgumentException(argsString + " doesent include expression: " + regex);
        }
    }

    /**
     * get list with exclude extensions of files from args, which does'nt arrive in archive
     *
     * @return list with exclude extensions
     */
    public List<String> excludeFiles() {
        List<String> excludeFiles = new ArrayList<>();
        String regex = "-e (.*) (?=-o)";
        Matcher fileExcludeMatcher = getMatcher(regex, argsString);
        if (fileExcludeMatcher.find()) {
            String group = fileExcludeMatcher.group(1);
            Matcher matcher = getMatcher("(\\S+)", group);
            while (matcher.find()) {
                excludeFiles.add(matcher.group());
            }
        }
        return excludeFiles;
    }

    /**
     * Get the folder to be archived
     *
     * @return path to Folder
     */
    public String output() {
        String regex = "-o (.*)[]]";
        Matcher matcher = getMatcher(regex, argsString);
        boolean findZipOutput = matcher.find();
        if (findZipOutput) {
            return matcher.group(1);
        } else {
            throw new IllegalArgumentException(argsString + " doesent include expression: " + regex);
        }
    }

    /**
     * get matcher to search exclude extensions from args
     *
     * @param regex      regex
     * @param argsString source String
     * @return Matcher
     */
    protected Matcher getMatcher(String regex, String argsString) {
        Pattern excludeStrings = Pattern.compile(regex);
        return excludeStrings.matcher(argsString);
    }
}
