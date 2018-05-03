package ru.job4j.userstore.userstore;

import org.junit.Test;
import ru.job4j.userstore.domain.User;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserStorageTest {
    @Test
    public void whenUserTransferMoneyToAnotherUserAndAmountOfMoneyIsEnoughToTransfer() throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            //first Storage.
            User firstUser = new User(1, 100);
            User secondUser = new User(2, 50);
            User lastUser = new User(3, 0);

            UserStorage firstUserStorage = new UserStorage(1, 2, 70);
            firstUserStorage.add(firstUser);
            Thread firstOperation = new Thread(firstUserStorage);
            //second storage.
            UserStorage secondUserStorage = new UserStorage(2, 1, 60);
            secondUserStorage.add(secondUser);
            Thread secondAction = new Thread(secondUserStorage);
            //thirdStorage
            UserStorage thirdUserStorage = new UserStorage(1, 3, 50);
            thirdUserStorage.add(lastUser);
            Thread thirdAction = new Thread(thirdUserStorage);


            //
            firstOperation.run(); // transfer firstUser(100 - 70 = 30)  SecondUser(50 + 70  = 120)
            secondAction.run();   // transfer SecondUser(120 - 60 = 60)  FirstUser(30 + 60  = 90)
            thirdAction.run();    // transfer firstUser(90 - 50 = 40)    Third User(0 + 50 = 50)
            //
            firstOperation.join();
            secondAction.join();
            thirdAction.join();
            //
            assertThat(firstUserStorage.findUserById(1).getAmount(), is(40));
            assertThat(firstUserStorage.findUserById(2).getAmount(), is(60));
            assertThat(firstUserStorage.findUserById(3).getAmount(), is(50));
        }
    }

}