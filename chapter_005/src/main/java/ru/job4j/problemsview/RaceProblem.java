package ru.job4j.problemsview;

public class RaceProblem implements Runnable {

    private Integer increaseCount = 0;

    public void increaseCountByOne() {
        ++increaseCount;
    }

    @Override
    public void run() {
        increaseCountByOne();
    }

    public Integer getIncreaseCount() {
        return increaseCount;
    }
}
