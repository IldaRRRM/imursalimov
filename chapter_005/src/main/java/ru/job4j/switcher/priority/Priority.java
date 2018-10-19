package ru.job4j.switcher.priority;

public enum Priority {

    FIRST(1),
    SECOND(2),
    THIRD(3),
    FOURTH(4),
    FITH(5);

    int value;

    Priority(int val) {
        this.value = val;
    }

    public int getValue() {
        return value;
    }


}