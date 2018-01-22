package ru.job4j.generic.store;

import ru.job4j.generic.SimpleArray;

public class UserStore extends AbstractStore<User> {
    /**
     * @param simpleArray received array.
     */
    public UserStore(SimpleArray<User> simpleArray) {
        super(simpleArray);
    }

}
