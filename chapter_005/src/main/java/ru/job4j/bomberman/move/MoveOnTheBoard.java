package ru.job4j.bomberman.move;

import ru.job4j.bomberman.board.Cell;
import ru.job4j.bomberman.exception.IllegalMoveException;

import java.util.Random;

public interface MoveOnTheBoard {

    boolean move(Cell source, Cell dist) throws Exception;

    /**
     * The possibility of making a move from the initial position is checked.
     *
     * @param source position from which the move will be made.
     * @param dist   position which play model will go
     * @return possible result
     * @throws IllegalMoveException if move will not possible
     */
    default boolean checkMoveAboutSource(Cell source, Cell dist) throws IllegalMoveException {
        if (Math.abs(source.getY() - dist.getY()) > 1) {
            throw new IllegalMoveException("Can't go to Cell[" + dist.getY() + "][" + dist.getX() + "]");
        } else if (Math.abs(source.getX() - dist.getX()) > 1) {
            throw new IllegalMoveException("Can't go to Cell[" + dist.getY() + "][" + dist.getX() + "]");
        } else if (source.equals(dist)) {
            throw new IllegalMoveException("Can't go to same place");
        } else if (Math.abs(source.getY() - dist.getY()) == Math.abs(source.getX() - dist.getX())) {
            throw new IllegalMoveException("Can't go to Cell[" + dist.getY() + "][" + dist.getX() + "]");
        }
        return true;
    }

    /**
     * check for ArrayIndexOutOfBoundsException
     *
     * @param dist    position which play model will go
     * @param rows    rows of play board
     * @param columns columns of play board
     * @return true, if dist in board or IllegalMoveException if dist is outOfBounds
     */

    default boolean checkArrayOutBound(Cell dist, int rows, int columns) throws IllegalMoveException {
        if (dist.getY() > rows - 1 || dist.getY() < 0) {
            throw new IllegalMoveException("Move beyond the board");
        } else if (dist.getX() > columns - 1 || dist.getX() < 0) {
            throw new IllegalMoveException("Move beyond the board");
        }
        return true;
    }

    /**
     * Make random possible move
     *
     * @param source source cell of playModel
     * @return random dist cell of playModel
     */
    default Cell makeRandomMove(Cell source) {
        int direction = new Random().nextInt(4);
        Cell result = null;
        if (direction == 0) {
            result = new Cell(source.getY() + 1, source.getX());
        } else if (direction == 1) {
            result = new Cell(source.getY() - 1, source.getX());
        } else if (direction == 2) {
            result = new Cell(source.getY(), source.getX() + 1);
        } else if (direction == 3) {
            result = new Cell(source.getY(), source.getX() - 1);
        }
        return result;
    }


}
