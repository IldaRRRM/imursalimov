package ru.job4j.chess;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * class for testing.
 */
public class BishopTest {
    @Test
    public void bishopWayWhenEverythingIsFineAndMoveIsPossible() {
        Board board = new Board();
        Bishop bishop = new Bishop(new Cell(0, 2));
        board.addFigure(bishop);
        board.move(new Cell(0, 2), new Cell(3, 5));
        Cell result = board.figures[0].position;
        Cell expected = new Cell(3, 5);
        assertThat(result, is(expected));
    }
    @Test
    public void bishopWayWhenFigureIsOnWay() {
        Board board = new Board();
        Bishop bishop = new Bishop(new Cell(0, 2));
        TestFigure testFigure = new TestFigure(new Cell(1, 3));
        board.addFigure(bishop);
        board.addFigure(testFigure);
        boolean result = board.move(new Cell(0, 2), new Cell(3, 5));
        boolean expected = false;
        assertThat(result, is(expected));
    }
    @Test
    public void bishopWayWhenFigureIsNotFound() {
        Board board = new Board();
        Bishop bishop = new Bishop(new Cell(1, 1));
        board.addFigure(bishop);
        boolean result = board.move(new Cell(0, 2), new Cell(3, 5));
        boolean expected = false;
        assertThat(result, is(expected));
    }
    @Test
    public void bishopWayWhenHeCantGoesLikeThisBecauseTheSourceAndDistIsSame() {
        Board board = new Board();
        Bishop bishop = new Bishop(new Cell(1, 1));
        board.addFigure(bishop);
        boolean result = board.move(new Cell(1, 1), new Cell(1, 1));
        boolean expected = false;
        assertThat(result, is(expected));
    }
    @Test
    public void bishopWayIsImpossibleBecauseTheWayIsWrong() {
        Board board = new Board();
        Bishop bishop = new Bishop(new Cell(1, 1));
        board.addFigure(bishop);
        boolean result = board.move(new Cell(1, 1), new Cell(3, 2));
        boolean expected = false;
        assertThat(result, is(expected));
    }
}
