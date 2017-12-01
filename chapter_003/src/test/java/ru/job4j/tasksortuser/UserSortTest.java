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
    @Test
    public void inputUserListAndOutputSortedByAgeTreeSet() {
        SortUser sortUser = new SortUser();
        List<User> userList = new ArrayList<>();
        userList.addAll(Arrays.asList(
                new User("Oleg", 21),
                new User("Boris", 40),
                new User("Igor", 18)));
        Set<User> result = sortUser.sort(userList);
        Set<User> expected = new TreeSet<>();
        expected.addAll(Arrays.asList(
                new User("Igor", 18),
                new User("Oleg", 21),
                new User("Boris", 40)));
        assertThat(result, is(expected));
    }
}
