package ru.job4j.abuse;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface DropWords {
    /**
     * @param in    inputStream
     * @param out   outputStream
     * @param words words, which should be delete
     * @throws IOException io exception
     */
    void dropWord(InputStream in, OutputStream out, String[] words) throws IOException;

}
