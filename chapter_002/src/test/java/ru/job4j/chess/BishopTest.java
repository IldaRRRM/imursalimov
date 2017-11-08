package ru.job4j.chess;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * class for testing.
 */
public class BishopTest {
    @Test
    public void bishopWayPossibleTestWhenItsFalse() {
        Cell cell = new Cell(0, 3, 3, 2);
        Bishop bishop = new Bishop(cell);
        boolean result = bishop.wayPossible(cell, cell);
        boolean expected = false;
        assertThat(result, is(expected));
    }
    @Test
    public void bishopWayPossibleTestWhenItsTrue() {
        Cell cell = new Cell(0, 0, 7, 7);
        Bishop bishop = new Bishop(cell);
        boolean result = bishop.wayPossible(cell, cell);
        boolean expected = true;
        assertThat(result, is(expected));
    }
    @Test
    public void bishopWayTestTrueWhenItPossible() {
        Cell cell = new Cell(0, 0, 7, 7);
        Bishop bishop = new Bishop(cell);
        int[] result = bishop.way(cell)[0].getReturnArr();
        int[] expectArr = new int[] {88, 77, 66, 55, 44, 33, 22};
        assertThat(result, is(expectArr));
    }
    @Test
    public void bishopWayTestFalseFigureOnTheWay() {
        Cell cell = new Cell(0, 0, 7, 7);
        Bishop bishop = new Bishop(cell);
        Board board = new Board();
        FigureTest figureTest = new FigureTest(new Cell(2, 2));
        board.addFigure(figureTest);
        board.addFigure(bishop);
        Cell[] result = bishop.way(cell);
        Cell[] expectArr = null;
        assertThat(result, is(expectArr));
    }
    @Test
    public void bishopWayTestTruePositionUpdate() {
        Cell cell = new Cell(0, 0, 7, 7);
        Bishop bishop = new Bishop(cell);
        bishop.way(cell);
        int result = bishop.position.getPosition();
        int expected = 88;
        assertThat(result, is(expected));
    }
}
