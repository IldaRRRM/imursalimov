package ru.job4j.userstore.userstore;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import ru.job4j.userstore.domain.User;

import java.util.HashMap;
import java.util.Map;

@ThreadSafe
public class UserStorage {
    @GuardedBy("this")
    private volatile Map<Integer, User> baseOfUsers;

    public UserStorage() {
        this.baseOfUsers = new HashMap<>();
    }

    public synchronized boolean add(User user) {
        if (user != null) {
            baseOfUsers.put(user.getId(), user);
            return true;
        }
        return false;
    }

    public synchronized boolean update(User user) {
        return baseOfUsers.replace(user.getId(),
                baseOfUsers.get(user.getId()), user);
    }

    public synchronized boolean delete(User user) {
        return baseOfUsers.remove(user.getId(), user);
    }

    public synchronized boolean transfer(final int fromId, final int toId, final int amount) {
        if (isTransferPossible(fromId, toId, amount)) {
            int amountOfSenderUser = baseOfUsers.get(fromId).getAmount() - amount;
            int receivedUserAmount = baseOfUsers.get(toId).getAmount() + amount;
            update(new User(fromId, amountOfSenderUser));
            update(new User(toId, receivedUserAmount));
            return true;
        }
        return false;
    }

    private synchronized boolean isTransferPossible(int fromId, int toId, int amount) {
        return baseOfUsers.get(fromId) != null
                && baseOfUsers.get(toId) != null
                && baseOfUsers.get(fromId).getAmount() >= amount;
    }

    public synchronized User findUserById(int id) {
        return baseOfUsers.get(id);
    }

}
