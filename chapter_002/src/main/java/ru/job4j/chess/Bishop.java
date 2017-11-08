package ru.job4j.chess;
/**
 * Bishop figure.
 */
public class Bishop extends Figure {
    /**
     * all steps by bishop.
     */
    private Cell[] cells = new Cell[10];
    /**
     * index.
     */
    private int index = 0;
    /**
     * Constructor with position.
     * @param position
     */
    public Bishop(Cell position) {
        super(position);
    }

    int indexOfIo = 0;
    int indexOfI1 = 0;
    int indexOfJo = 0;
    int indexOfJ1 = 0;

    /**
     * method wayPossible - shows that chessBoard includes this cells.
     * @param position - position.
     * @param dist - place, where bishop will go.
     * @return - true/false step.
     * @throws ImpossibleMoveException - exception
     */
    public boolean wayPossible(Cell position, Cell dist) throws ImpossibleMoveException {
        int[][] arr = new Cell().getChessBoard();
        boolean move = false, first = false, second = false;
        for (int i = new Cell().getChessBoard().length - 1; i >= 0; i--) {
            for (int j = 0; j < new Cell().getChessBoard().length; j++) {
                if (arr[i][j] == position.getPosition()) {
                    indexOfIo = i;
                    indexOfJo = j;
                    first = true;
                }
                if (arr[i][j] == dist.getDist()) {
                    indexOfI1 = i;
                    indexOfJ1 = j;
                    second = true;
                }
                if (Math.abs(indexOfIo - indexOfI1) == Math.abs(indexOfJo - indexOfJ1) && first && second) {
                    move = true;
                }
            }
        }
        if (move) {
            return move;
        } else {
            new ImpossibleMoveException("Impossible step");
        }
        return move;
    }

    /**
     *
     * @param dist - way, which we'll pass.
     * @return - return Cell[] array with steps.
     * @throws ImpossibleMoveException - exception.
     */
    public Cell[] way(Cell dist) throws ImpossibleMoveException {
        if (wayPossible(dist, dist)) {
            int[] arrMove = new int[Math.abs(dist.getY1() - dist.getY())];

            int[][] arr = new Cell().getChessBoard();

            for (int i = 0; i < arrMove.length; i++) {
                if (indexOfI1 > indexOfIo && indexOfJ1 > indexOfJo) {
                    arrMove[i] = arr[indexOfI1 - i][indexOfJ1 - i];
                } else if (indexOfI1 > indexOfIo && indexOfJ1 < indexOfJo) {
                    arrMove[i] = arr[indexOfI1 - i][indexOfJ1 + i];
                } else if (indexOfI1 < indexOfIo && indexOfJ1 > indexOfJo) {
                    arrMove[i] = arr[indexOfI1 + i][indexOfJ1 - i];
                } else if (indexOfI1 < indexOfIo && indexOfJ1 < indexOfJo) {
                    arrMove[i] = arr[indexOfI1 + i][indexOfJ1 + i];
                }
            }
            for (int i : arrMove) {
                for (int j = 0; j < Board.figures.length; j++) {
                    if (Board.figures[j] != null) {
                        if (Board.figures[j].position.getPosition() == i && !Board.figures[j].equals(null)) {
                            new ImpossibleMoveException("The figure on the way");
                            return null;
                        }
                    }
                }
            }
            dist.setReturnArr(arrMove);
            this.cells[index++] = new Cell(dist.getReturnArr());
            // change the position.
            dist.setPosition(dist.getY1(), dist.getX1());
            return cells;
        } else {
            return null;
        }
    }
}


