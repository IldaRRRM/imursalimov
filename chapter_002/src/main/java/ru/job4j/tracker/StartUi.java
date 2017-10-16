package ru.job4j.tracker;

import java.util.Scanner;

/**
 * Public class StartUi is using for start of our tracker programm.
 */
public class StartUi {
    /**
     * object tracker is used for store applications.
     */
    private Tracker tracker = new Tracker();
    /**
     * The variable choice  is used to select in the menu.
     */
    private byte choice;
    /*
     *                      ****Constants, which used in the Menu***
     */
    /**
     * add - add to the tracker.
     */
    private final byte add = 0;
    /**
     * show - show all items.
     */
    private final byte show = 1;
    /**
     * edit - edit the item.
     */
    private final byte edit = 2;
    /**
     * delete delete the item.
     */
    private final byte delete = 3;
    /**
     * findItById - find item by Id.
     */
    private final byte findItByID = 4;
    /**
     * findByName - find item by Name.
     */
    private final byte findByName = 5;
    /**
     * exit - exit from programm.
     */
    private final byte exit = 6;


    /**
     * method printMenu is used for print menu items.
     */

    public void printMenu() {
        System.out.print("\t" + "Menu" + "\n" + "0: Add new Item" + "\n" + "1: Show all items" + "\n" + "2: Edit idem" + "\n"
                + "3: Delete Item" + "\n" + "4: Find item by Id" + "\n" + "5: Find items by name"
                + "\n" + "6: Exit programm" + "\n" + "Select: ");
    }

    /**
     * @return - return choice for working with our menu.
     */
    public byte choice() {
        Scanner scanner = new Scanner(System.in);
        this.choice = scanner.nextByte();
        return this.choice;
    }

    /**
     * @param choice - param for working with our menu.
     *               method treatment is used for select items in our menu.
     */
    public void treatment(byte choice) {
        if (choice == this.add) {
            createItem();
        } else if (choice == this.show) {

        } else if (choice == this.edit) {

        } else if (choice == this.delete) {

        } else if (choice == this.findItByID) {
            findItemById();
        } else if (choice == this.findByName) {

        } else if (choice == this.exit) {
            this.choice = exit;
        }
    }

    /**
     * method createItem is used for creating and add to our tracker.
     */
    public void createItem() {
        ConsoleInput cons = new ConsoleInput();
        String answerName = cons.ask("Please, enter the name: ");
        String answerDesc = cons.ask("Please, enter the description: ");
        String id = "";
        Item item = new Item(answerName, answerDesc, id);
        this.tracker.add(item);
        System.out.println("The item has been added." + "\n" + "its id is: " + item.getId());
    }

    /**
     * method findItemById is used for searching applications by id.
     */
    public void findItemById() {
        ConsoleInput cons = new ConsoleInput();
        String answerId = cons.ask("Please, enter the id of application: ");
        System.out.println("The name is: " + this.tracker.findById(answerId).getName() + "\n" + "Description is: "
                + this.tracker.findById(answerId).getDesc() + "\n" + "id is: "
                + this.tracker.findById(answerId).getId());
    }

    /**
     * method dynamicMenu is used for start dynamic menu.
     */
    public void dynamicMenu() {
        while (this.choice != this.exit) {
            printMenu();
            treatment(choice());
        }
    }

    /**
     * @param args - args.
     * method main - point of start.
     */
    public static void main(String[] args) {
        StartUi start = new StartUi();
        start.dynamicMenu();
    }
}

