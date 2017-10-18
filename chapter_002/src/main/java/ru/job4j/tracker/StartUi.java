package ru.job4j.tracker;

//import java.util.Scanner;

/**
 * Public class StartUi is using for start of our tracker programm.
 */
public class StartUi {

    /**
     * private field input is used for read values.
     */

    private Input input;
    /**
     * @param input - recieved input.
     * @param tracker - recieved tracker.
     */
    StartUi(Input input, Tracker tracker) {
        this.tracker = tracker;
        this.input = input;
    }
    /**
     *m - is used for "while" dynamic menu.
     */
    private boolean m = true;
    /**
     * object tracker is used for store applications.
     */
    private Tracker tracker;
    /**
     * The variable choice  is used to select in the menu.
     */
    private String choice;
    /*
     *                      ****Constants, which used in the Menu***
     */
    /**
     * add - add to the tracker.
     */
    private final String add = "0";
    /**
     * show - show all items.
     */
    private final String show = "1";
    /**
     * edit - edit the item.
     */
    private final String edit = "2";
    /**
     * delete delete the item.
     */
    private final String delete = "3";
    /**
     * findItById - find item by Id.
     */
    private final String findItByID = "4";
    /**
     * findByName - find item by Name.
     */
    private final String findByName = "5";
    /**
     * exit - exit from programm.
     */
    private final String exit = "6";


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
    public String choice() {
        //Scanner scanner = new Scanner(System.in);
        this.choice = this.input.ask("Enter the item for menu"); //scanner.nextLine();
        return this.choice;
    }

    /**
     * @param choice - param for working with our menu.
     * method treatment is used for select items in our menu.
     */
    public void treatment(String choice) {
        if (choice.equals(this.add)) {
            createItem();
        } else if (choice.equals(this.show)) {
            System.out.println();
        } else if (choice.equals(this.edit)) {
            System.out.println();
        } else if (choice.equals(this.delete)) {
            System.out.println();
        } else if (choice.equals(this.findItByID)) {
            findItemById();
        } else if (choice.equals(this.findByName)) {
            System.out.println();
        } else if (choice.equals(this.exit)) {
            this.m = false;
        }
    }

    /**
     * method createItem is used for creating and add to our tracker.
     */
    public void createItem() {
        //ConsoleInput cons = new ConsoleInput();
        String answerName = input.ask("Please, enter the name: ");
        String answerDesc = input.ask("Please, enter the description: ");
        String id = "";
        Item item = new Item(answerName, answerDesc, id);
        this.tracker.add(item);
        System.out.println("The item has been added." + "\n" + "its id is: " + item.getId());
    }

    /**
     * method findItemById is used for searching applications by id.
     */
    public void findItemById() {
        //ConsoleInput cons = new ConsoleInput();
        String answerId = this.input.ask("Please, enter the id of application: ");
        System.out.println("The name is: " + this.tracker.findById(answerId).getName() + "\n" + "Description is: "
                + this.tracker.findById(answerId).getDesc() + "\n" + "id is: "
                + this.tracker.findById(answerId).getId());
    }

    /**
     * method dynamicMenu is used for start dynamic menu.
     */
    public void dynamicMenu() {
        while (m) {
            printMenu();
            treatment(choice());
        }
    }

    /**
     * @param args - args.
     * method main - point of start.
     */
    /*
    public static void main(String[] args) {
        Input input = new StubInput(new String[] {"0","desc","desc",});
        Tracker tracker = new Tracker();
        StartUi start = new StartUi(input, tracker);
        start.dynamicMenu();
    }
    */

}

