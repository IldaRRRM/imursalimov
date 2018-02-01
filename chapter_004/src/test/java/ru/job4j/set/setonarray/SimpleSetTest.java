package ru.job4j.set.setonarray;

import org.junit.Test;
import ru.job4j.set.setonarray.SimpleSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleSetTest {
    @Test
    public void whenWeAddAnEqualsElementsToSet() {
        SimpleSet<String> simpleSet = new SimpleSet<>();
        simpleSet.add("Hello");
        simpleSet.add("Hello");
        simpleSet.add("Hello");
        simpleSet.add("World");
        assertThat(simpleSet.get(1), is("World"));
    }
}