package ru.job4j.tracker;

import java.util.List;

public interface ITracker {

    void add(Item item);

    void replace(String id, Item item);

    void delete(String id);

    List<Item> findAll();

    Item findByName(String key);

    Item findById(String id);
}
