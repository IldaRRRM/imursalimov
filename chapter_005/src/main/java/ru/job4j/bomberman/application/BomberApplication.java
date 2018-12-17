package ru.job4j.bomberman.application;

import lombok.extern.slf4j.Slf4j;
import ru.job4j.bomberman.application.modelthreads.HeroThread;
import ru.job4j.bomberman.application.modelthreads.MonstersThread;
import ru.job4j.bomberman.application.modelthreads.ObstructionThread;
import ru.job4j.bomberman.board.Board;
import ru.job4j.bomberman.board.Cell;
import ru.job4j.bomberman.playmodel.PlayModel;

import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

@Slf4j
public class BomberApplication implements Runnable {


    private final Board board;
    private final ConcurrentHashMap<PlayModel, Cell> monstersDists = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, PlayModel> sourceModels = new ConcurrentHashMap<>();
    private final BlockingQueue<Cell> heroDists = new LinkedBlockingQueue<>();

    public BomberApplication(Board board) {
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }

    public boolean addHeroStep(Cell dist) {
        return heroDists.offer(dist);
    }


    public boolean addPlayModelToGame(PlayModel playModel) {
        for (Map.Entry<String, PlayModel> modelInGame : sourceModels.entrySet()) {
            if (modelInGame.getValue().getCell().equals(playModel.getCell())) {
                log.info("{} has not been added", playModel.getName());
                return false;
            }
        }
        sourceModels.putIfAbsent(playModel.getName(), playModel);
        return true;
    }


    @Override
    public void run() {

        ObstructionThread obstructionThread = new ObstructionThread(sourceModels, board);

        MonstersThread monsters = new MonstersThread(sourceModels, board, monstersDists);

        HeroThread heroThread = new HeroThread(heroDists, sourceModels, board);


        obstructionThread.start();
        monsters.start();
        heroThread.start();

        try {
            obstructionThread.join();
            monsters.join();
            heroThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

