package ru.job4j.chess;

public class FigureTest extends Figure {

    public FigureTest(Cell position) {
        super(position);
    }

    @Override
    boolean wayPossible(Cell position, Cell dist) throws ImpossibleMoveException {
        return false;
    }

    @Override
    Cell[] way(Cell dist) throws ImpossibleMoveException {
        return new Cell[0];
    }
}
