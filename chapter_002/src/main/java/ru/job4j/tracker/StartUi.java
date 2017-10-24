package ru.job4j.tracker;

//import java.util.Scanner;

/**
 * Public class StartUi is using for start of our tracker programm.
 */
public class StartUi {
    /**
     * empty constructor.
     */
    public StartUi() {
    }
    /**
     * private field input is used for read values.
     */

    private Input input;

    /**
     * @param input   - received input.
     * @param tracker - received tracker.
     */
    StartUi(Input input, Tracker tracker) {
        this.tracker = tracker;
        this.input = input;
    }

    /**
     * m - is used for "while" dynamic menu.
     */
    private boolean m = true;

    /**
     * object tracker is used for store applications.
     */
    private Tracker tracker;

    /**
     * method dynamicMenu is used for start dynamic menu.
     */
    public void dynamicMenu() {
        MenuTracker menuTracker = new MenuTracker(input, tracker);
        while (m) {
            menuTracker.fillAction();
            menuTracker.show();
            String answer = input.ask("Select: ");
            int key = Integer.parseInt(answer);
            menuTracker.select(key);
            if (answer.equals("7")) {
                m = false;
            }
        }
    }

    /**
     * @param args - args.
     * method main - point of start.
     */

    public static void main(String[] args) {
        new StartUi(new ConsoleInput(), new Tracker()).dynamicMenu();
    }
}

