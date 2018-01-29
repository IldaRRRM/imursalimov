package ru.job4j.list.linkedlist;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PlainLinkedListTest {
    @Test
    public void testingSimpleLinkedListMethodsAddAndGet() {
        PlainLinkedList<Integer> plainLinkedList = new PlainLinkedList<>();
        for (int i = 0; i < 100; i++) {
            plainLinkedList.add(i);
        }
        assertThat(plainLinkedList.get(99), is(99));
    }
    @Test(expected = NoSuchElementException.class)
    public void iteratorInTheArrayListNextAndHasNext() {
        PlainLinkedList<Integer> integerSimpleArrList = new PlainLinkedList<>();
        integerSimpleArrList.add(2);
        integerSimpleArrList.add(3);
        integerSimpleArrList.add(5);
        integerSimpleArrList.add(7);
        integerSimpleArrList.add(3571);
        Iterator<Integer> it = integerSimpleArrList.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(5));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(7));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3571));
        assertThat(it.hasNext(), is(false));
        it.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenWeAreChangedInCycleArrThrowAnException() {
        PlainLinkedList<Integer> plainLinkedList = new PlainLinkedList<>();
        plainLinkedList.add(1);
        plainLinkedList.add(2);
        plainLinkedList.add(3);
        for (Integer olo : plainLinkedList) {
            plainLinkedList.add(olo);
        }
    }


}