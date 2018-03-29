package ru.job4j.threads.interrupt;

import ru.job4j.threads.wordsandspaces.NumberOfWords;

public class CountChar implements Runnable {

    private final NumberOfWords numberOfWords;

    public CountChar(String sentence) {
       this.numberOfWords = new NumberOfWords(sentence);
    }

    @Override
    public void run() {
        numberOfWords.amountOfWords();
    }

}
