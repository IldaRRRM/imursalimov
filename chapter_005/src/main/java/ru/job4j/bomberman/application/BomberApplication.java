package ru.job4j.bomberman.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.bomberman.board.Board;
import ru.job4j.bomberman.board.Cell;
import ru.job4j.bomberman.exception.IllegalMoveException;
import ru.job4j.bomberman.playmodel.Hero;
import ru.job4j.bomberman.playmodel.PlayModel;

import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class BomberApplication implements Runnable {

    private final static Logger APPLOG = LoggerFactory.getLogger(BomberApplication.class);

    private final ReentrantLock lock = new ReentrantLock();
    private final Board board;
    private final BlockingQueue<Cell> dists = new LinkedBlockingQueue<>();
    private final ConcurrentHashMap<String, PlayModel> sourceModels = new ConcurrentHashMap<>();

    public BomberApplication(Board board) {
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }


    public boolean addPlayModelToGame(PlayModel playModel) {
        for (Map.Entry<String, PlayModel> modelInGame : sourceModels.entrySet()) {
            if (modelInGame.getValue().getCell().equals(playModel.getCell())) {
                return false;
            }
        }
        sourceModels.putIfAbsent(playModel.getName(), playModel);
        return true;
    }

    private void addPlayModelToBoard(PlayModel hero) throws InterruptedException, IllegalMoveException {
        board.addPlayModelToBoard(hero);
        sourceModels.put(hero.getName(), hero);
    }

    @Override
    public void run() {

        Thread hero1 = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {

                PlayModel hero = sourceModels.get("Hero");
                Cell randomMove = board.makeRandomMove(hero.getCell());
                APPLOG.info("new Hero Dist is {}", randomMove);
                dists.offer(randomMove);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });

        Thread boardThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                lock.lock();
                PlayModel hero = sourceModels.get("Hero");

                try {
                    Cell randomCell = dists.poll(2000, TimeUnit.MILLISECONDS);
                    boolean move = getBoard().move(hero.getCell(), randomCell);
                    if (move) {
                        APPLOG.info("New {} source cell is {}", hero.getName(), randomCell);
                        addPlayModelToBoard(new Hero("Hero", randomCell));
                    } else {
                        APPLOG.info("Bad step");
                        boolean goodMove = false;
                        while (!goodMove) {
                            Cell randomMove = board.makeRandomMove(hero.getCell());
                            boolean move1 = getBoard().move(hero.getCell(), randomMove);
                            if (move1) {
                                goodMove = true;
                                APPLOG.info("New {} source cell is {}", hero.getName(), randomCell);
                                addPlayModelToBoard(new Hero("Hero", randomCell));
                            }
                        }
                    }
                } catch (InterruptedException | IllegalMoveException e) {
                    e.printStackTrace();
                }
                lock.unlock();
            }
        });

        hero1.start();
        boardThread.start();
        try {
            hero1.join();
            boardThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

