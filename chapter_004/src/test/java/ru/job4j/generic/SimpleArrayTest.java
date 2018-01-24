package ru.job4j.generic;

import org.junit.Test;


import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleArrayTest {
    @Test
    public void whenWeTryToAddACoupleDifferentValuesAndEvrythIsOk() {
        SimpleArray<Integer> array = new SimpleArray<>(4);
        SimpleArray<String> stringSimpleArray = new SimpleArray<>(2);
        array.add(150);
        stringSimpleArray.add("Hello, world!");
        assertThat(array.get(0), is(150));
        assertThat(stringSimpleArray.get(0), is("Hello, world!"));

    }

    @Test
    public void getSomeValueFromOurIntegerAndStringArrays() {
        SimpleArray<String> stringSimpleArray = new SimpleArray<>(4);
        SimpleArray<Integer> integerArr = new SimpleArray<>(4);
        stringSimpleArray.add("Hello");
        stringSimpleArray.add("Beautiful");
        stringSimpleArray.add("World");
        integerArr.add(100);
        integerArr.add(400);
        integerArr.add(500);
        assertThat(integerArr.get(1), is(400));
        assertThat(stringSimpleArray.get(2), is("World"));

    }

    @Test
    public void deleteElementsFromOurArraysByIndex() {
        SimpleArray<String> stringSimpleArray = new SimpleArray<>(4);
        SimpleArray<Integer> integerArr = new SimpleArray<>(4);
        stringSimpleArray.add("Hello");
        stringSimpleArray.add("Beautiful");
        stringSimpleArray.add("World");
        integerArr.add(100);
        integerArr.add(400);
        integerArr.add(500);
        stringSimpleArray.delete(1);
        integerArr.delete(0);
        assertThat(integerArr.get(0), is(400));
        assertThat(stringSimpleArray.get(1), is("World"));
    }
    @Test(expected = NoSuchElementException.class)
    public void iteratorForOurSimpleArray() {
        SimpleArray<Integer> integerSimpleArray = new SimpleArray<>(5);
        integerSimpleArray.add(2);
        integerSimpleArray.add(3);
        integerSimpleArray.add(5);
        integerSimpleArray.add(7);
        integerSimpleArray.add(3571);
        Iterator<Integer> it = integerSimpleArray.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
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

}