package ru.job4j.user;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * userMapTest includes method, which testing class UserConvert.
 */
public class UserMapTest {
    /**
     * method whenComeArrayListAndOutHashMap is testing method process from class UserConvert.
     */
    @Test
    public void whenComeArrayListAndOutHashMap() {
        UserConvert userConvert = new UserConvert();
        ArrayList<User> users = new ArrayList<>();
        User ivan = new User(1, "Ivan", "Moscow");
        User oleg = new User(2, "Oleg", "Kazan");
        User denis = new User(3, "Denis", "Volgograd");
        users.add(ivan);
        users.add(oleg);
        users.add(denis);
        HashMap<Integer, User> result = userConvert.process(users);
        HashMap<Integer, User> expected = new HashMap<>();
        expected.put(1, ivan);
        expected.put(2, oleg);
        expected.put(3, denis);
        assertThat(result, is(expected));
    }
}
