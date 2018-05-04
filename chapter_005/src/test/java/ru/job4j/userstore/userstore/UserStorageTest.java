package ru.job4j.userstore.userstore;

import org.junit.Test;
import ru.job4j.userstore.domain.User;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserStorageTest {

    @Test
    public void whenAddNewUsersToUserStoreAndFindThemByFindByIdMethod()  {
        UserStorage userStorage = new UserStorage();
        userStorage.add(new User(1, 100));
        assertThat(userStorage.findUserById(1), is(new User(1, 100)));

    }

    @Test
    public void whenAddUserToUserStorageThenDeleteUserFromUserStorage() {
        UserStorage userStorage = new UserStorage();
        userStorage.add(new User(1, 100));
        assertThat(userStorage.delete(new User(1, 100)), is(true));

    }

    @Test
    public void whenAddUserToStorageThenUpdateAmountOfUser() {
        UserStorage userStorage = new UserStorage();
        userStorage.add(new User(1, 100));
        userStorage.update(new User(1, 50));
        assertThat(userStorage.findUserById(1).getAmount(), is(50));

    }

    @Test
    public void whenAddUserToStorageThenTryToUpdateNonExistUser() {
        UserStorage userStorage = new UserStorage();
        assertThat(userStorage.update(new User(4, 50)), is(false));

    }

    @Test
    public void whenAddTwoUsersToUsersStorageAndTransferMoneyFromFirstUserToSecond() {
        UserStorage userStorage = new UserStorage();
        userStorage.add(new User(1, 100));
        userStorage.add(new User(2, 150));
        userStorage.transfer(1, 2, 100);
        assertThat(userStorage.findUserById(2).getAmount(), is(250));
        assertThat(userStorage.findUserById(1).getAmount(), is(0));
        assertThat(userStorage.transfer(1, 2, 300), is(false));

    }

    @Test
    public void whenTryToAddAnEmptyUser() {
        UserStorage userStorage = new UserStorage();
        assertThat(userStorage.add(null), is(false));

    }
}