package ru.job4j.abuse;

import lombok.extern.slf4j.Slf4j;

import java.io.*;

@Slf4j
public class AbuseWord implements DropWords {
    @Override
    public void dropWord(InputStream in, OutputStream out, String[] words) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(out))) {


            while (bufferedReader.ready()) {
                String inputSentence = bufferedReader.readLine();

                for (String word : words) {
                    if (inputSentence.contains(word)) {
                        String sentenceBeforeReplace = inputSentence;
                        inputSentence = inputSentence.replaceAll(word + " ", "");
                        if (sentenceBeforeReplace.equals(inputSentence)) {
                            inputSentence = inputSentence.replaceAll(word, "");
                        }
                    }
                }
                bufferedWriter.write(inputSentence);
                bufferedWriter.flush();
            }
        }
    }
}

