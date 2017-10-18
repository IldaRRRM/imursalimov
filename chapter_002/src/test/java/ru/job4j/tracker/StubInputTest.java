package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * public class StubInput test is used for testing attachment tracker.
 */
public class StubInputTest {
    /**
     *method whenUserAddItemThenTrackerHasNewItemWithSameName shows, that method createItem is working good.
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[] {"0", "item", "desc", "6"});
        StartUi start = new StartUi(input, tracker);
        start.dynamicMenu();
        assertThat(tracker.findAll()[0].getName(), is("item"));
    }

    /**
     * method whenUpdateThenTrackerHasUpdatedValue shows, that method findItemById from class StartUi is working.
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = new Item("test name", "desc", "23");
        tracker.add(item);
        Input input = new StubInput(new String[] {"4", item.getId(), "6"});
        StartUi start = new StartUi(input, tracker);
        start.dynamicMenu();
        assertThat(tracker.findById(item.getId()).getName(), is("test name"));
    }
}
