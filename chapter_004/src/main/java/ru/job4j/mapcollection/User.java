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

    /**
     * Override hashCode.
     * @return - overrideHashCode.
     */
    @Override
    public int hashCode() {

        int result = 17;
        for (int i = 0; i < this.name.length(); i++) {
            result = 31 * result + name.charAt(i);
        }
        result = 31 * result + (int) children;
        result = 31 * result + birthday.hashCode();
        return result;
    }

    /**
     * Override equals.
     * @param o - received object.
     * @return - override equals method.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        if (children != user.children) {
            return false;
        }
        if (name != null ? !name.equals(user.name) : user.name != null) {
            return false;
        }
        return birthday != null ? birthday.equals(user.birthday) : user.birthday == null;
    }
}

