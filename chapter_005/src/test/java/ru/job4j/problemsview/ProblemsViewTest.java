package ru.job4j.problemsview;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProblemsViewTest {
    @Test(expected = AssertionError.class)
    public void whenOneThreadDoesentSeeOtherThread() {
        ProblemsView problemsView = new ProblemsView();
        Thread one = new Thread(problemsView);
        Thread two = new Thread(problemsView);
        one.run();
        if (problemsView.getIncreaseCount() == 5) {
            two.run();
        }
        assertThat(problemsView.getIncreaseCount(), is(12));
    }

}