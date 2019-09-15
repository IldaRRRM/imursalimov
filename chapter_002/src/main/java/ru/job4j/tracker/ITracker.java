package ru.job4j.tracker;

import java.util.List;

public interface ITracker {

    boolean add(Item item);

    boolean replace(String id, Item item);

    boolean delete(String id);

    List<Item> findAll();

    Item findByName(String key);

    Item findById(String id);
}
