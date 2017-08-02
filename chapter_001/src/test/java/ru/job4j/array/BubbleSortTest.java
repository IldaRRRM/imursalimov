package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
*class BubbleSortTest includes methods which testing method sort from class BubbleSort.
*/
public class BubbleSortTest {
    /**
    *method whenSortArrayWithTenElementsThenSortedArray сhecks array sorting of ten numbers {1, 5, 4, 2, 3, 1, 7, 8, 0, 5}.
    */
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        BubbleSort ar = new BubbleSort();
    	int[] testAr = {1, 5, 4, 2, 3, 1, 7, 8, 0, 5};
    	int[] expectArray = {0, 1, 1, 2, 3, 4, 5, 5, 7, 8};
    	int[] resultArray = ar.back(testAr);
    	assertThat(resultArray, is(expectArray));
    }
}
