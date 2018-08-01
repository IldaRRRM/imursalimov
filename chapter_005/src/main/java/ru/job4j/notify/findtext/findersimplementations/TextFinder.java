package ru.job4j.notify.findtext.findersimplementations;

import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.BlockingQueue;

public class TextFinder {
    private final String pathToFile;

    private final String text;

    private final BlockingQueue<String> resultsPath;

    public TextFinder(String pathToFile, String text, BlockingQueue<String> resultsPath) {
        this.pathToFile = pathToFile;
        this.text = text;
        this.resultsPath = resultsPath;
    }

    public void read() throws IOException {
        Path file = Paths.get(pathToFile);
        String innerContent = new String(Files.readAllBytes(file));
        if (innerContent.contains(text)) {
            resultsPath.add(file.toAbsolutePath().toString());
        }
    }
}
