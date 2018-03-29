package ru.job4j.threads.interrupt;

public class StartApp {
    public static void main(String[] args) {
        CountChar countChar = new CountChar("Hello world, winter came and don't goes out");
        Thread charThread = new Thread(countChar);
        Time time = new Time(charThread, 1000);
        Thread timeThread = new Thread(time);
        timeThread.start();
    }

}
