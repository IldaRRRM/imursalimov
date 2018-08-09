package ru.job4j.pools.executorservice;

import org.junit.Test;


public class MailNotifyExecuteTest {

    @Test
    public void whenAddTwoUsersToPickSomeEmails() {
        MailNotifyExecute mailNotifyExecute = new MailNotifyExecute(new EmailNotification());
        mailNotifyExecute.addUserToMailNotification(new User("test1", "blablab@mail.ru"));
        mailNotifyExecute.addUserToMailNotification(new User("test2", "another@mail.ru"));
        mailNotifyExecute.addUserToMailNotification(new User("test3", "differntOne@mail.ru"));
        mailNotifyExecute.setFinsih(true);
    }

}