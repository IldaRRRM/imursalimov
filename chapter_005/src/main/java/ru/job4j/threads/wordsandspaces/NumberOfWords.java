package ru.job4j.threads.wordsandspaces;

public class NumberOfWords implements Runnable {

    private final String typeOfRun;
    private final String sentence;


    public NumberOfWords(String typeOfRun, String sentence) {
        this.typeOfRun = typeOfRun;
        this.sentence = sentence;
    }

    public void amountOfSpacesOrWords() throws InterruptedException {
        int valueOfWords = 0;
        int amounmtOfSpace = 0;
        if (typeOfRun.equals("spaces")) {
            for (int i = 0; i < sentence.length(); i++) {
                if (sentence.charAt(i) == ' ') {
                    amounmtOfSpace++;
                    System.out.printf("%d ", amounmtOfSpace);
                    Thread.sleep(500);
                }
            }
        } else {
            for (int i = 0; i < sentence.length() - 1; i++) {
                if (sentence.charAt(i) != ' '
                        && sentence.charAt(i + 1) == ' '
                        || sentence.charAt(i) != ' '
                        && i + 1 == sentence.length() - 1) {
                    valueOfWords++;
                    Thread.sleep(200);
                    System.out.printf("%d ", valueOfWords);

                }
            }
        }
    }

    @Override
    public void run() {
        try {
            amountOfSpacesOrWords();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String sentence = "Hello world winter came and don't goes out";
        new Thread(new NumberOfWords("spaces", sentence)).start();
        new Thread(new NumberOfWords("words", sentence)).start();
    }
}
