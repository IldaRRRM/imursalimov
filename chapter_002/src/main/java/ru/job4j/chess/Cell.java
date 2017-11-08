package ru.job4j.chess;

/**
 *
 */
public class Cell {
    /**
     * array for storing steps by figures.
     */
    private int[] returnArr;

    /**
     * for check right steps.
     * @return - return filled array.
     */
    public int[] getReturnArr() {
        return this.returnArr;
    }
    /**
     * setter for arr.
     * @param returnArr - received array.
     */
    public void setReturnArr(int[] returnArr) {
        this.returnArr = returnArr;
    }

    /**
     * empty constructor.
     */
    Cell() {
    }

    /**
     * Constructor with array for method Cell[] way from abstract class Figure.
     * @param array - received array.
     */
    public Cell(int[] array) {
        this.returnArr = array;
    }

    /**
     * Constructor.
     * @param y - y coordinate for position.
     * @param x - x coordinate for position.
     * @param y1 - y1 coordinate for dist.
     * @param x1 - x1 coordinate for dist.
     */
    public Cell(int y, int x, int y1, int x1) {
        this.y = y;
        this.x = x;
        this.y1 = y1;
        this.x1 = x1;
        setDist(y1, x1);
        setPosition(y, x);
    }

    /**
     * Constructor with position.
     * @param x - x coord for position.
     * @param y - y coord for position.
     */
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        setPosition(y, x);
    }
    /**
     * Filled chessBoard.
     */
    private final int[][] chessBoard = Board.fillBoard(new int[8][8]);

    /**
     * Getter for chessBoard.
     * @return - filled chessBoard.
     */
    public int[][] getChessBoard() {
        return this.chessBoard;
    }

    /**
     * x coord of figure "move".
     */
    private int x1;
    /**
     * y coord of figure "move".
     */
    private int y1;
    /**
     * x coord for position of figure.
     */
    private int x;
    /**
     * y coord for position of figure.
     */
    private int y;

    /**
     * getter.
     * @return - x.
     */
    public int getX() {
        return this.x;
    }

    /**
     * getter for y.
     * @return - y.
     */
    public int getY() {
        return this.y;
    }

    /**
     * getter for x1.
     * @return - x1 coordinate for dist param.
     */
    public int getX1() {
        return this.x1;
    }

    /**
     * getter for y1.
     * @return - y1 coordinate for dist param.
     */
    public int getY1() {
        return this.y1;
    }

    private int position;

    private int dist;

    /**
     * setPosition for figure.
     * @param y - y coordinate.
     * @param x - x coordinate.
     * @throws ArrayIndexOutOfBoundsException - exception : out of a board.
     */
    public void setPosition(int y, int x) throws ArrayIndexOutOfBoundsException {
        int result = 0;
        this.x = x;
        this.y = y;
        try {
            for (int i = 0; i < chessBoard.length; i++) {
                for (int j = 0; j < chessBoard.length; j++) {
                    if (chessBoard[y][x] == chessBoard[i][j]) {
                        result = chessBoard[i][j];
                    }

                }
            }
            this.position = result;
        } catch (ArrayIndexOutOfBoundsException nfe) {
            System.out.println("impossible position(outside the board)");
        }
    }

    /**
     * @return - unic number of position.
     */
    public int getPosition() {
        return position;
    }

    /**
     * set unic number for "step" on chessBoard.
     * @param y - y coord for step.
     * @param x - x coord for step.
     * @throws ArrayIndexOutOfBoundsException - exception: outside the board.
     */
    public void setDist(int y, int x) throws ArrayIndexOutOfBoundsException {
        this.x1 = x;
        this.y1 = y;
        int result = 0;
        try {
            for (int i = 0; i < chessBoard.length; i++) {
                for (int j = 0; j < chessBoard.length; j++) {
                    if (chessBoard[y][x] == chessBoard[i][j]) {
                        result = chessBoard[i][j];
                    }
                }
            }
            this.dist = result;
        } catch (ArrayIndexOutOfBoundsException nfe) {
            System.out.println("impossible move(outside the board)");
        }
    }

    /**
     * @return - unic number of dist.
     */
    public int getDist() {
        return this.dist;
    }
}

