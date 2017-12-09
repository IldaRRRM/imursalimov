package ru.job4j.chess;
/**
 * Created by ildar on 06.11.17.
 */
public class TestFigure extends Figure {
    /**
     * @param dest - dist.
     * @return - new Figure.
     */
    @Override
    Figure clone(Cell dest) {
        return null;
    }

    /**
     *
     * @param source - beginning position.
     * @param dist - position, which figure should goes.
     * @return - .
     * @throws ImpossibleMoveException - Imps.
     */
    @Override
    Cell[] way(Cell source, Cell dist) throws ImpossibleMoveException {
        return new Cell[0];
    }
    /**
     * TestFigure.
     * @param position - received position.
     */
    TestFigure(Cell position) {
        super(position);
    }
}
