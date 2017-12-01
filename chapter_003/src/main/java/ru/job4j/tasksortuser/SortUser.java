package ru.job4j.tasksortuser;


import java.util.*;

/**
 * SortUser.
 */
public class SortUser {
    /**
     * sort - sort with age.
     * @param userList - received uesrList.
     * @return - TreeSet.
     */
    Set<User> sort(List<User> userList) {
        Set<User> result = new TreeSet<>();
        result.addAll(userList);
        return result;
    }
}
