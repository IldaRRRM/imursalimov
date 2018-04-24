package ru.job4j.problemsview;

public class ProblemsView implements Runnable {

    private Integer increaseCount = 0;

    public void increaseCountByOne() {
        ++increaseCount;
    }

    public void increaseCountByFive() {
        increaseCount += 5;
    }

    @Override
    public void run() {
        increaseCountByFive();
        increaseCountByOne();

    }

    public Integer getIncreaseCount() {
        return increaseCount;
    }
}
