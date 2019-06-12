package ru.job4j.chat;

import lombok.extern.slf4j.Slf4j;
import ru.job4j.chat.answerbot.AnswerBot;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

@Slf4j
public class ChatWithBot {

    private final AnswerBot bot;
    private final InputStream userInputStream;

    public ChatWithBot(AnswerBot bot, InputStream userInputStream) {
        this.bot = bot;
        this.userInputStream = userInputStream;

    }

    public void startApp() throws IOException {
        String currentUserInput;
        boolean botWorking = true;
        try (Scanner userInput = new Scanner(userInputStream)) {
            log.info("Введите своё имя: ");
            String userName = userInput.nextLine();
            log.debug("Пользователь ввёл своё имя - {}", userName);
            log.info("Начинается чат с ботом. Для старта диалога с ботом введите любое предложение");
            do {
                currentUserInput = userInput.nextLine();
                log.info("{} говорит: {}", userName, currentUserInput);
                botWorking = switchBotWorking(currentUserInput, botWorking);
                if (botWorking) {
                    String answerFromBot = bot.getLineFromFile();
                    log.info("Бот отвечает: {}", answerFromBot);
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
}
