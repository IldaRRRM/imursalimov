package ru.job4j.list.arrlist;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleArrListTest {
    @Test
    public void testingArrayListWithAddAndGet() {
        SimpleArrList<Integer> simpleArrList = new SimpleArrList<>();
        for (int i = 0; i < 10000; i++) {
            simpleArrList.add(i);
        }
        assertThat(simpleArrList.get(9999), is(9999));

    }

    @Test(expected = NoSuchElementException.class)
    public void iteratorInTheArrayListNextAndHasNext() {
        SimpleArrList<Integer> integerSimpleArrList = new SimpleArrList<>();
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
        SimpleArrList<Integer> simpleArrList = new SimpleArrList<>();
        simpleArrList.add(1);
        simpleArrList.add(2);
        simpleArrList.add(3);
        for (Integer olo : simpleArrList) {
            simpleArrList.add(olo);
        }
    }

}