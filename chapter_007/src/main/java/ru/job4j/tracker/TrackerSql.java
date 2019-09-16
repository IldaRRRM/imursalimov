package ru.job4j.tracker;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import ru.job4j.tracker.config.TrackerConfig;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Getter
public class TrackerSql implements ITracker, AutoCloseable {
    private final TrackerConfig config;
    private Connection connection;


    public TrackerSql(String pathToProperties) throws IOException {
        this.config = new TrackerConfig(pathToProperties);
    }

    private void initDataBase() {
        try {
            this.connection = DriverManager.getConnection(config.getPostgresAddres(),
                    config.getUserName(),
                    config.getPassword());
            Class.forName(config.getDriverClassName());

        } catch (SQLException | ClassNotFoundException e) {
            log.error(e.getMessage(), e);
        }
        if (config.getDatabaseName().equals("tracker")) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(ClassLoader.getSystemResource("tracker.sql").getFile())));
                 Statement statement = this.connection.createStatement()) {
                StringBuilder sqlScript = new StringBuilder();
                while (reader.ready()) {
                    String txtFromSql = reader.readLine().trim();
                    log.debug(txtFromSql);
                    if (!txtFromSql.isEmpty()) {
                        sqlScript.append(txtFromSql);
                    }
                }
                log.debug(sqlScript.toString());
                statement.execute(sqlScript.toString());
                log.info("Script successfully executed");
            } catch (IOException | SQLException e) {
                log.error(e.getMessage(), e);
            }
        }
    }


    private boolean connectToUrl() {
        try {
            this.connection = DriverManager.getConnection(config.getPostgresAddres(),
                    config.getUserName(),
                    config.getPassword());
            Class.forName(config.getDriverClassName());
        } catch (SQLException | ClassNotFoundException e) {
            log.error(e.getMessage(), e);
        }
        return this.connection != null;
    }

    public boolean init() {
        boolean success = connectToUrl();
        if (success) {
            log.info("Connect to data base {}", this.config.getUrl());
        } else {
            log.warn("Database {} doesn't exist", this.config.getUrl());
            initDataBase();
        }
        return success;
    }

    @Override
    public void close() throws SQLException {
        this.connection.close();
    }

    @Override
    public boolean add(Item item) {
        createItemTableIfNotExists();
        try (PreparedStatement statement = this.connection.prepareStatement(
                "INSERT INTO item (itemName, descr, created, category_id, itemuser_id) VALUES (?, ?, ?, ?, ?);")) {
            statement.setString(1, item.getName());
            statement.setString(2, item.getDesc());
            statement.setDate(3, Date.valueOf(item.getCreated()));
            statement.setInt(4, item.getCategoryId());
            statement.setInt(5, item.getUserId());
            statement.execute();
            log.info("Item {} has been added", item.getName());
            return true;
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
        return false;
    }

    private void createItemTableIfNotExists() {
        try (PreparedStatement st = this.connection.prepareStatement("CREATE TABLE IF NOT EXISTS item (id SERIAL PRIMARY KEY, itemName VARCHAR(80), descr VARCHAR(80), created DATE, category_id INT REFERENCES category(id), itemUser_id INT REFERENCES itemUser(id))")) {
            st.execute();
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
    }


    @Override
    public boolean replace(String id, Item item) {
        boolean result = false;
        try (PreparedStatement updateStatement = this.connection.prepareStatement(
                "UPDATE item SET id = ?, itemname = ?, descr = ?, created = ?, category_id = ?, itemuser_id = ? WHERE id = ?")) {
            updateStatement.setInt(7, Integer.parseInt(id));
            updateStatement.setInt(1, Integer.parseInt(item.getId()));
            updateStatement.setString(2, item.getName());
            updateStatement.setString(3, item.getDesc());
            updateStatement.setDate(4, Date.valueOf(item.getCreated()));
            updateStatement.setInt(5, item.getCategoryId());
            updateStatement.setInt(6, item.getUserId());
            updateStatement.execute();
            log.info("replace item with {} for {} was success", id, item);
            result = true;
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        try (PreparedStatement deleteStatement = this.connection.prepareStatement(
                "DELETE FROM item WHERE id = ?")) {
            deleteStatement.setInt(1, Integer.parseInt(id));
            deleteStatement.execute();
            log.info("Item with id = {} has been deleted", id);
            result = true;
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public List<Item> findAll() {
        try (PreparedStatement findAllStatement = this.connection.prepareStatement(
                "SELECT * from item"
        )) {
            findAllStatement.execute();
            return getAllItems(findAllStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Item findByName(String key) {
        try (PreparedStatement findByName = this.connection.prepareStatement(
                "SELECT * FROM item WHERE itemname = ?")) {
            findByName.setString(1, key);
            findByName.execute();

            return getItem(findByName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Item findById(String id) {
        try (PreparedStatement findById = this.connection.prepareStatement(
                "SELECT * FROM item WHERE id = ?")) {
            findById.setInt(1, Integer.parseInt(id));
            findById.execute();
            return getItem(findById);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    private Item getItem(PreparedStatement preparedStatement) {
        Item findestItem = null;
        try (ResultSet resultSet = preparedStatement.getResultSet()) {
            if (resultSet.next()) {
                String name = resultSet.getString("itemname");
                Integer itemId = resultSet.getInt("id");
                String descr = resultSet.getString("descr");
                Date itemDate = resultSet.getDate("created");
                Integer categoryId = resultSet.getInt("category_id");
                Integer itemUserId = resultSet.getInt("itemuser_id");
                findestItem = new Item(itemId.toString(), name, descr, itemDate.toLocalDate(), categoryId, itemUserId);
                log.info("Find Item = {}", findestItem);
            } else {
                log.error("Item with id not found");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return findestItem;
    }

    private List<Item> getAllItems(PreparedStatement preparedStatement) {
        List<Item> allItems = new ArrayList<>();
        try (ResultSet resultSet = preparedStatement.getResultSet()) {
            while (resultSet.next()) {
                String name = resultSet.getString("itemname");
                Integer itemId = resultSet.getInt("id");
                String descr = resultSet.getString("descr");
                Date itemDate = resultSet.getDate("created");
                Integer categoryId = resultSet.getInt("category_id");
                Integer itemUserId = resultSet.getInt("itemuser_id");
                Item oneOfItems = new Item(String.valueOf(itemId), name, descr, itemDate.toLocalDate(), categoryId, itemUserId);
                log.debug("Find Item = {}", oneOfItems);
                allItems.add(oneOfItems);
            }
            return allItems;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allItems;
    }

    public Integer getCountOfRows(String tableName) throws SQLException {
        try (Statement rowCount = this.connection.createStatement()) {
            String sql = "SELECT COUNT(*) from " + tableName;
            rowCount.execute(sql);
            try (ResultSet resultSet = rowCount.getResultSet()) {
                resultSet.next();
                return resultSet.getInt(1);
            }
        }
    }
}
