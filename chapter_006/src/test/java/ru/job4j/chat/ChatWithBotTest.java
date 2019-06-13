package ru.job4j.chat;

import ru.job4j.chat.answerbot.AnswerBot;

import java.io.IOException;

public class ChatWithBotTest {

    public static void main(String[] args) throws IOException {
        AnswerBot bot = new AnswerBot(ClassLoader.getSystemResource("textFile.txt").getPath());
        new ChatWithBot(bot, System.in, System.out).startApp();

    }
}

