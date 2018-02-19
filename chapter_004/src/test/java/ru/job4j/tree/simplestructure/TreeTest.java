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
        assertThat(tree.add(1, 7), is(false));
        assertThat(tree.add(1, 2), is(false));
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
    @Test
    public void checkTreeForBinaryResultBySummOfNodes() {
        Tree<Integer> integerTree = new Tree<>();
        integerTree.add(4, 1);
        integerTree.add(4, 2);
        assertThat(integerTree.isBinary(), is(true));
        integerTree.add(2, 4);
        integerTree.add(2, 5);
        integerTree.add(2, 7);
        assertThat(integerTree.isBinary(), is(false));
        Tree<Integer> deepDownTest = new Tree<>();
        deepDownTest.add(4, 1);
        deepDownTest.add(4, 3);
        deepDownTest.add(3, 5);
        deepDownTest.add(5, 2);
        deepDownTest.add(5, 12);
        deepDownTest.add(12, 13);
        deepDownTest.add(12, 15);
        assertThat(deepDownTest.isBinary(), is(true));
        deepDownTest.add(12, 19);
        assertThat(deepDownTest.isBinary(), is(false));
    }
}