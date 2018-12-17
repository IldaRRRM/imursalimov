package ru.job4j.bomberman.playmodel;

import ru.job4j.bomberman.board.Cell;

import java.util.Objects;

public abstract class PlayModel {

    private final Cell cell;
    private final String name;

    PlayModel(String name, Cell cell) {
        this.cell = cell;
        this.name = name;
    }

    public Cell getCell() {
        return this.cell;
    }

    public String getName() {
        return this.name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PlayModel)) {
            return false;
        }
        PlayModel playModel = (PlayModel) o;
        return Objects.equals(cell, playModel.cell)
                && Objects.equals(name, playModel.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cell, name);
    }
}
