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
    /**
     *
     * @param userList - received list.
     * @return - sorted list.
     */
    public List<User> sortNameLength(List<User> userList) {
         userList.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                Integer firstNameLength = o1.getName().length();
                Integer secondUserNameLength = o2.getName().length();
                return firstNameLength.compareTo(secondUserNameLength);
            }
        });
         return userList;
    }
    /**
     * method, which is used for sorting by name and age.
     * @param userList - received List.
     * @return - sortedList.
     */
    public List<User> sortByAllFriends(List<User> userList) {
        userList.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                Integer firstComp = o1.getAge();
                Integer nextObj = o2.getAge();
                return firstComp.compareTo(nextObj);
            }
        });

        userList.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        return userList;
    }
}
