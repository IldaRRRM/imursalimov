package ru.job4j.bankcollection;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *
 */
public class TestBankCollection {
   @Test
   public void whenAddNewUserToTheBankCollection() {
       DataOfBank dataOfBank = new DataOfBank();
       User igor = new User("Igor", 2512);
       dataOfBank.addUser(igor);
       Map<User, List<Account>> testUserListMap = new HashMap<>();
       testUserListMap.put(new User("Igor", 2512), null);
       assertThat(dataOfBank.getUserListMap(), is(testUserListMap));
   }
   @Test
   public void addAccountToUserInDataBank() {
       DataOfBank dataOfBank = new DataOfBank();
       User igor = new User("Igor", 2512);
       dataOfBank.addUser(igor);
       dataOfBank.addAccountToUser(igor, new Account(3000, 1234));
       Map<User, List<Account>> testUserListMap = new HashMap<>();
       List<Account> accounts = new ArrayList<>();
       accounts.add(new Account(3000, 1234));
       testUserListMap.put(new User("Igor", 2512), accounts);
       assertThat(dataOfBank.getUserListMap(), is(testUserListMap));
   }
   @Test
    public void deleteAccountFromUserTestMethod() {
       DataOfBank dataOfBank = new DataOfBank();
       User igor = new User("Igor", 2512);
       dataOfBank.addUser(igor);
       dataOfBank.addAccountToUser(igor, new Account(3000, 1));
       dataOfBank.addAccountToUser(igor, new Account(5000, 2));
       dataOfBank.addAccountToUser(igor, new Account(2000, 3));
       dataOfBank.deleteAccountFromUser(igor, new Account(3000, 1));
       Map<User, List<Account>> testUserListMap = new HashMap<>();
       List<Account> accounts = new ArrayList<>();
       accounts.add(new Account(5000, 2));
       accounts.add(new Account(2000, 3));
       testUserListMap.put(new User("Igor", 2512), accounts);
       assertThat(dataOfBank.getUserListMap(), is(testUserListMap));
   }
   @Test
    public void getUserAccountToAnotherListPls() {
       DataOfBank dataOfBank = new DataOfBank();
       User igor = new User("Igor", 2512);
       dataOfBank.addUser(igor);
       dataOfBank.addAccountToUser(igor, new Account(3000, 1));
       dataOfBank.addAccountToUser(igor, new Account(5000, 2));
       Map<User, List<Account>> testUserListMap = new HashMap<>();
       List<Account> accounts = new ArrayList<>();
       accounts.add(new Account(3000, 1));
       accounts.add(new Account(5000, 2));
       assertThat(dataOfBank.getUserAccounts(igor), is(accounts));
       dataOfBank.printValues(dataOfBank.getUserListMap());
   }
   @Test
   public void transferMoneyFromOneUserToAnother() {
       DataOfBank dataOfBank = new DataOfBank();
       //Igor
       User igor = new User("Igor", 2512);
       dataOfBank.addUser(igor);
       Account igorAcc = new Account(7000, 1);
       dataOfBank.addAccountToUser(igor, igorAcc);
       //Boris
       User boris = new User("Boris", 1234);
       dataOfBank.addUser(boris);
       Account borisAccount = new Account(1000, 1);
       dataOfBank.addAccountToUser(boris, borisAccount);
       dataOfBank.transferMoney(igor, igorAcc, boris, borisAccount, 2000);
       //expected map
       Map<User, List<Account>> testUserListMap = new HashMap<>();
       List<Account> igorAccounts = new ArrayList<>();
       List<Account> borisAccounts = new ArrayList<>();
       igorAccounts.add(new Account(5000, 1));
       borisAccounts.add(new Account(3000, 1));
       testUserListMap.put(igor, igorAccounts);
       testUserListMap.put(boris, borisAccounts);
       assertThat(dataOfBank.getUserListMap(), is(testUserListMap));
   }
   @Test
    public void sadStoryWhenMoneyIsLow() {
       DataOfBank dataOfBank = new DataOfBank();
       //Igor
       User igor = new User("Igor", 2512);
       dataOfBank.addUser(igor);
       Account igorAcc = new Account(1000, 1);
       dataOfBank.addAccountToUser(igor, igorAcc);
       //Boris
       User boris = new User("Boris", 1234);
       dataOfBank.addUser(boris);
       Account borisAccount = new Account(4000, 1);
       dataOfBank.addAccountToUser(boris, borisAccount);
       boolean result = dataOfBank.transferMoney(igor, igorAcc, boris, borisAccount, 2000);
       boolean expected = false;
       assertThat(expected, is(result));
   }
   @Test
    public void whenUserIsAbsent() {
       DataOfBank dataOfBank = new DataOfBank();
       //Igor
       User igor = new User("Igor", 2512);
       dataOfBank.addUser(igor);
       Account igorAcc = new Account(1000, 1);
       dataOfBank.addAccountToUser(igor, igorAcc);
       //Boris
       User boris = new User("Boris", 1234);
       dataOfBank.addUser(boris);
       Account borisAccount = new Account(1000, 1);
       dataOfBank.addAccountToUser(boris, borisAccount);
       boolean result = dataOfBank.transferMoney(new User("Test", 3214), igorAcc, boris, borisAccount, 2000);
       boolean expected = false;
       assertThat(expected, is(result));
   }
}
