package ru.job4j.searchfiles.search.visitor;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularVisitor extends SearchVisitor {

    public RegularVisitor(String fileName) {
        super(fileName);
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Pattern compile = Pattern.compile(fileName);
        Matcher matcher = compile.matcher(file.getFileName().toString());
        if (matcher.find()) {
            findestFiles.add(file.toFile());
        }
        return FileVisitResult.CONTINUE;
    }
}
