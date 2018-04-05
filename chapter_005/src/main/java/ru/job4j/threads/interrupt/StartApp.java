package ru.job4j.threads.interrupt;

public class StartApp {
    public static void main(String[] args) {
        Time time = new Time(1);
        Thread timeThread = new Thread(time);
        timeThread.start();
    }

}
