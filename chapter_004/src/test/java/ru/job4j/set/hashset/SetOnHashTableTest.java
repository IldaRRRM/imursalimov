package ru.job4j.set.hashset;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SetOnHashTableTest {
    @Test
    public void whenWeAddAnElementToHashTableWithHashFunction() {
        SetOnHashTable<Integer> setOnHashTable = new SetOnHashTable<>(10);
        boolean result = setOnHashTable.add(1);
        boolean secondTry = setOnHashTable.add(1);
        assertThat(result, is(true));
        assertThat(secondTry, is(false));

    }

    @Test
    public void whenWeAddEqualsElementsToSetOnHashTable() {
        SetOnHashTable<Integer> set = new SetOnHashTable<>(10);
        Integer firstItem = 1;
        Integer second = 2;
        Integer third = 2;
        set.add(third);
        boolean result = set.add(firstItem);
        boolean wrongResult = set.add(second);
        assertThat(result, is(true));
        assertThat(wrongResult, is(false));

    }

    @Test
    public void methodForTestingContainsMethod() {
        SetOnHashTable<Integer> set = new SetOnHashTable<>(10);
        Integer firstItem = 1;
        Integer second = 2;
        Integer five = 5;
        set.add(firstItem);
        set.add(second);
        boolean result = set.contains(second);
        boolean wrongResult = set.contains(five);
        assertThat(result, is(true));
        assertThat(wrongResult, is(false));
    }

    @Test
    public void removeMethodInActionWithSomeElements() {
        SetOnHashTable<String> set = new SetOnHashTable<>(10);
        String firstItem = "First";
        String second = "Second";
        String five = "Five";
        set.add(firstItem);
        set.add(second);
        boolean rightResult = set.remove(second);
        boolean wrongResult = set.remove(five);
        assertThat(rightResult, is(true));
        assertThat(wrongResult, is(false));
    }

    @Test
    public void whenAnArrayIsFullAndWeAreCreatingANewArray() {
        SetOnHashTable<Integer> set = new SetOnHashTable<>(2);
        int expectedSize = 4;
        int secondIteration = 8;
        int lastIter = 16;
        set.add(1);
        set.add(2);
        assertThat(expectedSize, is(set.getArrSize()));
        set.add(7);
        set.add(8);
        set.add(9);
        assertThat(secondIteration, is(set.getArrSize()));
        set.add(10);
        set.add(11);
        set.add(12);
        assertThat(lastIter, is(set.getArrSize()));
    }
}