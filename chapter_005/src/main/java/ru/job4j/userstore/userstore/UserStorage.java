package ru.job4j.userstore.userstore;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import ru.job4j.userstore.domain.User;

import java.util.HashMap;
import java.util.Map;

@ThreadSafe
public class UserStorage implements Runnable {
    @GuardedBy("this")
    private final Integer fromId;

    private final Integer toId;

    private final Integer amount;

    public UserStorage(Integer fromId, Integer toId, Integer amount) {
        this.fromId = fromId;
        this.toId = toId;
        this.amount = amount;
    }

    public boolean add(User user) {
        if (user != null) {
            BaseOfUsers.baseOfUsers.put(user.getId(), user);
            return true;
        }
        return false;
    }

    public boolean update(User user) {
        return BaseOfUsers.baseOfUsers.replace(user.getId(),
                BaseOfUsers.baseOfUsers.get(user.getId()), user);
    }

    public boolean delete(User user) {
        return BaseOfUsers.baseOfUsers.remove(user.getId(), user);
    }

    public synchronized boolean transfer(final int fromId, final int toId, final int amount) {
        if (isTransferPossible(fromId, toId, amount)) {
            int amountOfSenderUser = BaseOfUsers.baseOfUsers.get(fromId).getAmount() - amount;
            int receivedUserAmount = BaseOfUsers.baseOfUsers.get(toId).getAmount() + amount;
            update(new User(fromId, amountOfSenderUser));
            update(new User(toId, receivedUserAmount));
            return true;
        }
        return false;
    }


    private boolean isTransferPossible(int fromId, int toId, int amount) {
        return BaseOfUsers.baseOfUsers.get(fromId) != null
                && BaseOfUsers.baseOfUsers.get(toId) != null
                && BaseOfUsers.baseOfUsers.get(fromId).getAmount() >= amount;
    }

    public User findUserById(int id) {
        return BaseOfUsers.baseOfUsers.get(id);
    }

    @Override
    public void run() {
        transfer(this.fromId, this.toId, this.amount);
    }
}
