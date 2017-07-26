package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
*public class CounterTest - for testing class Counter.
*/
public class CounterTest {
	/**
	*method evenNumberLoopFrom1To10 is testing method for method add from 1 to 10.
	*/
	@Test
	public void evenNumberLoopFrom1To10() {
	Counter count = new Counter();
	int result = count.add(1, 10);
	int expected = 30;
	assertThat(result, is(expected));
	}
}