
package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        String[] forList = new String[] {"1", "test", "testDescr", "7", "Y"};
        List<String> rangeSteps = Arrays.asList(forList);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(rangeSteps);
        Input input = new StubInput(arrayList);
        StartUi start = new StartUi(input, tracker);
        start.dynamicMenu();
        assertThat(tracker.findAll().get(0).getName(), is("test"));
    }
    /**
     * method whenUpdateThenTrackerHasUpdatedValue shows, that method findItemById from class StartUi is working.
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = new Item("test name", "desc", "23");
        tracker.add(item);
        String[] steps = new String[] {"3", item.getId(), "newName", "new Descr", "7", "Y"};
        ArrayList<String> arrayList = new ArrayList<>();
        List<String> forArrList = Arrays.asList(steps);
        arrayList.addAll(forArrList);
        Input input = new StubInput(arrayList);
        StartUi start = new StartUi(input, tracker);
        start.dynamicMenu();
        assertThat(tracker.findById(item.getId()).getName(), is("newName"));
    }
}
