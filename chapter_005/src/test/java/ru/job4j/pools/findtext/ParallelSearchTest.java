package ru.job4j.pools.findtext;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class ParallelSearchTest {

    private String pathToDir = "/home/dar/Desktop/projects/parralelSearchExample";
    private List<String> exts = new ArrayList<>();

    @Test
    public void firstTry() throws InterruptedException {
        exts.add(".txt");
        ParallelSearch parallelSearch = new ParallelSearch(pathToDir, "example", exts);
        parallelSearch.init();
        assertThat(parallelSearch.getFindestPath().size(), is(2));
    }

}