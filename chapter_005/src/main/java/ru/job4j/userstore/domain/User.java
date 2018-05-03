package ru.job4j.userstore.domain;

import net.jcip.annotations.GuardedBy;

public class User {

    private final int id;
    @GuardedBy("this")
    private volatile int amount;

    public User(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }
}
