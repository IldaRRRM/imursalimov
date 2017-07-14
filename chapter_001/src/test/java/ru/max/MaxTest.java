package ru.job4j.max;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Class MaxTest is for test class Max.
*/

public class MaxTest {
	/**
	*Method whenFirstLessSecond test method max when first value is less than Second.
	*/
    @Test
	public void whenFirstLessSecond() {
    Max maxim = new Max();
    int result = maxim.max(1, 2);
    assertThat(result, is(2));
	}
	/**
	*Method whenSecondLessFirst test method max when second value is less than first.
	*/
	@Test
	public void whenSecondLessFirst() {
    Max maxim = new Max();
    int result = maxim.max(2, 1);
    assertThat(result, is(2));
	}
}
