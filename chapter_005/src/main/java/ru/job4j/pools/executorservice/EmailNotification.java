package ru.job4j.pools.executorservice;

import java.util.concurrent.ExecutorService;

public class EmailNotification implements MailNotify {


    private String subject;

    private String body;

    private String mail;

    @Override
    public void emailTo(User user) {

        subject = String.format("Notification %s to email %s %n", user.getUsername(), user.getEmail());

        body = String.format("Add a new event to %s %n", user.getUsername());

        mail = user.getEmail();


    }

    @Override
    public void send(String subject, String body, String email) {
        System.out.printf("Email to %s %n", email);
        System.out.println(subject);
        System.out.println(body);
    }

    public String getMail() {
        return mail;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }
}
