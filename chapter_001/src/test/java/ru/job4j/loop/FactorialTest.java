package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
*Public class FactorialTest includes methods factorial5 and factorial0.
*/
public class FactorialTest {
	/**
	*Method factorialTest5 tests method calc for number 5.
	*/
	@Test
	public void factorialTest5() {
		Factorial fc = new Factorial();
		int result = fc.calc(5);
		int expected = 120;
		assertThat(result, is(expected));
	}

	/**
	*Method factorialTest0 tests method calc for number 0.
	*/
	@Test
	public void factorialTest0() {
		Factorial fc = new Factorial();
		int result = fc.calc(0);
		int expected = 1;
		assertThat(result, is(expected));
	}
}