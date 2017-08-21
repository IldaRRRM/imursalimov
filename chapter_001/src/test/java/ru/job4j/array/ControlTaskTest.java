package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
*public class ControlTaskTest includes method charFind, which using for testing method "contains" from ControlTask class.
*/
public class ControlTaskTest {
	/**
	*method contain.
	*/
	@Test
    public void contain() {
        ControlTask first = new ControlTask();
        boolean result = first.contains("lalalprivetlala", "lolo");
        boolean expected = false;
        assertThat(result, is(expected));
    }
     /**
    *method notContain.
    */
     @Test
 	public void notContain() {
        ControlTask not = new ControlTask();
        boolean result = not.contains("lalaprivetlala", "ivetla");
        boolean expected = true;
        assertThat(result, is(expected));
    }
}