package ru.job4j.searchfiles.search;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.searchfiles.search.visitor.MaskVisitor;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.hamcrest.core.Is.is;

public class MaskFinderTest {
    @Test
    public void findFilesByMask() throws IOException {
        String rootPath = ClassLoader.getSystemResource("finaltask").getPath();
        MaskVisitor maskFinder = new MaskVisitor("*.dot");
        Files.walkFileTree(Paths.get(rootPath), maskFinder);
        List<File> findestFiles = maskFinder.getFindestFiles();
        Assert.assertThat(findestFiles.size(), is(2));
        findestFiles.forEach(file -> Assert.assertThat(file.getName().endsWith(".dot"), is(true)));
    }
}