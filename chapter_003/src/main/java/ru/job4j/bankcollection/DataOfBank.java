package ru.job4j.bankcollection;

import java.util.*;

/**
 *DataOfBank is realized Map interface for bank with users and accounts.
 */
public class DataOfBank {

    private Map<User, List<Account>> userListMap = new HashMap<>();
    /**
     * Getter.
     * @return - Map of bank.
     */
    public Map<User, List<Account>> getUserListMap() {
        return userListMap;
    }

    public void addUser(User user) {
        userListMap.put(user, null);
    }
    /**
     * @param user    - user,
     * @param account - received account.
     */
    public void addAccountToUser(User user, Account account) {
        user.getUserAccount().add(account);
        userListMap.replace(user, user.getUserAccount());
    }

    /**
     * @param user    - received user.
     * @param account - received account.
     */
    public void deleteAccountFromUser(User user, Account account) {
        user.getUserAccount().remove(account);
        userListMap.put(user, user.getUserAccount());
    }

    /**
     * @param user - received user.
     * @return - list with user accounts.
     */
    public List<Account> getUserAccounts(User user) {
        return userListMap.get(user);
        /*
        List<Account> result = new ArrayList<>();
        result.addAll(userListMap.get(user));
        return result;
        */
    }

    /**
     * @param srcUser    - srcUser.
     * @param srcAccount - srcAccount.
     * @param dstUser    - user
     * @param dstAccount - user dst
     * @param amount     - amount.
     * @return - boolean result.
     */
    public boolean transferMoney(User srcUser, Account srcAccount, User dstUser, Account dstAccount, double amount) {
        boolean srcAcc = false,
                result = false,
                toAcc = false,
                muchMoney = false;
        int indexOfSrcAcc = -1;
        int dstAccInd = -1;
        double currentValue = 0;
        double increadMoney = 0;
        for (Map.Entry<User, List<Account>> entry : userListMap.entrySet()) {
            User key = entry.getKey();
            List<Account> sign = entry.getValue();
            if (key.equals(srcUser) && sign.contains(srcAccount)) {
                srcAcc = true;
                indexOfSrcAcc = sign.indexOf(srcAccount);
                currentValue = sign.get(indexOfSrcAcc).getValue();
                if (currentValue >= amount) {
                    muchMoney = true;

                }
            }
            if (key.equals(dstUser) && sign.contains(dstAccount)) {
                toAcc = true;
                dstAccInd = sign.indexOf(dstAccount);
                increadMoney = sign.get(dstAccInd).getValue();
            }
        }

        if (srcAcc && toAcc && muchMoney) {
            //Add new srcAccount account properties.
            addAccountToUser(srcUser, new Account(currentValue - amount,
                    srcAccount.getRequisites()));
            deleteAccountFromUser(srcUser, srcAccount);
            //Add new Dist account properties.
            addAccountToUser(dstUser, new Account(increadMoney + amount,
                    dstAccount.getRequisites()));
            deleteAccountFromUser(dstUser, dstAccount);
            result = true;
        } else if (!srcAcc) {
            System.out.println("There is no user with this account.");
        } else if (!muchMoney) {
            System.out.println("insufficient funds in the account.");
        }
        return result;
    }


    public void printValues(Map<User, List<Account>> map) {
        for (Map.Entry<User, List<Account>> pair : map.entrySet()) {
            User value = pair.getKey();
            List<Account> accounts = pair.getValue();
            System.out.printf("The User name is: %s  His passport: %d%n",
                    value.getName(), value.getPassport());
            System.out.printf("The user %s has next accounts: %n", value.getName());
            for (Account account : accounts) {
                System.out.printf("Requisites: %d Value of Money: %.2f%n",
                        account.getRequisites(), account.getValue());
            }
        }
    }
    /**
     * @param o - received object.
     * @return - new equals.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DataOfBank that = (DataOfBank) o;

        return userListMap != null ? userListMap.equals(that.userListMap) : that.userListMap == null;
    }

    /**
     * Override.
     * @return - hashcode.
     */
    @Override
    public int hashCode() {
        return userListMap != null ? userListMap.hashCode() : 0;
    }
}
