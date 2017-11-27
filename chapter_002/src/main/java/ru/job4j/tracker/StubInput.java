package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * class StubInput for input without user.
 */
public class StubInput implements Input {
    /**
     * answers for input.
     */
    private ArrayList<String> answers = new ArrayList<>();
    /**
     * position for answers.
     */
    private int position = 0;
    /**
     * @param answers recieved answers;
     */
    public StubInput(ArrayList<String> answers) {
        this.answers = answers;
    }
    public String ask(String question) {
        return answers.get(position++);
    }
    /**
     *
     * @return answers with position.
     */
    public int ask(String question, List<Integer> range) {
        int key = Integer.parseInt(this.ask(question));
        int result = -1;
        for (Integer ranges : range) {
            if (ranges == key) {
                result = key;
                break;
            }
        }
     return result;
    }
}
