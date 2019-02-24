package ru.job4j.scanfilesystem;

import java.io.File;
import java.io.IOException;

public class SearchTestMethods {
    /**
     * @param parentFile parentDirectory
     * @param folderName folder name in parent directory
     * @return file
     */
    protected File mkdirInParentDir(File parentFile, String folderName) {
        if (!parentFile.isDirectory()) {
            parentFile.mkdir();
        }
        File folder = new File(parentFile, folderName);
        folder.mkdir();
        return folder;
    }

    /**
     * create file in parentDir
     *
     * @param parentFile parentdir
     * @param fileName   filename
     * @return created file
     */
    File mkFileInDir(File parentFile, String fileName) throws IOException {
        File file = new File(parentFile, fileName);
        if (file.exists()) {
            return file;
        } else {
            file.createNewFile();
            return file;
        }

    }


}
