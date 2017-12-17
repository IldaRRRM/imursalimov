package ru.job4j.integercollection;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Created by ildar on 17.12.17.
 */
public class TestNestedArrays {
    @Test
    public void whenReceivedArraysSortedFromLessToHigh() {
        Integer[] expIntegers = new Integer[] {1, 2, 3};
        Integer[] integers1 = new Integer[] {6, 7, 7, 9, 13, 21, 45, 101, 102};
        List<Integer[]> expected = new ArrayList<>();
        expected.add(expIntegers);
        expected.add(integers1);
        List<Integer[]> promList = new ArrayList<>();
        promList.add(new Integer[] {2, 1, 3});
        promList.add(new Integer[] {13, 7, 6, 45, 21, 9, 101, 102, 7});
        NestedArrays nestedArrays = new NestedArrays();
        List<Integer[]> result = nestedArrays.sortFromLessToHigh(promList);
        assertThat(result.get(1), is(expected.get(1)));
        assertThat(result.get(0), is(expected.get(0)));
    }
    @Test
    public void whenReceivedListWithArraysSortedFromHighToLess() {
        Integer[] expIntegers = new Integer[] {3, 2, 1};
        Integer[] integers1 = new Integer[] {102, 101, 45, 21, 13, 9, 7, 7, 6};
        List<Integer[]> expected = new ArrayList<>();
        expected.add(expIntegers);
        expected.add(integers1);
        List<Integer[]> promList = new ArrayList<>();
        promList.add(new Integer[] {2, 1, 3});
        promList.add(new Integer[] {45, 101, 102, 6, 7, 7, 9, 13, 21});
        NestedArrays nestedArrays = new NestedArrays();
        List<Integer[]> result = nestedArrays.fromHighToLessMethod(promList);
        assertThat(result.get(1), is(expected.get(1)));
        assertThat(result.get(0), is(expected.get(0)));
    }
}
