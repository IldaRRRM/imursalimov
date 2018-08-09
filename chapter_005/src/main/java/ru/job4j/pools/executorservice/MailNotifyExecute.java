package ru.job4j.pools.executorservice;

import java.util.concurrent.*;

public class MailNotifyExecute extends Thread {

    private final MailNotify emailNotification;

    private volatile boolean isFinsih;

    private final BlockingQueue<User> usersToEmail = new ArrayBlockingQueue<User>(Runtime.getRuntime().availableProcessors());

    private final ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());


    public void addUserToMailNotification(User user) {
        usersToEmail.add(user);
    }

    public MailNotifyExecute(MailNotify mailNotify) {
        this.emailNotification = mailNotify;
        this.start();
    }

    private void emailSend() {
        User user = usersToEmail.poll();
        emailNotification.emailTo(user);
        String subject = emailNotification.getSubject();
        String budy = emailNotification.getBody();
        String mail = emailNotification.getMail();
        emailNotification.send(subject, budy, mail);
    }

    public void setFinsih(boolean finsih) {
        isFinsih = finsih;
    }

    @Override
    public void run() {
        while (true) {
            if (!usersToEmail.isEmpty()) {
                pool.submit(new Runnable() {
                    @Override
                    public void run() {
                        System.out.printf("%s is started %n", Thread.currentThread().getName());
                        emailSend();
                        System.out.printf("%s is finished %n", Thread.currentThread().getName());

                    }
                });
                if (usersToEmail.isEmpty() && isFinsih && pool.isTerminated()) {
                    break;
                }
            }

        }
    }
}
