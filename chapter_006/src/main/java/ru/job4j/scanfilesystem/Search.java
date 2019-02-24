package ru.job4j.scanfilesystem;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
@Slf4j
public class Search {

    /**
     * @param parent path to file
     * @param exts   extension
     * @return list with files
     */
    public List<File> files(String parent, List<String> exts) {

        List<File> result = new ArrayList<>();

        File file = new File(parent);

        File[] allFilesInParentDirectory = file.listFiles();


        if (allFilesInParentDirectory != null) {
            for (File currentFile : allFilesInParentDirectory) {
                if (currentFile.isDirectory()) {
                    result.addAll(files(currentFile.getPath(), exts));
                }
                for (String currentExts : exts) {
                    if (currentFile.getName().endsWith(currentExts)) {
                        result.add(currentFile);
                    }
                }

            }
        } else {
            log.warn("Directory {} is empty or doesn't exists", parent);
        }
        return result;
    }
}