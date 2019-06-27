package ru.job4j.searchfiles.search.visitor;

import lombok.extern.slf4j.Slf4j;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

@Slf4j
public class FullMatchVisitor extends SearchVisitor {

    public FullMatchVisitor(String fileName) {
        super(fileName);
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        if (file.getFileName().toString().equals(fileName)) {
            findestFiles.add(file.toFile());
            return FileVisitResult.TERMINATE;
        } else {
            return FileVisitResult.CONTINUE;
        }
    }
}
