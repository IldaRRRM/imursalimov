package ru.job4j.chat.answerbot;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.Matchers.is;

public class AnswerBotTest {
    @Test
    public void getLineFromFile() throws IOException {
        String pathToFile = ClassLoader.getSystemResource("textFile.txt").getPath();
        AnswerBot bot = new AnswerBot(pathToFile);
        Assert.assertThat(bot.getLineFromFile().isEmpty(), is(false));
    }
}