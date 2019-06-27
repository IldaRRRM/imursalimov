package ru.job4j.searchfiles.writer;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Slf4j
public class ResultsWriter {
    private final List<File> resultFiles;

    public ResultsWriter(List<File> fileList) {
        this.resultFiles = fileList;
    }

    public void writeToFile(String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (File file : resultFiles) {
                log.info("Взят абсолютный путь {}", file.getAbsolutePath());
                writer.write(file.getAbsolutePath());
                writer.newLine();
                writer.flush();
                log.info("Запись файла закончена");
            }
        }
    }
}
