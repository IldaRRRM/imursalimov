package ru.job4j.bomberman.board;

import lombok.extern.slf4j.Slf4j;
import ru.job4j.bomberman.exception.IllegalMoveException;
import ru.job4j.bomberman.move.MoveOnTheBoard;
import ru.job4j.bomberman.playmodel.PlayModel;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class Board implements MoveOnTheBoard {


    private final Integer rows;
    private final Integer columns;

    private final ReentrantLock[][] board;

    public Board(final Integer rows, final Integer columns) {
        this.rows = rows;
        this.columns = columns;
        this.board = new ReentrantLock[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = new ReentrantLock();
            }
        }
    }


    public ReentrantLock[][] getBoard() {
        return board;
    }


    public boolean move(Cell source, Cell dist) throws InterruptedException {
        if (!board[source.getY()][source.getX()].isLocked()) {
            board[source.getY()][source.getX()].lock();
        }
        boolean result = false;
        try {
            if (checkMoveAboutSource(source, dist) && checkArrayOutBound(dist, rows, columns)) {
                result = board[dist.getY()][dist.getX()].tryLock(500, TimeUnit.MILLISECONDS);
                log.info("Cell {} has been locked", dist);
            }
            if (result) {
                board[source.getY()][source.getX()].unlock();
                log.info("Source Cell {} has been unlocked", source);
            }

        } catch (IllegalMoveException illegal) {
            return false;
        }
        return result;
    }


    public boolean addPlayModelToBoard(PlayModel playModel) throws IllegalMoveException {
        if (checkArrayOutBound(playModel.getCell(), rows, columns) && !board[playModel.getCell().getY()][playModel.getCell().getX()].isLocked()) {
            log.info("PlayModel {} has been added on cell {} ", playModel.getName(), playModel.getCell());
            board[playModel.getCell().getY()][playModel.getCell().getX()].lock();
            return true;
        }
        return false;
    }


}

