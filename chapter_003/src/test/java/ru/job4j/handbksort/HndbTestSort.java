package ru.job4j.handbksort;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Created by ildar on 16.12.17.
 */
public class HndbTestSort {
    /**
     * Input String array ---> output Sorted Set(from less to High);
     */
    @Test
    public void whenReceivedStringArrayAndOutputSortedSetFromLessToHigh() {
        String[] stringArr = new String[] {
                "K1\\SK1",
                "K1\\SK2",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K2",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2"};
        HandBook handBook = new HandBook();
        Set<String> result = handBook.sortFromLessToHigh(stringArr);
        Set<String> expected = new TreeSet<>();
        String[] sortedArr = new String[] {
                "K1",
                "K1\\SK1",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K1\\SK2",
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2"};
        List<String> stringList = Arrays.asList(sortedArr);
        expected.addAll(stringList);
        assertThat(result, is(expected));
    }
    /**
     * input String array --> output sorted List from High to less.
     */
    @Test
    public void sortArrayFromHighToLessAndOutputSortedList() {
        String[] stringArr = new String[] {
                "K1\\SK1",
                "K1\\SK2",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K2",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2"};
        HandBook handBook = new HandBook();
        Set<String> prom = handBook.arraySortFromHighToLess(stringArr);
        Set<String> result = new LinkedHashSet<>();
        result.addAll(prom);
        String[] arrForExpect = new String[] {
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK2",
                "K2\\SK1\\SSK1",
                "K1",
                "K1\\SK2",
                "K1\\SK1",
                "K1\\SK1\\SSK2",
                "K1\\SK1\\SSK1"};
        List<String> forExp = Arrays.asList(arrForExpect);
        Set<String> expected = new LinkedHashSet<>();
        expected.addAll(forExp);
        assertThat(result, is(expected));
    }
}
