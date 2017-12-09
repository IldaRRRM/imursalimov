package ru.job4j.chess;
/**
 * Bishop figure.
 */
public class Bishop extends Figure {
    /**
     * Constructor with position.
     * @param position - beginning position.
     */
    public Bishop(Cell position) {
        super(position);
    }

    @Override
    Bishop clone(Cell dest) {
        return new Bishop(dest);
    }

    /**
     * @param source - begin position of bishop.
     * @param dist - cell, which bishop will go.
     * @return - array of cells.
     * @throws ImpossibleMoveException - imp move.
     */
    public Cell[] way(Cell source, Cell dist) throws ImpossibleMoveException {
        try {
            if (Math.abs(source.getY() - dist.getY()) == Math.abs(source.getX() - dist.getX())) {
                int arrMove = Math.abs(dist.getY() - source.getY());
                Cell[] steps = new Cell[arrMove];
                for (int i = 0; i < steps.length; i++) {
                    if (dist.getY() > source.getY() && dist.getX() > source.getX()) {
                        steps[i] = new Cell(dist.getY() - i, dist.getX() - i);
                    } else if (dist.getY() > source.getY() && dist.getX() < source.getX()) {
                        steps[i] = new Cell(dist.getY() - i, dist.getX() + i);
                    } else if (dist.getY() < source.getY() && dist.getX() > source.getX()) {
                        steps[i] = new Cell(dist.getY() + i, dist.getX() - i);
                    } else if (dist.getY() < source.getY() && dist.getX() < source.getX()) {
                        steps[i] = new Cell(dist.getY() + i, dist.getX() + i);
                    }
                }
                return steps;
            } else {
                throw new ImpossibleMoveException("Impossible step");
            }
        } catch (ImpossibleMoveException nfe) {
            return new Cell[0];
        }
    }
}


