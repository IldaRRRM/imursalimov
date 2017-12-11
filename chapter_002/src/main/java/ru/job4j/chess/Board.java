package ru.job4j.chess;
/**
 *
 */
public class Board {
    /**
     * Figures array.
     */
    Figure[] figures = new Figure[32];
    /**
     * position in figuresArr.
     */
    private int positionInArr = 0;

    /**
     * add figure on the board.
     * @param figure - received figure.
     */
    public void addFigure(Figure figure) {
        figures[positionInArr++] = figure;
    }
    /**
     * @param source - current position.
     * @param dist - cell on the board, which figure will go.
     * @return - true or exception.
     * @throws ImpossibleMoveException - impossible move.
     * @throws OccupiedWayException - exception, when figure is on a way.
     * @throws FigureNotFoundException - figure is not found in this cell.
     */
    boolean move(Cell source, Cell dist) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        Figure currentFigure = null;
        for (Figure figure : figures) {
            if (figure != null) {
                if (figure.position.equals(source)) {
                    currentFigure = figure;
                }
            }
        }
        //Check "figure is not found exception".
        try {
            if (currentFigure == null) {
                throw new FigureNotFoundException("Figure is not found");
            }
        } catch (FigureNotFoundException nfe) {
            return false;
        }
        // Check Figure is on a way exception.
        Cell[] fkWay = currentFigure.way(source, dist);
        try {
            for (Figure figure : figures) {
                if (figure != null) {
                    if (!currentFigure.position.equals(figure.position)) {
                        for (Cell cell : fkWay) {
                            if (cell.equals(figure.position)) {
                                throw new OccupiedWayException("Impossible move, a figure on the way");
                            }
                        }
                    }
                }
            }
        } catch (OccupiedWayException nfe) {
            return false;
        }
        //Check impossible move exception.
        try {
            if (fkWay.length == 0) {
                throw new ImpossibleMoveException("Impossible move");
            }
        } catch (ImpossibleMoveException nfe) {
            return false;
        }
        // change position.
        for (int i = 0; i < figures.length; i++) {
            if (figures[i] != null) {
                if (figures[i].position.equals(source)) {
                    figures[i] = currentFigure.clone(dist);
                }
            }
        }
        return true;
    }
}



