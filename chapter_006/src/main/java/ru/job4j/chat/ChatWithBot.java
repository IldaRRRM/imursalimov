package ru.job4j.chat;

import lombok.extern.slf4j.Slf4j;
import ru.job4j.chat.answerbot.AnswerBot;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

@Slf4j
public class ChatWithBot {

    private final AnswerBot bot;
    private final InputStream userInputStream;
    private final OutputStream outputStream;

    public ChatWithBot(AnswerBot bot, InputStream userInputStream, OutputStream outputStream) {
        this.bot = bot;
        this.userInputStream = userInputStream;
        this.outputStream = outputStream;
    }

    public void startApp() throws IOException {
        String currentUserInput;
        boolean botWorking = true;
        try (Scanner userInput = new Scanner(userInputStream);
             PrintWriter writer = new PrintWriter(outputStream)) {
            writeToOutStream(writer, "Введите своё имя: ");
            String userName = userInput.nextLine();
            writeToOutStream(writer, "Пользователь ввёл своё имя - " + userName);
            writeToOutStream(writer, "Начинается чат с ботом. Для старта диалога с ботом введите любое предложение");
            do {
                currentUserInput = userInput.nextLine();
                writeToOutStream(writer, userName + " говорит: " + currentUserInput);
                botWorking = switchBotWorking(currentUserInput, botWorking);
                if (botWorking) {
                    String answerFromBot = bot.getLineFromFile();
                    writeToOutStream(writer, "Бот отвечает: " + answerFromBot);
                }
            } while (!currentUserInput.toUpperCase().trim().equals("ЗАКОНЧИТЬ"));
        }
    }

    /**
     * Проверить входящее слово на флаг - прекращение или продолжение работы бота
     *
     * @param userWord    слово, введенное пользователем
     * @param currentFlag текущее значение флага.
     * @return измененное или не измененное значение флага.
     */
    private boolean switchBotWorking(String userWord, boolean currentFlag) {
        log.debug("Проверка входящего слова {} на отключение бота", userWord);
        switch (userWord.toUpperCase().trim()) {
            case "СТОП":
                currentFlag = false;
                break;
            case "ПРОДОЛЖИТЬ":
                currentFlag = true;
                break;
            default:
                break;
        }
        return currentFlag;
    }

    private void writeToOutStream(PrintWriter writer, String sentence) {
        writer.println(sentence);
        writer.flush();
        log.debug(sentence);
    }
}
