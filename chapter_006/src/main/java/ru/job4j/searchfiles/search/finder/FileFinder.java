package ru.job4j.searchfiles.search.finder;

import ru.job4j.searchfiles.search.visitor.SearchVisitor;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileFinder {
    private final SearchVisitor visitor;

    public FileFinder(SearchVisitor visitor) {
        this.visitor = visitor;
    }

    public List<File> findFiles(String rootPath) throws IOException {
        Files.walkFileTree(Paths.get(rootPath), visitor);
        return visitor.getFindestFiles();
    }
}
