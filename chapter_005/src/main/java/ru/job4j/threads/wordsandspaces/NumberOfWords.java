package ru.job4j.threads.wordsandspaces;

public class NumberOfWords implements Runnable {

    private final String sentence;

    public NumberOfWords(String sentence) {
        this.sentence = sentence;
    }

    public void amountOfWords() {
        System.out.printf("%nProgram is starting.%n");
        int valueOfWords = 0;
        for (int i = 0; i < sentence.length() - 1; i++) {
            if (sentence.charAt(i) != ' '
                    && sentence.charAt(i + 1) == ' '
                    || sentence.charAt(i) != ' '
                    && i + 1 == sentence.length() - 1) {
                valueOfWords++;
            }
        }
        System.out.printf("amount of words is %d", valueOfWords);
        System.out.printf("%n%s%n", "program is done.");
    }

    @Override
    public void run() {
        amountOfWords();
    }
}

