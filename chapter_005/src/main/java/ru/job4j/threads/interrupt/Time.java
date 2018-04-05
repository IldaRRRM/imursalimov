package ru.job4j.threads.interrupt;

public class Time implements Runnable {

    private final long sleep;

    public Time(long sleep) {
        this.sleep = sleep;
    }

    public void durationOfProgram() throws InterruptedException {
        Thread countCharThread = new Thread(new CountChar("Hello world, winter came and don't go out."));
        long startTime = System.currentTimeMillis();
        countCharThread.start();
        Thread.sleep(sleep);
        countCharThread.interrupt();
        long executionTime = System.currentTimeMillis() - startTime;
        System.out.printf("Execution time is : %d ms.", executionTime);
    }

    @Override
    public void run() {
        try {
            durationOfProgram();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
