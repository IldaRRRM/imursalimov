package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * public class TrackerTest includes methods, which used for testing methods from class Tracker.
 */

public class TrackerTest {
    /**
     * public method AddToTheTracker used for testing method add from class Tracker.
     */
    @Test
    public void addToTheTracker() {
        Tracker track = new Tracker();
        Item item = new Item("Test1", "TestDescription", "123L");
        track.add(item);

    }
    /**
     *method testFindByName using for testing method findByName from Tracker class.
     */
    @Test
    public void testFindByName() {
        Tracker tracker = new Tracker();
        Item item = new Item("tes1", "TestDics", "123");
        tracker.add(item);
        assertThat(tracker.findByName("tes1").getName(), is(item.getName()));
    }

    /**
     * method testFindById used for testing method FindById from class Tracker.
     */
    @Test
    public void testFindById() {
        Tracker tracker = new Tracker();
        Item item = new Item("Test1", "TestDesc", "123");
        tracker.add(item);
        assertThat(tracker.findById(item.getId()).getId(), is(item.getId()));
    }

    /**
     * Testing method findAll from class Tracker.
     */
    @Test
    public void testFindAll() {
        Tracker tracker = new Tracker();
        Item item = new Item("asd", "qwe", "123");
        Item item1 = new Item("sad", "sdf", "1234");
        tracker.add(item);
        tracker.add(item1);

    }

    /**
     *Testing method update from class Tracker.
     */
    @Test
    public void testUpDate() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescr", "23");
        tracker.add(item);
        Item item1 = new Item("test2", "testDescr", "24");
        item1.setId(item.getId());
        tracker.update(item1);
        assertThat(tracker.findById(item.getId()).getName(), is("test2"));
    }

    /**
     *Testing method delete from class Tracker.
     */
    @Test
    public void testDelete() {
        Tracker tracker = new Tracker();
        Item item = new Item("test", "testDescr", "24");
        Item item1 = new Item("test1", "testDescr2", "22");
        Item item2 = new Item("test2", "testDescr3", "26");
        Item item3 = new Item("test3", "testDescr3", "27");
        tracker.add(item);
        tracker.add(item1);
        tracker.add(item3);
        tracker.delete(item1.getId());
    }
}
