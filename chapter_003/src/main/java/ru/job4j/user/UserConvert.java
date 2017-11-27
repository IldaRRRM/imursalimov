package ru.job4j.user;


import java.util.*;

/**
 * Class UserConvert includes method porcess, which received List whith users and out HashMap.
 */
public class UserConvert {
    /**
     *
     * @param list - received list.
     * @return - HashMap with
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> result = new HashMap<>();
        for (User user : list) {
            result.put(user.getId(), user);
        }
        return result;
    }
}
