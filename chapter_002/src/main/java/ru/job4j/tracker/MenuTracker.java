package ru.job4j.tracker;
/**
*public class MenuTracker realized menu for tracker application.
*/
public class MenuTracker {
	/**
	 * private boolean m - is used for "while" our menu.
	 */
	private boolean m;
	/**
	 *private field input is used for read values.
	 */
	private Input input;
	/**
	 *private field tracker stores array of items.
	 */
	private Tracker tracker;
	/**
	 * array actions is used for store items for our application.
	 */
	private UserAction[] actions = new UserAction[8];
	/**
	 * index - index for items in "answers".
	 */
	private int index;

	/**
	 * MenuTracker constructor.
	 * @param input - received input.
	 * @param tracker - received tracker.
	 */
	public MenuTracker(Input input, Tracker tracker) {
		this.input = input;
		this.tracker = tracker;
	}

	/**
	 * method fillAction fills our menu by items.
	 */
	public void fillAction() {

		this.actions[1] = new AddNewItem();
		this.actions[2] = new ShowAllItems();
		this.actions[3] = new EditItem();
		this.actions[4] = new DeleteItem();
		this.actions[5] = new FindItemById();
		this.actions[6] = new FindItemByName();
		this.actions[7] = new ExitFromProgram();
	}

	/**
	 * @param key - for select our items in the menu.
	 */
	public void select(int key) {
		this.actions[key].execute(this.input, this.tracker);
	}


	/**
	 * method show shows our menu on the screen.
	 */
	public void show() {
		for (UserAction action : this.actions) {
			if (action != null) {
				System.out.println(action.info());
			}
		}
	}

	/**
	 * public class AddNewItem includes method, which adds items in tracker.
	 */
	public class AddNewItem implements UserAction {
		/**
		 * @return - return number of interaction with our menu.
		 */
		public int key() {
			return 1;
		}

		/**
		 * @return - the name of the item.
		 */
		public String info() {
			return String.format("%s %s", this.key(), "Add the new Item");
		}

		/**
		 * @param input - used to enter.
		 * @param tracker - received tracker.
		 */
		public void execute(Input input, Tracker tracker) {
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
	private class ShowAllItems implements UserAction {
		/**
		 * @return return number of interaction with our menu.
		 */
		public int key() {
			return 2;
		}

		/**
		 * method info shows name of the item.
		 * @return - name of the menu item.
		 */
		public String info() {
			return String.format("%s %s", this.key(), "Show all items");
		}

		/**
		 * @param input - used to enter.
		 * @param tracker - received tracker.
		 */
		public void execute(Input input, Tracker tracker) {
			int index = 0;
			for (Item item : tracker.findAll()) {
				index += 1;
				System.out.println("index №" + index + "\n" + "The name is " + item.getName() + "\n"
						+ "The id is" + item.getId());
			}
		}
	}

	/**
	 *@return - number of interaction with our menu.
	 */
	private class EditItem implements UserAction {
		/**
		 *
		 * @return return number of interaction with our menu.
		 */
		public int key() {
			return 3;
		}

		/**
		 * method info shows name of the item.
		 * @return - name of the menu item.
		 */
		public String info() {
			return String.format("%s %s", this.key(), "Edit item");
		}

		/**
		 * @param input - used to enter.
		 * @param tracker - received tracker.
		 */
		public void execute(Input input, Tracker tracker) {
			String oldId = input.ask("Enter the id for old Item: ");
			System.out.println("the old name is: " + tracker.findById(oldId).getName()
					+ "\n" + "The old description is: " + tracker.findById(oldId).getDesc());
			String newName = input.ask("Enter the new name: ");
			String newDesc = input.ask("Enter the new Desc: ");
			Item item = new Item(newName, newDesc, "23");
			item.setId(tracker.findById(oldId).getId());
			tracker.update(item);
		}
	}

	/**
	 *public class DeleteItem includes method for delete items in our tracker.
	 */
	private class DeleteItem implements UserAction {
		/**
		 * @return return number of interaction with our menu.
		 */
		public int key() {
			return 4;
		}

		/**
		 * method info shows name of the item.
		 * @return - name of the menu item.
		 */
		public String info() {
			return String.format("%s %s", this.key(), "Delete Item");
		}

		/**
		 * @param input - used to enter.
		 * @param tracker - received tracker.
		 */
		public void execute(Input input, Tracker tracker) {
			boolean l = true;
			while (l) {
				String answer = input.ask("Would you like to search by name or Id (Name/Id)");
				if (answer.equals("Name")) {
					String delName = input.ask("Enter the name of id, which you want to delete");
					tracker.delete(tracker.findByName(delName));
					System.out.println("The Item has been deleted.");
					break;
				} else if (answer.equals("Id")) {
					String delId = input.ask("Enter the item id, which you want to delete: ");
					tracker.findById(delId);
					tracker.delete(tracker.findById(delId));
					System.out.println("The Item has been deleted.");
					break;
				} else {
					System.out.println("Please, enter the correct answer.");
				}
			}
		}
	}

	/**
	 *
	 */
	private class FindItemById implements UserAction {
		/**
		 * @return return number of interaction with our menu.
		 */
		public int key() {
			return 5;
		}

		/**method info shows name of the item.
		 * @return - name of the menu item.
		 */
		public String info() {
			return String.format("%s %s", this.key(), "Find item by ID");
		}

		/**
		 * @param input - used to enter.
		 * @param tracker - received tracker.
		 */
		public void execute(Input input, Tracker tracker) {
			String answerId = input.ask("Please, enter the id of application: ");
			System.out.println("The name is: " + tracker.findById(answerId).getName() + "\n" + "Description is: "
					+ tracker.findById(answerId).getDesc() + "\n" + "id is: "
					+ tracker.findById(answerId).getId());
		}
	}

	/**
	 *class FindItemByName includes method for finding items in the tracker by Names.
	 */
	private class FindItemByName implements UserAction {
		/**
		 * @return return number of interaction with our menu.
		 */
		public int key() {
			return 6;
		}

		/**
		 * method info shows name of the item.
		 * @return - name of the menu item.
		 */
		public String info() {
			return String.format("%s %s", this.key(), "Find item by Name");
		}

		/**
		 * @param input - used to enter.
		 * @param tracker - received tracker.
		 */
		public void execute(Input input, Tracker tracker) {
			String answerName = input.ask("Please, enter the Name of application: ");
			tracker.findByName(answerName);
			System.out.println("The name is: " + tracker.findByName(answerName).getName() + "\n" + "Description is: "
					+ tracker.findByName(answerName).getDesc() + "\n" + "id is: "
					+ tracker.findByName(answerName).getId());
		}
	}

	/**
	 *Class ExitFromProgram includes methods for showing item for exit from our program.
	 */
	private class ExitFromProgram implements UserAction {
		/**
		 * @return number of interaction with our menu.
		 */
		public int key() {
			return 7;
		}

		/**
		 * method info shows name of the item.
		 * @return - name of the menu item.
		 */
		public String info() {
			return String.format("%s %s", this.key(), "Exit from program");
		}

		/**
		 * @param input - used to enter.
		 * @param tracker - received tracker.
		 */
		public void execute(Input input, Tracker tracker) {

		}
	}
}