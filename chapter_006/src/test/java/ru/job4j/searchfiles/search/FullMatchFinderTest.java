package ru.job4j.searchfiles.search;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.searchfiles.search.visitor.FullMatchVisitor;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.hamcrest.core.Is.is;

public class FullMatchFinderTest {

    @Test
    public void testFinder() throws IOException {
        String testzipdirectory = ClassLoader.getSystemResource("finaltask").getPath();
        FullMatchVisitor fullMatchFinder = new FullMatchVisitor("partDrdr.dot");
        Files.walkFileTree(Paths.get(testzipdirectory), fullMatchFinder);
        List<File> findestFiles = fullMatchFinder.getFindestFiles();
        Assert.assertThat(findestFiles.get(0).getName(), is("partDrdr.dot"));

    }

}