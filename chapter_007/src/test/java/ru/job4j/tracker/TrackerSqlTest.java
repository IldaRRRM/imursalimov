package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.core.Is.is;

public class TrackerSqlTest {


    @Test
    public void addItemToTracker() throws IOException, SQLException {
        try (TrackerSql trackerSql = new TrackerSql(ClassLoader.getSystemResource("app.properties").getPath())) {
            trackerSql.init();
            Long longId = System.currentTimeMillis();
            Integer id = longId.intValue();
            trackerSql.add(new Item(id.toString(), "testItem", "firstTest", LocalDate.now(), 1, 1));
            try (PreparedStatement preparedStatement = trackerSql.getConnection().prepareStatement("SELECT id FROM item WHERE id = ?")) {
                preparedStatement.setInt(1, id);
                preparedStatement.execute();
                ResultSet set = preparedStatement.getResultSet();
                while (set.next()) {
                    Assert.assertThat(set.getInt(1), is(id));
                }
            }
        }
    }

    @Test
    public void deleteItemFromTracker() throws IOException, SQLException {
        try (TrackerSql trackerSql = new TrackerSql(ClassLoader.getSystemResource("app.properties").getPath())) {
            trackerSql.init();
            Long longId = System.currentTimeMillis();
            int id = longId.intValue();
            trackerSql.add(new Item(String.valueOf(id), "testItem", "firstTest", LocalDate.now(), 1, 1));
            trackerSql.delete(String.valueOf(id));

        }
    }

    @Test
    public void TestMethodFindItemById() throws IOException, SQLException {
        try (TrackerSql trackerSql = new TrackerSql(ClassLoader.getSystemResource("app.properties").getPath())) {
            trackerSql.init();
            Long longId = System.currentTimeMillis();
            int id = longId.intValue();
            Item expectedItem = new Item(String.valueOf(id), "testItem", "firstTest", LocalDate.now(), 1, 1);
            trackerSql.add(expectedItem);
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
            Long longId = System.currentTimeMillis();
            int id = longId.intValue();
            Item expectedItem = new Item(String.valueOf(id), "testItem", "firstTest", LocalDate.now(), 1, 1);
            trackerSql.add(expectedItem);
            Item actualItem = new Item(expectedItem.getId(), "newName", "new Descr", LocalDate.now().plusMonths(1L), 1, 1);
            trackerSql.replace(expectedItem.getId(), actualItem);
            Assert.assertThat(trackerSql.findById(expectedItem.getId()), is(actualItem));
        }
    }
}