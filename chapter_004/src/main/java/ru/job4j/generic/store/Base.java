package ru.job4j.generic.store;

public abstract class Base {

    private final String id;

    /**
     * Constructor.
     * @param id - received id.
     */
    protected Base(final String id) {
        this.id = id;
    }

    /**
     * Getter
     * @return - String id.
     */
    public String getId() {
        return id;
    }
}
