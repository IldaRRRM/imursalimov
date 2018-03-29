package ru.job4j.threads.interrupt;

public class Time implements Runnable {

    private final Thread receivedThread;
    private final long pation;
    private final long sleep;

    public Time(Thread thread, long sleep) {
        this.receivedThread = thread;
        this.pation = 1000;
        this.sleep = sleep;
    }

    public void durationOfProgram() throws InterruptedException {
        Thread timeThread = new Thread();
        receivedThread.start();
        timeThread.start();
        try {
            long startTime = System.currentTimeMillis();
            receivedThread.join();
            Thread.sleep(sleep);
            timeThread.join();
            long executionTime = System.currentTimeMillis() - startTime;
            if (executionTime > pation) {
                throw new InterruptedException();
            }
            System.out.printf("Execution time is : %d ms.", executionTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
