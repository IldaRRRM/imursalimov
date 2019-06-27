package ru.job4j.searchfiles.search;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.searchfiles.search.visitor.RegularVisitor;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.hamcrest.core.Is.is;

public class RegularFinderTest {

    @Test
    public void regFinderTest() throws IOException {
        String finaltask = ClassLoader.getSystemResource("finaltask").getPath();
        RegularVisitor finder = new RegularVisitor("^part*");
        Files.walkFileTree(Paths.get(finaltask), finder);
        List<File> findestFiles = finder.getFindestFiles();
        Assert.assertThat(findestFiles.size(), is(3));
        findestFiles.forEach(file -> Assert.assertThat(file.getName().contains("part"), is(true)));

    }
}