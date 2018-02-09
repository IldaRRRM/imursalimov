package ru.job4j.mapcollection;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class MapMethodsInAction {

    User user;

    private Map<User, Object> map;

    /**
     * Put on map 2 equal key type User without override
     * methods: equals and hashcode. Then print map.
     */
    public void dontOverrideEuqalsAndHashCode() {
        map = new HashMap<>();
        User firstUser = new User("Boris", 3, 1984, 12, 12);
        User secondUser = new User("Boris", 3, 1984, 12, 12);
        map.put(firstUser, firstUser);
        map.put(secondUser, secondUser);
        for (Map.Entry<User, Object> entry : map.entrySet()) {
            User key = entry.getKey();
            Object object = entry.getValue();
            System.out.printf("User name is: %s\nUser birthday is: %s\n"
                            + "Amount of children: %s\n",
                    key.getName(), key.getBirthday().getTime(), key.getChildren());
        }
    }

    public static void main(String[] args) {
        new MapMethodsInAction().dontOverrideEuqalsAndHashCode();
    }
}
