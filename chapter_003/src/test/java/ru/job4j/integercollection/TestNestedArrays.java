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
        Integer[] expIntegers = new Integer[] {1, 1, 1};
        Integer[] integers1 = new Integer[] {1, 1, 2};
        Integer[] nextIntegers = new Integer[] {1, 1, 3};
        List<Integer[]> expected = new ArrayList<>();
        expected.add(expIntegers);
        expected.add(integers1);
        expected.add(nextIntegers);
        List<Integer[]> resultList = new ArrayList<>();
        resultList.add(new Integer[] {1, 1, 3});
        resultList.add(new Integer[] {1, 1, 1});
        resultList.add(new Integer[] {1, 1, 2});
        NestedArrays nestedArrays = new NestedArrays();
        List<Integer[]> result = nestedArrays.sortFromLessToHigh(resultList);
        assertThat(result.get(1), is(expected.get(1)));
        assertThat(result.get(0), is(expected.get(0)));
    }
    @Test
    public void whenReceivedListWithArraysSortedFromHighToLess() {
        Integer[] expIntegers = new Integer[] {5, 5, 2};
        Integer[] integers1 = new Integer[] {5, 2, 1};
        Integer[] nextIntegers = new Integer[] {5, 2, 0};
        List<Integer[]> expected = new ArrayList<>();
        expected.add(expIntegers);
        expected.add(integers1);
        expected.add(nextIntegers);
        List<Integer[]> resultList = new ArrayList<>();
        resultList.add(new Integer[] {5, 2, 0});
        resultList.add(new Integer[] {5, 5, 2});
        resultList.add(new Integer[] {5, 2, 1});
        NestedArrays nestedArrays = new NestedArrays();
        List<Integer[]> result = nestedArrays.fromHighToLessMethod(resultList);
        assertThat(result.get(1), is(expected.get(1)));
        assertThat(result.get(0), is(expected.get(0)));
    }
}
