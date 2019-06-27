package ru.job4j.searchfiles.search.visitor;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class MaskVisitor extends SearchVisitor {

    private final String cleanFileName;

    public MaskVisitor(String fileName) {
        super(fileName);

        cleanFileName = fileName.replace("*", "");
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (file.getFileName().toString().endsWith(cleanFileName)) {
            findestFiles.add(file.toFile());
        }
        return FileVisitResult.CONTINUE;
    }


}
