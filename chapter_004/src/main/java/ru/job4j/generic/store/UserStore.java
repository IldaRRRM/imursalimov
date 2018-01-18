package ru.job4j.generic.store;

import ru.job4j.generic.SimpleArray;

public class UserStore extends AbstractStore<User> {
    /**
     * @param simpleArray received array.
     */
    public UserStore(SimpleArray<User> simpleArray) {
        super(simpleArray);
    }

    /**
     * @param model - model, which will be added.
     */
    @Override
    void add(User model) {
        super.add(model);
    }

    /**
     * @param id    - id.
     * @param model - received model.
     * @return - boolean result.
     */
    @Override
    boolean replace(String id, User model) {
        return super.replace(id, model);
    }

    /**
     * @param id - id.
     * @return - boolean result.
     */
    @Override
    boolean delete(String id) {
        return super.delete(id);
    }

    /**
     * @param id - id.
     * @return - User.
     */
    @Override
    User findById(String id) {
        return super.findById(id);
    }

    /**
     * getter.
     * @return - simpleArr.
     */
    @Override
    public SimpleArray<User> getSimpleArray() {
        return super.getSimpleArray();
    }
}
