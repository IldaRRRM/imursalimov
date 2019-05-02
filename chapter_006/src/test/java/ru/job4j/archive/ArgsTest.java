package ru.job4j.archive;

import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArgsTest {
    private final Args args = new Args("-d", "c:\\project", "-e", "*.csv", "*.java", "*.dot", "-o", "project.zip");

    @Test
    public void testArgsDirectory() {
        File file = args.directory();
        assertThat(file.getName(), is("c:\\project"));
    }

    @Test
    public void testExclude() {
        List<String> strings = args.excludeFiles();
        assertThat(strings.size(), is(3));
        assertThat(strings.get(0), is("*.csv"));
        assertThat(strings.get(1), is("*.java"));
        assertThat(strings.get(2), is("*.dot"));

    }

    @Test
    public void testOutput() {
        String output = args.output();
        assertThat(output, is("project.zip"));
    }

}