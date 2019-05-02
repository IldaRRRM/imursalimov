package ru.job4j.archive;

import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    /**
     * Archive files to target
     *
     * @param source src files
     * @param target dir which will be arrive result of archive
     */
    public void pack(List<File> source, String target) {
        try (ZipOutputStream zip = new ZipOutputStream(new FileOutputStream(target))) {
            for (File file : source) {
                zip.putNextEntry(new ZipEntry(file.getPath()));
            }
            try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(source.get(0).getPath()))) {
                zip.write(inputStream.read());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
