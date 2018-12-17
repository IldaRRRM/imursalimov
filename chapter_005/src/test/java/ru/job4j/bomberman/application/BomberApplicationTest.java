package ru.job4j.bomberman.application;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import ru.job4j.bomberman.board.Board;
import ru.job4j.bomberman.board.Cell;
import ru.job4j.bomberman.playmodel.Hero;
import ru.job4j.bomberman.playmodel.Monster;
import ru.job4j.bomberman.playmodel.Obstruction;

import java.util.concurrent.TimeUnit;

@Slf4j
public class BomberApplicationTest {
    @Test
    public void firstTest() throws InterruptedException {
        Board board = new Board(100, 100);
        BomberApplication bomberApplication = new BomberApplication(board);
        Hero hero = new Hero("Hero", new Cell(49, 50));
        bomberApplication.addHeroStep(new Cell(50, 50));
        Obstruction obstruction = new Obstruction("Column", new Cell(79, 80));
        Monster trololo = new Monster("FirstTrololo", new Cell(4, 4));
        Monster monster = new Monster("Monster", new Cell(0, 0));
        Monster secondMonster = new Monster("SecondMonster", new Cell(80, 80));
        bomberApplication.addPlayModelToGame(obstruction);
        bomberApplication.addPlayModelToGame(monster);
        bomberApplication.addPlayModelToGame(secondMonster);
        bomberApplication.addPlayModelToGame(trololo);
        bomberApplication.addPlayModelToGame(hero);
        Thread thread = new Thread(bomberApplication);
        thread.start();
        bomberApplication.addHeroStep(new Cell(50, 50));
        bomberApplication.addHeroStep(new Cell(50, 51));
        bomberApplication.addHeroStep(new Cell(50, 52));
        TimeUnit.SECONDS.sleep(4);
        thread.interrupt();

    }
}