package ru.job4j.searchfiles.args;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

import static org.hamcrest.core.Is.is;

@Slf4j
public class ArgsTest {
    private final String testzipdirectory = ClassLoader.getSystemResource("testzipdirectory").getPath();

    @Test
    public void checkFileExists() {
        Args args = new Args("-d", testzipdirectory, "-n qeqwe");
        File file = args.directory();
        Assert.assertThat(file.exists(), is(true));

    }

    @Test
    public void checkFileNameInArgs() {
        Args args = new Args("-d", testzipdirectory, "-n *.txt", "-r asdqeqw -o trololo.csv");
        String fileName = args.getFileName();
        Assert.assertThat(fileName, is("*.txt"));

    }

    @Test
    public void checFindWord() {
        Args args = new Args("-d", testzipdirectory, "-n qeqwe", "-f -o");
        String wordFindWay = args.getWordFindWay();
        Assert.assertThat(wordFindWay, is("-f"));
    }

    @Test
    public void checkMax() {
        Args args = new Args("-d", testzipdirectory, "-n qeqwe", "-m -o");
        String wordFindWay = args.getWordFindWay();
        Assert.assertThat(wordFindWay, is("-m"));
    }

    @Test
    public void checkRegInArgs() {
        Args args = new Args("-d", testzipdirectory, "-n qeqwe", "-r -o");
        String wordFindWay = args.getWordFindWay();
        Assert.assertThat(wordFindWay, is("-r"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkException() {
        Args args = new Args("-d", testzipdirectory, "-n qeqwe", "-p asdqeqw -o");
        String wordFindWay = args.getWordFindWay();
    }

    @Test
    public void getFileToWriteName() {
        Args args = new Args("-d", testzipdirectory, "-n qeqwe", "-r -o trololo.csv");
        String writeFileName = args.getWriteFileName();
        Assert.assertThat(writeFileName, is("trololo.csv"));
    }


}