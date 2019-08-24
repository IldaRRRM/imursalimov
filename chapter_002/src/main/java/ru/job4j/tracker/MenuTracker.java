package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * public class MenuTracker realized menu for tracker application.
 */
public class MenuTracker {
    /**
     * position.
     */
    private int position = 1;
    /**
     * range of menu items.
     */
    private List<Integer> range = new ArrayList<>();
    /**
     * private boolean exit - is used for "while" our menu.
     */
    private boolean exit = true;

    /**
     * @param exit - value for While cycle.
     */
    public void setExit(boolean exit) {
        this.exit = exit;
    }

    /**
     * getter for exit value.
     */
    public boolean getExit() {
        return this.exit;
    }

    /**
     * private field input is used for read values.
     */
    private Input input;
    /**
     * private field tracker stores array of items.
     */
    private ITracker tracker;
    /**
     * array actions is used for store items for our application.
     */
    private ArrayList<UserAction> actions = new ArrayList<>();
    /**
     * index - index for items in "answers".
     */
    private int index;

    /**
     * MenuTracker constructor.
     *
     * @param input   - received input.
     * @param tracker - received tracker.
     */
    public MenuTracker(Input input, ITracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * method fillAction fills our menu by items.
     */
    public void fillAction() {
        actions.add(new AddNewItem("Add new Item", 1));
        actions.add(new ShowAllItems("Show all Items", 2));
        actions.add(new EditItem("Edit item", 3));
        actions.add(new DeleteItem("Delete item", 4));
        actions.add(new FindItemById("Find items by id", 5));
        actions.add(new FindItemByName("Find items by name", 6));
        actions.add(new ExitFromProgram("Exit from program", 7));
    }

    /**
     * Fill range of Menu.
     */
    public void fillRangeOfMenu() {
        Integer[] menuKey = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        List<Integer> integerMenuKey = Arrays.asList(menuKey);
        range.addAll(integerMenuKey);
    }

    /**
     * Select key for working with menu.
     */
    public void select() {
        int key = input.ask("Select: ", range);
        actions.get(key - 1).execute(this.input, this.tracker);
    }

    /**
     * method show shows our menu on the screen.
     */
    public void show() {
        for (UserAction action : actions) {
            System.out.println(action.info());
        }
    }


    /**
     * public class AddNewItem includes method, which adds items in tracker.
     */
    public class AddNewItem extends BaseAction {
        /**
         * @param name - name.
         * @param key  - key.
         */
        public AddNewItem(String name, int key) {
            super(name, key);
        }


        /**
         * @param input   - used to enter.
         * @param tracker - received tracker.
         */
        public void execute(Input input, ITracker tracker) {
            String name = input.ask("Please, enter the name: ");
            String desc = input.ask("Please, enter the description: ");
            Item item = new Item(name, desc, "23");
            tracker.add(item);
            index += 1;
            System.out.println("The item has been added." + "\n" + "item № " + index + "\n"
                    + "The name is " + item.getName() + "\n" + "The id is: " + item.getId());
        }
    }

    /**
     * public class ShowALlItems shows items for our menu.
     */
    private class ShowAllItems extends BaseAction {

        public ShowAllItems(String name, int key) {
            super(name, key);
        }

        /**
         * @param input   - used to enter.
         * @param tracker - received tracker.
         */
        public void execute(Input input, ITracker tracker) {
            int index = 0;
            for (Item item : tracker.findAll()) {
                index += 1;
                System.out.println("index №" + index + "\n" + "The name is: " + item.getName() + "\n"
                        + "The id is: " + item.getId());
            }
        }
    }

    private class EditItem extends BaseAction {
        /**
         * @param name - name of menu item.
         * @param key  - key for working with menu.
         */
        public EditItem(String name, int key) {
            super(name, key);
        }

        /**
         * @param input   - used to enter.
         * @param tracker - received tracker.
         */
        public void execute(Input input, ITracker tracker) throws NullPointerException {
            boolean exit = true;
            do {
                try {
                    String oldId = input.ask("Enter the id for old Item (Enter 0 to back in the menu): ");
                    if (oldId.equals("0")) {
                        break;
                    }
                    System.out.println("the old name is: " + tracker.findById(oldId).getName()
                            + "\n" + "The old description is: " + tracker.findById(oldId).getDesc());
                    String newName = input.ask("Enter the new name: ");
                    String newDesc = input.ask("Enter the new Desc: ");
                    Item item = new Item(newName, newDesc, "23");
                    item.setId(tracker.findById(oldId).getId());
                    tracker.replace(item.getId(), item);
                    exit = false;
                } catch (NullPointerException nfe) {
                    System.out.println("This id is not found.");
                }
            } while (exit);
        }
    }

    /**
     * public class DeleteItem includes method for delete items in our tracker.
     */
    private class DeleteItem extends BaseAction {
        public DeleteItem(String name, int key) {
            super(name, key);
        }

        /**
         * @param input   - used to enter.
         * @param tracker - received tracker.
         */
        public void execute(Input input, ITracker tracker) {
            try {
                while (true) {
                    String answer = input.ask("Would you like to search by name or Id (Name/Id): ");
                    if (answer.equals("Name")) {
                        String delName = input.ask("Enter the name of id, which you want to delete: ");
                        tracker.delete(tracker.findByName(delName).getId());
                        System.out.println("The Item has been deleted.");
                        break;
                    } else if (answer.equals("Id")) {
                        String delId = input.ask("Enter the item id, which you want to delete: ");
                        tracker.findById(delId);
                        tracker.delete(tracker.findById(delId).getId());
                        System.out.println("The Item has been deleted.");
                        break;
                    } else {
                        System.out.println("Please, enter the correct answer.");
                    }
                }
            } catch (NullPointerException nfe) {
                System.out.println("Item is not found");
            }

        }
    }

    /**
     * FindItemsById.
     */
    private class FindItemById extends BaseAction {

        public FindItemById(String name, int key) {
            super(name, key);
        }

        /**
         * @param input   - used to enter.
         * @param tracker - received tracker.
         */
        public void execute(Input input, ITracker tracker) {
            try {
                String answerId = input.ask("Please, enter the id of application: ");
                System.out.println("The name is: " + tracker.findById(answerId).getName() + "\n" + "Description is: "
                        + tracker.findById(answerId).getDesc() + "\n" + "id is: "
                        + tracker.findById(answerId).getId());
            } catch (NullPointerException nfe) {
                System.out.println("The item is not found");
            }
        }
    }

    /**
     * class FindItemByName includes method for finding items in the tracker by Names.
     */
    private class FindItemByName extends BaseAction {
        public FindItemByName(String name, int key) {
            super(name, key);
        }

        /**
         * @param input   - used to enter.
         * @param tracker - received tracker.
         */
        public void execute(Input input, ITracker tracker) throws NullPointerException {
            boolean exit = true;
            while (exit) {
                try {
                    String answerName = input.ask("Please, enter the Name of application (Enter 0 to back to menu) : ");
                    if (answerName.equals("0")) {
                        break;
                    }
                    tracker.findByName(answerName);
                    System.out.println("The name is: " + tracker.findByName(answerName).getName() + "\n" + "Description is: "
                            + tracker.findByName(answerName).getDesc() + "\n" + "id is: "
                            + tracker.findByName(answerName).getId());
                    exit = false;
                } catch (NullPointerException nfe) {
                    System.out.println("This name is not found");
                }
            }
        }
    }

    /**
     * Class ExitFromProgram includes methods for showing item for exit from our program.
     */
    private class ExitFromProgram extends BaseAction {
        /**
         * Exit from program.
         *
         * @param name - name.
         * @param key  - key for working with menu.
         */
        ExitFromProgram(String name, int key) {
            super(name, key);
        }

        /**
         * @param input   - used to enter.
         * @param tracker - received tracker.
         */
        public void execute(Input input, ITracker tracker) {
            boolean ex = true;
            while (ex) {
                String answer = input.ask("Do you want to quit? (Y/N): ");
                switch (answer) {
                    case "Y":
                        ex = false;
                        setExit(false);
                        break;
                    case "N":
                        ex = false;
                        break;
                    default:
                        System.out.println("Enter the correct answer.");
                        break;
                }
            }
        }
    }
}