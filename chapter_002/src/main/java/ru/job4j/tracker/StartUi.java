package ru.job4j.tracker;
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
     * object tracker is used for store applications.
     */
    private Tracker tracker;

    /**
     * method dynamicMenu is used for start dynamic menu.
     */
    public void dynamicMenu() {
        MenuTracker menuTracker = new MenuTracker(input, tracker);
        menuTracker.fillAction();
        menuTracker.fillRangeOfMenu();
        while (menuTracker.getExit()) {
            menuTracker.show();
            menuTracker.select();
        }
    }
    /**
     * @param args - args.
     * method main - point of start.
     */
    public static void main(String[] args) {
        new StartUi(new ValidateInput(), new Tracker()).dynamicMenu();
    }
}

