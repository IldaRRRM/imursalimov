package ru.job4j.set.setonarray;

import ru.job4j.list.arrlist.SimpleArrList;

public class SimpleSet<E> extends SimpleArrList<E> {

    /**
     * add method.
     * @param model - received model.
     */
    @Override
    public void add(E model) {
        boolean possible = true;
        for (Object item : getContainer()) {
            if (model.equals(item)) {
                possible = false;
                break;
            }
        }
        if (possible) {
            super.add(model);
        }
    }
}
