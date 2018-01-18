package ru.job4j.generic.store;

import ru.job4j.generic.SimpleArray;

public class RoleStore extends AbstractStore<Role> {
    /**
     *
     * @param simpleArray - received array.
     */
    public RoleStore(SimpleArray<Role> simpleArray) {
        super(simpleArray);
    }

    /**
     *
     * @param id - id.
     * @param model - received model.
     * @return - boolean result.
     */
    @Override
    boolean replace(String id, Role model) {
        return super.replace(id, model);
    }

    /**
     *
     * @param id - id.
     * @return - boolean result.
     */
    @Override
    boolean delete(String id) {
        return super.delete(id);
    }

    /**
     *
     * @param id - id.
     * @return - Role model.
     */
    @Override
    Role findById(String id) {
        return super.findById(id);
    }

    /**
     * Getter.
     * @return simpleArrValue.
     */
    @Override
    public SimpleArray<Role> getSimpleArray() {
        return super.getSimpleArray();
    }
}
