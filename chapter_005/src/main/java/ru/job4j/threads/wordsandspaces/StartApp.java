package ru.job4j.threads.wordsandspaces;

public class StartApp {

    public void init() {
        String sentence = "Hello world, winter is came and don't goes out";
        Thread threadOfWords = new Thread(new NumberOfWords(sentence));
        Thread spaceAmountThread = new Thread(new AmountOfSpaces(sentence));
        spaceAmountThread.start();
        threadOfWords.start();
        try {
            spaceAmountThread.join();
            threadOfWords.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new StartApp().init();
    }
}
