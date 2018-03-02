package ru.job4j.tree.binarysearchtree;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleBinarySearchTreeTest {
    @Test
    public void whenWeAreAddSomeIntNumbersAndCheckIt() {
        SimpleBinarySearchTree<Integer> binarySearchTree = new SimpleBinarySearchTree<>();
        binarySearchTree.add(10);
        binarySearchTree.add(5);
        binarySearchTree.add(15);
        binarySearchTree.add(14);
        assertThat(binarySearchTree.getRoot().getElement(), is(10));
        assertThat(binarySearchTree.getRoot().getLeftChild().getElement(), is(5));
        assertThat(binarySearchTree.getRoot().getRightChild().getElement(), is(15));
        assertThat(binarySearchTree.getRoot().getRightChild().getLeftChild().getElement(),
                is(14));
    }


    @Test(expected = NoSuchElementException.class)
    public void iteratorMethodTestWithSome() {
        SimpleBinarySearchTree<Integer> binaryTree = new SimpleBinarySearchTree<>();
        binaryTree.add(10);
        binaryTree.add(5);
        binaryTree.add(15);
        binaryTree.add(14);
        Iterator<Integer> it = binaryTree.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(10));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(5));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(15));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(14));
        it.next();
    }
}