package ru.job4j.tracker;

import java.util.Random;

/**
*class Tracker is using for stroe applications.
*/
public class Tracker {
	/**
	 * number of applications.
	 */
	private Item[] items = new Item[100];
	/**
	 * position - position of item.
	 */
	private int position = 0;
	/**
	 * key - using for search by name.
	 */
	private String key;


	/**
	 * method add is using for add item.
	 *
	 * @param item - received.
	 * @return - new item.
	 */
	public Item add(Item item) {
		item.setId(this.generateId());
		this.items[position++] = item;
		return item;
	}

	/**
	 * method findId used for find item by ID.
	 * @param id - received id.
	 * @return - return a found item bt id.
	 */
	public Item findById(String id) {
		Item result = null;
		for (Item item : items) {
			if (item != null && item.getId().equals(id)) {
				result = item;
				break;
			}
		}
		return result;
	}

	/**
	 * method findByName used for find item by name.
	 * @param key received parametr, which using for search by name.
	 * @return - return find item by name.
	 */
	public Item findByName(String key) {
		Item result = null;
		for (Item item : items) {
			if (item != null && item.getName().equals(key)) {
				result = item;
				break;
			}
		}
		return result;
	}

	/**
	 * method generateId - generated id for item.
	 * @return generateId.
	 */
	public String generateId() {
		Random random = new Random();
		return String.valueOf(System.currentTimeMillis() + random.nextInt(100));
	}

	/**
	 * @return list of items.
	 */
	public Item[] findAll() {
		Item[] result = new Item[this.position];
		for (int index = 0; index != this.position; index++) {
			result[index] = this.items[index];
		}
		return result;
	}

	/**
	 * @param item - recieved param.
	 */
	public void update(Item item) {
		String id = item.getId();
		for (int index = 0; index != position; index++) {
			if (items[index].getId().equals(id)) {
				items[index] = item;
				break;
			}
		}
	}

	/**
	 * @param item - recieved param.
	 */
	public void delete(Item item) {
		for (int index = 0; index != position; index++) {
			if (items[index].getId().equals(item.getId())) {
				items[index] = null;
				break;
			}

		}
		for (int index = 0; index != position; index++) {
			if (items[index] == null) {
				items[index] = items[position - 1];
				position--;
				break;
			}
		}
	}
}


