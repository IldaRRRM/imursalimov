package ru.job4j.threads.wordsandspaces;

public class AmountOfSpaces implements Runnable {
    private final String sentence;

    public AmountOfSpaces(String sentence) {
        this.sentence = sentence;
    }

    public void getAmountOfSpaces() {
        System.out.printf("Program is starting.%n");
        int amounmtOfSpace = 0;
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == ' ') {
                amounmtOfSpace++;
            }
        }
        System.out.printf("amount of Space is %d.%n", amounmtOfSpace);
        System.out.printf("%s%n", "program is done.");
    }

    @Override
    public void run() {
        getAmountOfSpaces();
    }
}
