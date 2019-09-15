package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import static org.hamcrest.core.Is.is;

public class TrackerSqlTest {


    @Test
    public void addItemToTracker() throws IOException, SQLException {
        try (TrackerSql trackerSql = new TrackerSql(ClassLoader.getSystemResource("app.properties").getPath())) {
            trackerSql.init();
            Assert.assertThat(trackerSql.add(new Item("testItem" + new Random().nextInt(100), "firstTest", LocalDate.now(), 1, 1)), is(true));

        }
    }

    @Test
    public void deleteItemFromTracker() throws IOException, SQLException {
        try (TrackerSql trackerSql = new TrackerSql(ClassLoader.getSystemResource("app.properties").getPath())) {
            trackerSql.init();
            List<Item> trackerSqlAll = trackerSql.findAll();
            int randomItemIndex = new Random().nextInt(trackerSqlAll.size());
            String id = trackerSqlAll.get(randomItemIndex).getId();
            Assert.assertThat(trackerSql.delete(id), is(true));
        }
    }

    @Test
    public void findItemById() throws IOException, SQLException {
        try (TrackerSql trackerSql = new TrackerSql(ClassLoader.getSystemResource("app.properties").getPath())) {
            trackerSql.init();
            List<Item> trackerSqlAll = trackerSql.findAll();
            int randomItemIndex = new Random().nextInt(trackerSqlAll.size());
            Item expectedItem = trackerSqlAll.get(randomItemIndex);
            Item actualItem = trackerSql.findById(expectedItem.getId());
            Assert.assertThat(actualItem, is(expectedItem));
        }
    }

    @Test
    public void findAllItems() throws IOException, SQLException {
        try (TrackerSql trackerSql = new TrackerSql(ClassLoader.getSystemResource("app.properties").getPath())) {
            trackerSql.init();
            List<Item> all = trackerSql.findAll();
            Integer rowCount = trackerSql.getCountOfRows("item");
            Assert.assertThat(all.size(), is(rowCount));
        }
    }

    @Test
    public void replace() throws IOException, SQLException {
        try (TrackerSql trackerSql = new TrackerSql(ClassLoader.getSystemResource("app.properties").getPath())) {
            trackerSql.init();
            Item expectedItemBeforeAddToBase = new Item("expectedItem", "firstTest", LocalDate.now(), 1, 1);
            trackerSql.add(expectedItemBeforeAddToBase);
            Item expectedItem = trackerSql.findByName(expectedItemBeforeAddToBase.getName());
            Item actualItem = new Item(expectedItem.getId(), "newName", "new Descr", LocalDate.now().plusMonths(1L), 1, 1);
            trackerSql.replace(expectedItem.getId(), actualItem);
            Assert.assertThat(trackerSql.findById(expectedItem.getId()), is(actualItem));
        }
    }
}