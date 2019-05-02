package ru.job4j.archive;

import org.junit.Test;
import ru.job4j.scanfilesystem.Search;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ZipTest {
    private final String pathToFile = ClassLoader.getSystemResource("testzipdirectory").getPath();

    @Test
    public void zipTest() throws IOException {
        Zip zip = new Zip();
        List<String> ext = new ArrayList<>();
        List<File> filesExclude = new Search().getFilesExclude(pathToFile, ext);
        String zipTarget = pathToFile.concat(".zip");
        zip.pack(filesExclude, zipTarget);
    }

}