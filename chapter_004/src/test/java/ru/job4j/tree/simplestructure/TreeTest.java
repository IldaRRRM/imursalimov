package ru.job4j.tree.simplestructure;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TreeTest {
    @Test
    public void whenWeAddToOurTreeElementsEqualsAndDifferent() {
        Tree<Integer> tree = new Tree<>();
        tree.add(4, 1);
        tree.add(4, 2);
        assertThat(tree.add(2, 7), is(true));
        assertThat(tree.add(4, 2), is(false));
        assertThat(tree.findBy(4).isPresent(), is(true));
        assertThat(tree.findBy(8).isPresent(), is(false));
    }
    @Test(expected = NoSuchElementException.class)
    public void iteratorTestForSimpleTree() {
        Tree<Integer> integerTree = new Tree<>();
        integerTree.add(4, 1);
        integerTree.add(4, 2);
        integerTree.add(2, 3);
        integerTree.add(2, 4);
        integerTree.add(4, 7);
        integerTree.add(4, 9);
        Iterator<Integer> it = integerTree.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(7));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(9));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(false));
        it.next();
    }

}