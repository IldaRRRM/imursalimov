package ru.job4j.bomberman.application;

import org.junit.Test;
import ru.job4j.bomberman.board.Board;
import ru.job4j.bomberman.board.Cell;
import ru.job4j.bomberman.exception.IllegalMoveException;
import ru.job4j.bomberman.playmodel.Hero;


public class BomberApplicationTest {
    @Test
    public void firstTest() throws InterruptedException, IllegalMoveException {
        Board board = new Board(10, 10);
        Hero hero = new Hero("Hero", new Cell(3, 3));
        BomberApplication bomberApplication = new BomberApplication(board);
        bomberApplication.addPlayModelToGame(hero);
        Thread thread = new Thread(bomberApplication);
        thread.start();
        thread.join(20000);
        thread.interrupt();
    }

}