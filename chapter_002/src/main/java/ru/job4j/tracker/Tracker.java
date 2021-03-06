package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * class Tracker is using for stroe applications.
 */
public class Tracker implements ITracker {
    /**
     * number of applications.
     */
    private List<Item> items = new ArrayList<>();

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
    public boolean add(Item item) {
        item.setId(generateId());
        return items.add(item);
    }

    @Override
    public boolean replace(String id, Item item) {
        Item replacedItem = findById(id);
        items.remove(replacedItem);
        item.setId(replacedItem.getId());
        return items.add(item);
    }

    @Override
    public boolean delete(String id) {
        boolean deleteResult = false;
        for (Item item1 : items) {
            if (item1.getId().equals(id)) {
                deleteResult = items.remove(item1);
                break;
            }

        }
        return deleteResult;
    }


    /**
     * method findId used for find item by ID.
     *
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
     *
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
     *
     * @return generateId.
     */
    public String generateId() {
        Random random = new Random();
        return String.valueOf(System.currentTimeMillis() + random.nextInt(100));
    }

    /**
     * @return list of items.
     */
    public List<Item> findAll() {
        return items;
    }

    /**
     * @param item - recieved param.
     */
    public void update(Item item) {
        String id = item.getId();
        for (Item item1 : items) {
            if (item1.getId().equals(id)) {
                items.set(items.indexOf(item1), item);
                break;
            }
        }
    }
}


