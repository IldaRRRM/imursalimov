package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
*Class BoardTest includes methods whenPaint...3x3 and whenPaint 5x4 for testing method paint from class Board.
*/
public class BoardTest {
	/**
	*Method which testing a method paint 3x3.
	*/
	@Test
	public void whenPaintBoardWithWidthThreeAndHeightThreeThenStringWithThreeColsAndThreeRows() {
        Board board = new Board();
        String result = board.paint(3, 3);
        final String line = System.getProperty("line.separator");
        String expected = String.format("x x%s x %sx x", line, line, line);
        assertThat(result, is(expected));
	}
	/**
	*Method which testing a method paint 5x4.
	*/
	 @Test
    public void whenPaintBoardWithWidthFiveAndHeightFourThenStringWithFiveColsAndFourRows() {
        Board board1 = new Board();
        String result1 = board1.paint(5, 4);
        final String line = System.getProperty("line.separator");
        String expected = String.format("x x x%s x x %sx x x%s x x ", line, line, line, line, line);
        assertThat(result1, is(expected));
    }
}

