package ru.job4j.user;


import java.util.Random;

/**
 *
 */
public class User {
    /**
     *id.
     */
    private int id;
    /**
     *name of user.
     */
    private String name;
    /**
     *City.
     */
    private String city;

    /**
     * Constructor
     * @param id - id.
     * @param name - name.
     * @param city - city.
     */
    User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    /**
     * Getter.
     * @return - return id.
     */
    public int getId() {
        return this.id;
    }

    /**
     * Getter.
     * @return - name.
     */
    public String getName() {
        return name;
    }
}
