package ru.job4j.pools.executorservice;

public interface MailNotify {

    void emailTo(User user);

    void send(String subject, String body, String email);

    String getSubject();

    String getBody();

    String getMail();
}
