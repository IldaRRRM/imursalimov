package ru.job4j.coins;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 *
 */
public class CoinsTaskTest {
    @Test
    public void whenItsOnlyTen() {
        CoinsTask coinsTask = new CoinsTask();
        int[] result = coinsTask.changes(40, 10);
        int[] expected = new int[] {10, 10, 10};
        assertThat(result, is(expected));
    }
    @Test
    public void whenItsTenAndFive() {
        CoinsTask coinsTask = new CoinsTask();
        int[] result = coinsTask.changes(50, 35);
        int[] expected = new int[] {10, 5};
        assertThat(result, is(expected));
    }
    @Test
    public void whenItsOnlyTwo() {
        CoinsTask coinsTask = new CoinsTask();
        int[] result = coinsTask.changes(50, 46);
        int[] expected = new int[] {2, 2};
        assertThat(result, is(expected));
    }
    @Test
    public void whenItsAllNumbersOfCoins() {
        CoinsTask coinsTask = new CoinsTask();
        int[] result = coinsTask.changes(50, 12);
        int[] expected = new int[] {10, 10, 10, 5, 2, 1};
        assertThat(result, is(expected));
    }
    @Test
    public void whenItsOnlyTwoAndOne() {
        CoinsTask coinsTask = new CoinsTask();
        int[] result = coinsTask.changes(50, 47);
        int[] expected = new int[] {2, 1};
        assertThat(result, is(expected));
    }
}
