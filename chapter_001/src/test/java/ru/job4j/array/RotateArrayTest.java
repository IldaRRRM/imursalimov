package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
*public class RotateArrayTest includes method "whenRotateTwoRowTwoColArrayThenRotatedArray", which is testing method rotate.
*/
public class RotateArrayTest {
	/**
	*method whenRotateTwoRowTwoColArrayThenRotatedArray used for testing a method rotate with array 2x2.
	*/
	@Test
	public void whenRotateTwoRowTwoColArrayThenRotatedArray() {
        RotateArray rot = new RotateArray();
        int[][] testArr = {{1, 2}, {3, 4}};
        int[][] expectArray = {{3, 1}, {4, 2}};
        int[][] resultArray = rot.rotate(testArr);
        assertThat(resultArray, is(expectArray));
    }
    /**
    *method whenRotateThreeRowThreeColArrayThenRotatedArray used for testing a method rotate with array 2x2.
    */
    @Test
    public void whenRotateThreeRowThreeColArrayThenRotatedArray() {
        RotateArray rot2 = new RotateArray();
        int[][] testArr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] expectArray = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        int[][] resultArray = rot2.rotate(testArr);
        assertThat(resultArray, is(expectArray));
    }
}