package ru.job4j.bomberman.application.modelthreads;

import ru.job4j.bomberman.board.Board;
import ru.job4j.bomberman.exception.IllegalMoveException;
import ru.job4j.bomberman.playmodel.Obstruction;
import ru.job4j.bomberman.playmodel.PlayModel;

import java.util.Map;

public class ObstructionThread extends Thread {

    private final Map<String, PlayModel> playModelMap;
    private final Board board;


    public ObstructionThread(Map<String, PlayModel> playModelMap, Board board) {
        this.playModelMap = playModelMap;
        this.board = board;
    }


    @Override
    public void run() {
        for (Map.Entry<String, PlayModel> modelInGame : playModelMap.entrySet()) {
            if (modelInGame.getValue() instanceof Obstruction) {
                try {
                    this.board.addPlayModelToBoard(modelInGame.getValue());
                } catch (IllegalMoveException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
