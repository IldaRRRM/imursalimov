package ru.job4j.searchfiles.writer;

import org.junit.Test;
import ru.job4j.searchfiles.search.finder.FileFinder;
import ru.job4j.searchfiles.search.visitor.RegularVisitor;
import ru.job4j.searchfiles.search.visitor.SearchVisitor;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ResultsWriterTest {
    @Test
    public void writerTest() throws IOException {
        String testzipdirectory = ClassLoader.getSystemResource("finaltask").getPath();
        SearchVisitor visitor = new RegularVisitor(".txt");
        FileFinder finder = new FileFinder(visitor);
        List<File> files = finder.findFiles(testzipdirectory);

        ResultsWriter writer = new ResultsWriter(files);
        writer.writeToFile("test.txt");
    }
}