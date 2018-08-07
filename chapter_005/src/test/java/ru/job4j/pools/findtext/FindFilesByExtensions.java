package ru.job4j.pools.findtext;

import org.junit.Test;
import ru.job4j.pools.findtext.findersimplementations.ExtensionsFinder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class FindFilesByExtensions {
    private final BlockingQueue<String> result = new LinkedBlockingQueue<>();

    @Test
    public void visitFile() throws IOException {
        List<String> exts = new ArrayList<>();
        String path = "/home/dar/Desktop/projects/parralelSearchExample";
        exts.add(".txt");
        exts.add(".xml");
        ExtensionsFinder extensionsFinder = new ExtensionsFinder(exts, result);
        Files.walkFileTree(Paths.get(path), extensionsFinder);
        assertThat(result.size(), is(6));

        exts.remove(".xml");
        Files.walkFileTree(Paths.get(path), extensionsFinder);
        assertThat(result.size(), is(4));

    }
}