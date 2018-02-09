package ru.job4j.mapcollection;

import java.util.Calendar;

/**
 * Model User.
 */
public class User {

    private final String name;

    private int children;

    private Calendar birthday = new Calendar.Builder().build();

    /**
     * Constructor.
     * @param name     - name of User.
     * @param children - amount of children.
     * @param year     - year.
     * @param month    - month.
     * @param date     - date.
     */
    public User(String name, int children, int year, int month, int date) {
        this.name = name;
        this.children = children;
        this.birthday.set(year, month - 1, date);

    }

    /**
     * Getter
     * @return - return name.
     */
    public String getName() {
        return name;
    }

    /**
     * Return amount of children.
     * @return - amount of children.
     */
    public int getChildren() {
        return children;
    }

    /**
     * Getter.
     * @return - Birthday date.
     */
    public Calendar getBirthday() {
        return birthday;
    }
}
