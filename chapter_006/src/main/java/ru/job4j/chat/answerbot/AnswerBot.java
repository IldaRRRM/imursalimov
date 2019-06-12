package ru.job4j.chat.answerbot;

import lombok.extern.slf4j.Slf4j;
import ru.job4j.chat.interfaces.ReadLineFromFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class AnswerBot implements ReadLineFromFile {

    private final String pathToFile;

    public AnswerBot(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    /**
     * Получить "псевдо -  случайное" предложение из файла.
     */
    @Override
    public String getLineFromFile() throws IOException {
        Map<Integer, String> sentencesFromFile = getSentencesFromFile();
        int bound = sentencesFromFile.keySet().size();
        return sentencesFromFile.get(new Random().nextInt(bound));
    }

    /**
     * Получить все предложения из файла.
     *
     * @return мапа, где ключ - порядковый номер предложения.
     */
    private Map<Integer, String> getSentencesFromFile() throws IOException {
        Map<Integer, String> sentenceFromFile = new HashMap<>();
        Integer countMatch = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(pathToFile))) {
            while (reader.ready()) {
                String inputString = reader.readLine();
                Pattern pattern = Pattern.compile("\\w+[^?!.]*[?.!]", Pattern.MULTILINE);
                Matcher matcher = pattern.matcher(inputString);
                while (matcher.find()) {
                    String foundedSentence = matcher.group();
                    sentenceFromFile.put(countMatch, foundedSentence);
                    countMatch++;
                }
            }
        }
        return sentenceFromFile;
    }
}