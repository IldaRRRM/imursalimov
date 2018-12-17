package ru.job4j.bomberman.application.modelthreads;

import lombok.extern.slf4j.Slf4j;
import ru.job4j.bomberman.board.Board;
import ru.job4j.bomberman.board.Cell;
import ru.job4j.bomberman.exception.IllegalMoveException;
import ru.job4j.bomberman.playmodel.Hero;
import ru.job4j.bomberman.playmodel.PlayModel;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class HeroThread extends Thread {
    private final BlockingQueue<Cell> heroSteps;
    private final ConcurrentHashMap<String, PlayModel> sourceModels;
    private final Board board;


    public HeroThread(BlockingQueue<Cell> heroSteps, ConcurrentHashMap<String, PlayModel> sourceModels, Board board) {
        this.heroSteps = heroSteps;
        this.sourceModels = sourceModels;
        this.board = board;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            PlayModel hero = sourceModels.get("Hero");
            if (!heroSteps.isEmpty()) {
                Cell dist = heroSteps.poll();
                try {
                    boolean heroMove = board.move(hero.getCell(), dist);
                    if (!heroMove) {
                        log.info("Wrong step, pls try again");
                    } else {
                        sourceModels.put("Hero", new Hero("Hero", dist));
                        board.addPlayModelToBoard(new Hero("Hero", dist));
                        log.info("Hero new Cell is {}", dist);
                    }
                } catch (InterruptedException | IllegalMoveException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
