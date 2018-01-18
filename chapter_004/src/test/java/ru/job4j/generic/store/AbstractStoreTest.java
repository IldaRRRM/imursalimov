package ru.job4j.generic.store;

import org.junit.Test;
import ru.job4j.generic.SimpleArray;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AbstractStoreTest {
    @Test
    public void weAreTestingMethodAddForTwoModelsUserAndRole() {
        // Role.
        RoleStore roleStore = new RoleStore(new SimpleArray<>(5));
        roleStore.add(new Role("FirstTestId"));
        assertThat(roleStore.getSimpleArray().get(0).getId(), is("FirstTestId"));
        //User.
        UserStore userStore = new UserStore(new SimpleArray<>(5));
        userStore.add(new User("UserTest"));
        assertThat(userStore.getSimpleArray().get(0).getId(), is("UserTest"));

    }

    @Test
    public void replaceOneModelFromOneIndexToAnotherModelWithSameIndex() {
        // Role.
        RoleStore roleStore = new RoleStore(new SimpleArray<>(5));
        roleStore.add(new Role("FirstTestId"));
        Role paramToTest = new Role("another Id");
        roleStore.replace("FirstTestId", paramToTest);
        assertThat(roleStore.getSimpleArray().get(0).getId(), is("another Id"));
        // User.
        UserStore userStore = new UserStore(new SimpleArray<>(5));
        userStore.add(new User("TestId"));
        User paramToTes = new User("Id");
        userStore.replace("TestId", paramToTes);
        assertThat(userStore.getSimpleArray().get(0).getId(), is("Id"));
    }

    @Test
    public void deleteElementFromArraysAndShiftElementsToLeft() {
        // Role.
        RoleStore roleStore = new RoleStore(new SimpleArray<>(5));
        roleStore.add(new Role("First"));
        roleStore.add(new Role("Second"));
        roleStore.delete("First");
        assertThat(roleStore.getSimpleArray().get(0).getId(), is("Second"));
        // User.
        UserStore userStore = new UserStore(new SimpleArray<>(5));
        userStore.add(new User("UserTest"));
        userStore.add(new User("Abba"));
        userStore.delete("UserTest");
        assertThat(userStore.getSimpleArray().get(0).getId(), is("Abba"));
    }

    @Test
    public void findByIdAndWeAreVeryHappyWhenEverthIsOk() {
        // Role.
        RoleStore roleStore = new RoleStore(new SimpleArray<>(5));
        roleStore.add(new Role("First"));
        roleStore.add(new Role("Second"));
        Role role = roleStore.findById("First");
        assertThat(role.getId(), is("First"));
        // User.
        UserStore userStore = new UserStore(new SimpleArray<>(5));
        userStore.add(new User("UserTest"));
        userStore.add(new User("Abba"));
        User user = userStore.findById("Abba");
        assertThat(user.getId(), is("Abba"));
    }

}