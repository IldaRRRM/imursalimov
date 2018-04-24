package ru.job4j.problemsview;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RaceProblemTest {
    @Test(expected = AssertionError.class)
    public void whenTwoThreadsIncreaseValueByOneShouldBeOneBuItsTwo() {
        RaceProblem raceProblem = new RaceProblem();
        Thread thread1 = new Thread(raceProblem);
        Thread thread2 = new Thread(raceProblem);
        thread1.run();
        thread2.run();
        assertThat(raceProblem.getIncreaseCount(), is(1));
    }

}