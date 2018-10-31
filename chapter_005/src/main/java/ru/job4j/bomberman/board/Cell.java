package ru.job4j.bomberman.board;

import java.util.Objects;

public class Cell {

    private final Integer y;

    private final Integer x;


    public Cell(Integer y, Integer x) {
        this.y = y;
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public Integer getX() {
        return x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {

            return true;
        }

        if (!(o instanceof Cell)) {

            return false;
        }
        Cell cell = (Cell) o;

        return Objects.equals(y, cell.y)
                && Objects.equals(x, cell.x);
    }

    @Override
    public int hashCode() {
        return Objects.hash(y, x);
    }

    @Override
    public String toString() {
        return String.format("[%d][%d]", getY(), getX());
    }
}
