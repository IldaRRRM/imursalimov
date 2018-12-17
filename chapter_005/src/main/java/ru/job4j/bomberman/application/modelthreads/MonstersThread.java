package ru.job4j.bomberman.application.modelthreads;

import lombok.extern.slf4j.Slf4j;
import ru.job4j.bomberman.board.Board;
import ru.job4j.bomberman.board.Cell;
import ru.job4j.bomberman.exception.IllegalMoveException;
import ru.job4j.bomberman.playmodel.Monster;
import ru.job4j.bomberman.playmodel.PlayModel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class MonstersThread extends Thread {

    private final Map<String, PlayModel> sourceModels;
    private final Board board;
    private final ConcurrentHashMap<PlayModel, Cell> playmodelDists;
    private final ReentrantLock monstersLock = new ReentrantLock();


    public MonstersThread(Map<String, PlayModel> sourceModels, Board board, ConcurrentHashMap<PlayModel, Cell> monstersDists) {
        this.sourceModels = sourceModels;
        this.board = board;
        this.playmodelDists = monstersDists;
    }

    @Override
    public void run() {
        new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                monstersLock.lock();
                for (Map.Entry<String, PlayModel> monster : sourceModels.entrySet()) {
                    if (monster.getValue() instanceof Monster) {
                        Cell monsterRanodmMove = board.makeRandomMove(monster.getValue().getCell());
                        log.info("monster {} new Dist is {}", monster.getKey(), monsterRanodmMove);
                        playmodelDists.put(monster.getValue(), monsterRanodmMove);

                    }
                }

                for (Map.Entry<PlayModel, Cell> monster : playmodelDists.entrySet()) {

                    try {
                        boolean monsterMove = board.move(monster.getKey().getCell(), monster.getValue());
                        if (monsterMove) {
                            board.addPlayModelToBoard(new Monster(monster.getKey().getName(), monster.getValue()));
                            sourceModels.put(monster.getKey().getName(), new Monster(monster.getKey().getName(), monster.getValue()));
                            log.info("New monster {} sourceCell is {}", monster.getKey().getName(), monster.getValue());
                        } else {
                            log.debug("Bad step");
                            boolean goodMove = false;
                            while (!goodMove) {
                                Cell secondMove = board.makeRandomMove(monster.getKey().getCell());
                                boolean move1 = board.move(monster.getKey().getCell(), secondMove);
                                if (move1) {
                                    goodMove = true;
                                    log.info("New {} source cell is {}", monster.getKey().getName(), secondMove);
                                    board.addPlayModelToBoard(new Monster(monster.getKey().getName(), secondMove));
                                }
                            }
                        }

                    } catch (InterruptedException | IllegalMoveException e) {
                        e.printStackTrace();
                    }


                }
                monstersLock.unlock();

            }

        }).start();
    }
}


