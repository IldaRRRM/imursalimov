package ru.job4j.abuse;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AbuseWordTest {
    private static final String SENTENCE = "This sentence should be without garbage";
    private AbuseWord abuseWord;


    @Before
    public void setUp() {
        abuseWord = new AbuseWord();
    }

    @Test
    public void whenDropFirstAndLastWords() throws IOException {

        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(SENTENCE.getBytes());

             PipedInputStream pipedInputStream = new PipedInputStream();

             PipedOutputStream outputStream = new PipedOutputStream(pipedInputStream)) {

            abuseWord.dropWord(byteArrayInputStream, outputStream, new String[]{"garbage", "This"});

            StringBuilder actualSentence = new StringBuilder();

            while (pipedInputStream.available() > 0) {
                char read = (char) pipedInputStream.read();

                actualSentence.append(read);

            }
            String expectedSentence = "sentence should be without ";
            assertThat(actualSentence.toString(), is(expectedSentence));

        }

    }

    @Test
    public void whenDropWordsInTheMiddleOFTheWord() throws IOException {

        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(SENTENCE.getBytes());

             PipedInputStream pipedInputStream = new PipedInputStream();

             PipedOutputStream outputStream = new PipedOutputStream(pipedInputStream)) {

            abuseWord.dropWord(byteArrayInputStream, outputStream, new String[]{"should", "be"});

            StringBuilder actualSentence = new StringBuilder();
            while (pipedInputStream.available() > 0) {
                char read = (char) pipedInputStream.read();

                actualSentence.append(read);

            }
            String expectedSentence = "This sentence without garbage";
            assertThat(actualSentence.toString(), is(expectedSentence));

        }

    }
}
