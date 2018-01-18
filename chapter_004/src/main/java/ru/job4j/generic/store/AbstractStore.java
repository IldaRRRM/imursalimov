package ru.job4j.generic.store;

import ru.job4j.generic.SimpleArray;

public abstract class AbstractStore<T extends Base> {

    private SimpleArray<T> simpleArray;

    /**
     * @param simpleArray - received array.
     */
    public AbstractStore(SimpleArray<T> simpleArray) {
        this.simpleArray = simpleArray;
    }

    public SimpleArray<T> getSimpleArray() {
        return simpleArray;
    }

    /**
     * received model, which will be added.
     * @param model - model, which will be added.
     */
    void add(T model) {
        simpleArray.add(model);
    }

    /**
     * @param id    - id.
     * @param model - received model.
     * @return - boolean result.
     */
    boolean replace(String id, T model) {
        boolean result = false;
        for (int i = 0; i < simpleArray.getObjects().length; i++) {
            if (simpleArray.getObjects()[i] != null) {
                String idWhatWeFind = simpleArray.iterable.iterator().next().getId();
                if (idWhatWeFind.equals(id)) {
                    simpleArray.set(i, model);
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * @param id - id.
     * @return - return boolean result.
     */
    boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < simpleArray.getObjects().length; i++) {
            if (simpleArray.getObjects()[i] != null) {
                String idWhatWeFind = simpleArray.iterable.iterator().next().getId();
                if (idWhatWeFind.equals(id)) {
                    simpleArray.delete(i);
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * @param id - id.
     * @return - return
     */
    T findById(String id) {
        T result = null;
        for (int i = 0; i < simpleArray.getObjects().length; i++) {
            if (simpleArray.getObjects()[i] != null) {
                String idWhatWeFind = simpleArray.iterable.iterator().next().getId();
                if (idWhatWeFind.equals(id)) {
                    result = simpleArray.get(i);
                }
            }
        }
        if (result == null) {
            throw new NullPointerException("Role with this id is not found.");
        }
        return result;
    }
}
