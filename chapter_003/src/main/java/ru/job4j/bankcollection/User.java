package ru.job4j.bankcollection;

import java.util.ArrayList;
import java.util.List;

public class User {
    /**
     * Constructor.
     * @param name - name of User.
     * @param passport - passport of user.
     */
    public User(String name, int passport) {
        this.passport = passport;
        this.name = name;
    }

    /**
     * List with userAccounts.
     */
    private List<Account> userAccount = new ArrayList<>();
    /**
     * Name of User.
     */
    private String name;
    /**
     * Unic nubmer of User.
     */
    private int passport;

    public String getName() {
        return name;
    }

    public List<Account> getUserAccount() {
        return userAccount;
    }

    public int getPassport() {
        return passport;
    }

    /**
     *
     * @param o - received object.
     * @return - override equals.
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

        if (passport != user.passport) {
            return false;
        }
        return name.equals(user.name);
    }

    /**
     * Override hashcode.
     * @return - override hashcode.
     */
    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + passport;
        return result;
    }
}
