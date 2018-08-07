package ru.job4j.pools.executorservice;

public class EmailNotification {

    private String subject;

    private String body;


    public void emailTo(User user) {

        String subject = String.format("Notification %s to emal %s", user.getUsername(), user.getEmail());

    }
}
