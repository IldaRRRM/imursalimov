package ru.job4j.chess;

/**
 * Created by ildar on 06.11.17.
 */
public class TestFigure extends Figure {
    /**
     * constructor.
     * @param position - position.
     */
    public TestFigure(Cell position) {
        super(position);
    }

    /**
     * test.
     * @param position - position
     * @param dist - step coord.
     * @return - .
     * @throws ImpossibleMoveException - except.
     */
    boolean wayPossible(Cell position, Cell dist) throws ImpossibleMoveException {
        return false;
    }

    /**
     * test.
     * @param dist - test.
     * @return - test.
     * @throws ImpossibleMoveException - test.
     */
    Cell[] way(Cell dist) throws ImpossibleMoveException {
        return new Cell[0];
    }
}
