package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
*Class PaintTest used for testing method piramid from class Paint.
*/
public class PaintTest {
	/**
	*method whenPiramidWithHeightTwoThenStringWithTwoRows used for testing method piramid with height 2 form class Paint.
	*/
	@Test
	public void whenPiramidWithHeightTwoThenStringWithTwoRows() {
        Paint paint = new Paint();
        String result = paint.piramid(2);
        String expected = String.format(" ^%s^^^", System.getProperty("line.separator"));
        assertThat(result, is(expected));
    } //end of method.

    /**
    *method whenPiramidWithHeightThreeThenStringWithThreeRows used for testing method piramid with height 3 form class Paint.
    */
    @Test
    public void whenPiramidWithHeightThreeThenStringWithThreeRows() {
        Paint paint1 = new Paint();
        String result = paint1.piramid(3);
        final String line = System.getProperty("line.separator");
        String expected = String.format("  ^%s ^^^%s^^^^^", line, line, line);
        assertThat(result, is(expected));
    }
}