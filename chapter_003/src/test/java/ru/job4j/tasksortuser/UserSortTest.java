package ru.job4j.tasksortuser;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * UserSortTest.
 */
public class UserSortTest {
    /**
     * input List ---> output TreeSet.
     */
    //@Test
    public void inputUserListAndOutputSortedByAgeTreeSetResultFuuck() {
        SortUser sortUser = new SortUser();
        List<User> userList = new ArrayList<>();
        userList.add(new User("Boris", 51));
        userList.add(new User("Oleg", 30));
        userList.add(new User("Igor", 51));
        Set<User> result = sortUser.sort(userList);
        Set<User> expected = new TreeSet<>();
        expected.add(new User("Oleg", 30));
        expected.add(new User("Boris", 51));
        expected.add(new User("Igor", 51));
        assertThat(result, is(expected));
    }
    /**
     *
     */
    @Test
    public void whenWeWantSortReceivedListByNameAndAge() {
        SortUser sortUser = new SortUser();
        List<User> userList = new ArrayList<>();
        userList.addAll(Arrays.asList(
                new User("Сергей", 25),
                new User("Иван", 30),
                new User("Сергей", 20),
                new User("Иван", 25)));
        ArrayList<User> result = new ArrayList<>();
        result.addAll(sortUser.sortByAllFriends(userList));
        List<User> expected = new ArrayList<>();
        expected.addAll(Arrays.asList(
                new User("Иван", 25),
                new User("Иван", 30),
                new User("Сергей", 20),
                new User("Сергей", 25)));
        assertThat(result, is(expected));
    }
    /**
     * sort by nameLength.
     */
    @Test
    public void whenWeWantSortByNameLengthOurReceivedList() {
        SortUser sortUser = new SortUser();
        List<User> userList = new ArrayList<>();
        userList.addAll(Arrays.asList(
                new User("Сергей", 25),
                new User("whatDoesTheFoxSay", 30),
                new User("ThunderHorse", 20),
                new User("Murmainder", 25)));
        ArrayList<User> result = new ArrayList<>();
        result.addAll(sortUser.sortNameLength(userList));
        List<User> expected = new ArrayList<>();
        expected.addAll(Arrays.asList(
                new User("Сергей", 25),
                new User("Murmainder", 25),
                new User("ThunderHorse", 20),
                new User("whatDoesTheFoxSay", 30)));
        assertThat(result, is(expected));
    }
}
