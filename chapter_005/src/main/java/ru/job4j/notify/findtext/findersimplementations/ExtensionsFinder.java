package ru.job4j.notify.findtext.findersimplementations;

import ru.job4j.notify.findtext.ParallelSearch;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class ExtensionsFinder extends SimpleFileVisitor<Path> {


    private List<String> extensions;

    private final BlockingQueue<String> pathToFiles;

    public ExtensionsFinder(List<String> exts, BlockingQueue<String> pathToFiles) {
        this.extensions = exts;
        this.pathToFiles = pathToFiles;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        for (String currentExtension : extensions) {
            String nameOfFile = file.getFileName().toString();
            if (nameOfFile.contains(currentExtension)) {
                pathToFiles.add(file.toAbsolutePath().toString());
            }
        }
        return FileVisitResult.CONTINUE;
    }

}
