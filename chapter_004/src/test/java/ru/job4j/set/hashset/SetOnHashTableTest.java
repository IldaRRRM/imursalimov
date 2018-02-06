package ru.job4j.set.hashset;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SetOnHashTableTest {
    @Test
    public void whenWeAddAnElementToHashTableWithHashFunction() {
        SetOnHashTable<Integer> setOnHashTable = new SetOnHashTable<>(10);
        DataItem<Integer> dataItem = new DataItem<>(1);
        boolean result = setOnHashTable.add(dataItem);
        boolean secondTry = setOnHashTable.add(dataItem);
        assertThat(result, is(true));
        assertThat(secondTry, is(false));

    }

    @Test
    public void whenWeAddEqualsElementsToSetOnHashTable() {
        SetOnHashTable<Integer> set = new SetOnHashTable<>(10);
        DataItem<Integer> firstItem = new DataItem<>(1);
        DataItem<Integer> second = new DataItem<>(1);
        DataItem<Integer> third = new DataItem<>(2);
        set.add(third);
        boolean result = set.add(firstItem);
        boolean wrongResult = set.add(second);
        assertThat(result, is(true));
        assertThat(wrongResult, is(false));

    }

    @Test
    public void methodForTestingContainsMethod() {
        SetOnHashTable<Integer> set = new SetOnHashTable<>(10);
        DataItem<Integer> firstItem = new DataItem<>(1);
        DataItem<Integer> second = new DataItem<>(2);
        DataItem<Integer> five = new DataItem<>(5);
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
        DataItem<String> firstItem = new DataItem<>("First");
        DataItem<String> second = new DataItem<>("Second");
        DataItem<String> five = new DataItem<>("Five");
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
        set.add(new DataItem<>(1));
        set.add(new DataItem<>(2));
        assertThat(expectedSize, is(set.getArrSize()));
        set.add(new DataItem<>(7));
        set.add(new DataItem<>(8));
        set.add(new DataItem<>(9));
        assertThat(secondIteration, is(set.getArrSize()));
        set.add(new DataItem<>(10));
        set.add(new DataItem<>(11));
        set.add(new DataItem<>(12));
        assertThat(lastIter, is(set.getArrSize()));
    }
}