package ru.job4j.scanfilesystem;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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

    public List<File> getFilesExclude(String parent, List<String> ext) throws IOException {
        List<File> files = new ArrayList<>();
        List<String> pathsToFiles = getPathsToFilesExcludeExt(parent, ext);
        pathsToFiles.forEach(s -> files.add(new File(s)));
        return files;
    }

    List<String> getPathsToFilesExcludeExt(String parent, List<String> ext) throws IOException {
        List<String> pathToFiles = new ArrayList<>();
        Files.walkFileTree(Paths.get(parent), new ExcludeFileVisitor(pathToFiles, ext));
        return pathToFiles;
    }

}