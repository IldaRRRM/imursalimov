package ru.job4j.tracker;

/**
 * public interface UserAction is used for store method, which used in Tracker application.
 */
public interface UserAction {


    /**
     * method which includes user actions in the application.
     *
     * @param input   - shows how we will enter data.
     * @param tracker - received tracker.
     */
    void execute(Input input, ITracker tracker);

    /**
     * @return - name of the menu item.
     */
    String info();
}