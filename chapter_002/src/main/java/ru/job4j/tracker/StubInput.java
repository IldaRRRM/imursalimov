package ru.job4j.tracker;

/**
 * class StubInput for input without user.
 */
public class StubInput implements Input {
    /**
     * answers for input.
     */
    private String[] answers;
    /**
     * position for answers.
     */
    private int position;
    /**
     * @param answers recieved answers;
     */
    public StubInput(String[] answers) {
        this.answers = answers;
    }

    /**
     * @param question - question about application.
     * @return answers with position.
     */
    public String ask(String question) {
        return answers[position++];
    }
    public int ask(String question, int[] range) {
     return -1;
    }
}
