package ru.job4j.mapcollection.simplehashmap;

import org.junit.Test;


import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class SimpleHashMapTest {
    @Test
    public void whenWeAddASomeDifferentAndSomeSameElements() {
        SimpleHashMap<Integer, Integer> simpleHashMap = new SimpleHashMap<>();
        simpleHashMap.insert(1, 14);
        simpleHashMap.insert(2, 14);
        assertThat(simpleHashMap.insert(3, 123), is(true));
        assertThat(simpleHashMap.insert(1, 24), is(false));
        assertThat(simpleHashMap.insert(5, 24), is(true));

    }

    @Test(expected = IllegalStateException.class)
    public void whenWeAreTestingAGetMethodAndCompareResultWithExpectedValue() {
        SimpleHashMap<String, Integer> simpleHashMap = new SimpleHashMap<>();
        simpleHashMap.insert("Hello", 123);
        simpleHashMap.insert("world!", 214);
        assertThat(simpleHashMap.get("Hello"), is(123));
        assertThat(simpleHashMap.get("world!"), is(214));
        assertThat(simpleHashMap.get("worsld!"), is(11));

    }

    @Test
    public void whenTheArrayAreFullNowAndWeNeedANewArrayWithOverrideHashFunctionWithNewArraySize() {
        SimpleHashMap<Integer, Integer> simpleHashMap = new SimpleHashMap<>(2);
        int expectedArrSizeFirstIteration = 4;
        int secondIterationArrSize = 8;
        simpleHashMap.insert(1, 11);
        simpleHashMap.insert(2, 12);
        simpleHashMap.insert(3, 13);
        assertThat(simpleHashMap.getArrSize(), is(expectedArrSizeFirstIteration));
        assertThat(simpleHashMap.get(2), is(12));
        simpleHashMap.insert(4, 14);
        simpleHashMap.insert(5, 15);
        simpleHashMap.insert(6, 16);
        simpleHashMap.insert(7, 16);
        assertThat(simpleHashMap.getArrSize(), is(secondIterationArrSize));
        assertThat(simpleHashMap.get(2), is(12));

    }
    @Test
    public void whenWeAreRemovingElementsFromOurSimpleHashMapCollection() {
        SimpleHashMap<Integer, Integer> simpleHashMap = new SimpleHashMap<>();
        simpleHashMap.insert(1, 11);
        simpleHashMap.insert(2, 12);
        simpleHashMap.insert(3, 14);
        assertThat(simpleHashMap.delete(1), is(true));
        assertThat(simpleHashMap.delete(2), is(true));
        assertThat(simpleHashMap.delete(3), is(true));
        assertThat(simpleHashMap.delete(1), is(false));
        assertThat(simpleHashMap.delete(2), is(false));
        assertThat(simpleHashMap.delete(3), is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void keyAndValueIteratorInTheSameSimpleHashMap() {
        SimpleHashMap<Integer, Integer> hashMap = new SimpleHashMap<>();
        hashMap.insert(11, 11);
        hashMap.insert(125, 12);
        hashMap.insert(3, 13);
        hashMap.insert(4, 14);
        hashMap.insert(5, 15);
        Iterator<Integer> it = hashMap.keyIterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(5));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(11));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(125));
        assertThat(it.hasNext(), is(false));
        Iterator<Integer> sameHashMapValueIterator = hashMap.valueIterator();
        assertThat(sameHashMapValueIterator.next(), is(13));
        assertThat(sameHashMapValueIterator.hasNext(), is(true));
        assertThat(sameHashMapValueIterator.next(), is(14));
        assertThat(sameHashMapValueIterator.hasNext(), is(true));
        assertThat(sameHashMapValueIterator.next(), is(15));
        assertThat(sameHashMapValueIterator.hasNext(), is(true));
        assertThat(sameHashMapValueIterator.next(), is(11));
        assertThat(sameHashMapValueIterator.hasNext(), is(true));
        assertThat(sameHashMapValueIterator.next(), is(12));
        assertThat(sameHashMapValueIterator.hasNext(), is(false));
        sameHashMapValueIterator.next();
    }
}