package ru.job4j.set.linkedset;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleSetOnLinkedTest {
    @Test(expected = NoSuchElementException.class)
    public void addDifferentElementsToSetBasedOnLinkedList() {
        SimpleSetOnLinked<Integer> simpleSetOnLinked = new SimpleSetOnLinked<>();
        Iterator<Integer> integerIterator = simpleSetOnLinked.iterator();
        simpleSetOnLinked.add(7);
        simpleSetOnLinked.add(7);
        simpleSetOnLinked.add(4);
        simpleSetOnLinked.add(1);
        simpleSetOnLinked.add(4);
        simpleSetOnLinked.add(1);
        simpleSetOnLinked.add(7);
        simpleSetOnLinked.add(5);
        simpleSetOnLinked.add(1);
        assertThat(integerIterator.next(), is(7));
        assertThat(integerIterator.next(), is(4));
        assertThat(integerIterator.next(), is(1));
        assertThat(integerIterator.next(), is(5));
        integerIterator.next();
    }
}