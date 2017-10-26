package ru.job4j.tracker;

/**
 * BaseAction.
 */
public abstract class BaseAction implements UserAction {
    /**
     * name of menu Item.
     */
    private String name;
    /**
     * key for working with menu.
     */
    private int key;
    /**
     * BaseAction.
     * @param name - name of menuItem.
     * @param key - number of Menu.
     */
    public BaseAction(String name, int key) {
        this.name = name;
        this.key = key;
    }

    /**
     * info for our menu.
     * @return - name of menu item.
     */
    public String info() {
        return String.format("%s %s", this.key, this.name);
    }
}
