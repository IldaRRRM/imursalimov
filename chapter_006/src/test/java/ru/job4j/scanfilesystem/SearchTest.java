package ru.job4j.scanfilesystem;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SearchTest extends SearchTestMethods {
    private Search search;

    private static final String PATH_TO_FOLDER = System.getProperty("java.io.tmpdir").concat("/firstDir");
    private File parentDir;
    private List<String> exts;

    @BeforeClass
    public void setup() throws IOException {
        parentDir = mkdirInParentDir(new File(PATH_TO_FOLDER), "firstDir");
        mkFileInDir(parentDir, "firstFile.txt");
        mkFileInDir(parentDir, "garbage.csv");
        File secondFolder = mkdirInParentDir(parentDir, "secondFolder");
        mkFileInDir(secondFolder, "secondFile.txt");
        mkFileInDir(secondFolder, "dotfile.dot");
        mkFileInDir(secondFolder, "secondCsvFile.dot");
        File thirdir = mkdirInParentDir(secondFolder, "thirdir");
        mkFileInDir(thirdir, "thirdfile.txt");
        mkFileInDir(thirdir, "second.csv");
        search = new Search();
    }


    @Test
    public void files() {
        exts = new ArrayList<>();
        exts.add(".txt");
        List<File> files = search.files(PATH_TO_FOLDER, exts);
        assertThat(files.size(), is(3));
        files.forEach(file -> assertThat(file.getName().endsWith(".txt"), is(true)));
    }

    @Test
    public void excludePathToFilesMethodTest() throws IOException {
        exts = new ArrayList<>();
        exts.add(".txt");
        List<String> pathsToFilesExcludeExt = search.getPathsToFilesExcludeExt(PATH_TO_FOLDER, exts);
        pathsToFilesExcludeExt.forEach(path -> assertThat(path.endsWith(".txt"), is(false)));

    }

    @Test
    public void excludeFilesMethodTests() throws IOException {
        exts = new ArrayList<>();
        exts.add("*.dot");
        exts.add(".csv");
        List<File> filesExclude = search.getFilesExclude(PATH_TO_FOLDER, exts);
        filesExclude.forEach(file -> assertThat(file.getName().endsWith(".txt"), is(true)));
        assertThat(filesExclude.size(), is(3));
    }

    @AfterClass
    public void deleteFile() {
        parentDir.delete();
    }
}