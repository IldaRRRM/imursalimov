package ru.job4j.bomberman.board;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.bomberman.exception.IllegalMoveException;
import ru.job4j.bomberman.playmodel.Hero;
import ru.job4j.bomberman.playmodel.Monster;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.hamcrest.Matchers.is;

public class BoardTest {
    private ExecutorService executor;
    private Board board;
    private Hero hero;


    @Before
    public void init() {
        executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        board = new Board(4, 4);
        hero = new Hero("Testing Hero", new Cell(0, 0));
    }


    @Test
    public void whenMoveHeroPlayModelOnBoard() throws InterruptedException, IllegalMoveException {
        Hero hero = new Hero("Hero", new Cell(0, 0));
        board.addPlayModelToBoard(hero);
        board.move(hero.getCell(), new Cell(hero.getCell().getY() + 1, hero.getCell().getX()));
        boolean sourceLocked = board.getBoard()[0][0].isLocked();
        Assert.assertFalse(sourceLocked);
    }


    @Test
    public void whenMoveHeroIsImpossible() throws InterruptedException, IllegalMoveException {
        Hero hero = new Hero("Hero", new Cell(0, 0));
        board.addPlayModelToBoard(hero);
        try {
            boolean move = board.move(hero.getCell(), new Cell(2, 0));
        } catch (IllegalMoveException illeg) {
            Cell randomCell = board.makeRandomMove(hero.getCell());
            board.move(hero.getCell(), randomCell);
        }
    }


    @Test
    public void whenTryLockOnlyOnCellWherePlayModelStay() throws InterruptedException, IllegalMoveException {
        board.addPlayModelToBoard(new Hero("Hero", new Cell(0, 0)));
        Assert.assertThat(board.getBoard()[0][0].isLocked(), is(true));
        Assert.assertThat(board.getBoard()[0][1].isLocked(), is(false));
        board.addPlayModelToBoard(new Hero("Monster", new Cell(0, 1)));
        Assert.assertThat(board.getBoard()[0][1].isLocked(), is(true));

    }

    @Test(expected = IllegalMoveException.class)
    public void whenTryAddModelWhichOutOfBoard() throws InterruptedException, IllegalMoveException {
        boolean falseAddExample = board.addPlayModelToBoard(new Monster("Monster", new Cell(4, 4)));
        boolean successAddExample = board.addPlayModelToBoard(new Hero("Hero", new Cell(0, 0)));
        Assert.assertTrue(successAddExample);
        Assert.assertFalse(falseAddExample);
    }


    @Test()
    public void whenTryToGoOnWrongCell() throws InterruptedException, IllegalMoveException {
        Assert.assertFalse(board.move(hero.getCell(), new Cell(1, 1)));

    }

    @Test()
    public void whenTryToGoOnSameCell() throws InterruptedException, IllegalMoveException {
        Assert.assertFalse(board.move(hero.getCell(), new Cell(0, 0)));
    }

    @Test()
    public void whenTryToGoOnOutIndexCell() throws InterruptedException, IllegalMoveException {
        Assert.assertFalse(board.move(hero.getCell(), new Cell(0, 4)));
    }

    @Test()
    public void whenTryGoToOutBoard() throws InterruptedException, IllegalMoveException {
        Assert.assertFalse(board.move(hero.getCell(), new Cell(-1, 0)));
    }
}