package ru.job4j.chess;

/**
 *
 */
public class Cell {
    /**
     * Constructor with position.
     * @param x - x coordinate of position.
     * @param y - y coordinate of position.
     */
    public Cell(int y, int x) {
        this.x = x;
        this.y = y;
    }

    /**
     * x coord for position of figure.
     */
    private int x;
    /**
     * y coord for position of figure.
     */
    private int y;

    /**
     * getter for x.
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
     * @param o - received object.
     * @return - boolean result.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Cell cell = (Cell) o;

        if (x != cell.x) {
            return false;
        }
        return y == cell.y;
    }
    /**
     * @return - override hashcode.
     */
    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}

