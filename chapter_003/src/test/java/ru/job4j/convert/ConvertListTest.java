package ru.job4j.convert;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 *
 */
public class ConvertListTest {
    /**
     * When input array ---> output List.
     */
    @Test
    public void whenInputArrayOutList() {
        ConvertList convertList = new ConvertList();
        List<Integer> result = convertList.toList(new int[][] {{1, 2, 3}, {4, 5, 6}});
        Integer[] prom = new Integer[] {1, 2, 3, 4, 5, 6};
        List<Integer> expected = Arrays.asList(prom);
        assertThat(result, is(expected));
    }

    /**
     * Input List from task example ---> output multiArr.
     */
    @Test
    public void whenFromOneListOutMultiArrFromTask() {
        ConvertList convertList = new ConvertList();
        Integer[] testInteger = new Integer[] {1, 2, 3, 4, 5, 6, 7};
        List<Integer> integerList = Arrays.asList(testInteger);
        int[][] result = convertList.toArray(integerList, 3);
        int[][] expected = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 0, 0}};
        assertThat(result, is(expected));
    }

    /**
     * Input List from me ---> output multiArr.
     */
    @Test
    public void whenFromOneInputListOutMultiArrFromMe() {
        ConvertList convertList = new ConvertList();
        Integer[] testInteger = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Integer> integerList = Arrays.asList(testInteger);
        int[][] result = convertList.toArray(integerList, 2);
        int[][] expected = new int[][] {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 0}};
        assertThat(result, is(expected));
    }

}
