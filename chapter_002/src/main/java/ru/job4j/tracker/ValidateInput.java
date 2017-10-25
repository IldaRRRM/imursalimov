package ru.job4j.tracker;
/**
 * public class ValidateInput includes method ask, which used for correct work with our tracker application.
 */
public class ValidateInput extends ConsoleInput {
    /**
     * method ask is used for working in menu with user.
     * @param question - question.
     * @param range - range of our menu.
     * @return - return our key.
     */
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask("Select: ", range);
                invalid = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Please, enter validate date again");
            } catch (MenuOutException nfe) {
                System.out.println("Please, select item from menu");
            }
        } while (invalid);
        return value;
    }
}
