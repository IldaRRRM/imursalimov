package ru.job4j.bytestream;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


@Slf4j
public class EvenNumberCheckTest {


    @Test
    public void negativeStreamTest() throws IOException {
        try (ByteArrayInputStream byteArrayInputStream
                     = new ByteArrayInputStream(new byte[]{3, 5, 11})) {
            EvenNumberCheck evenNumberCheck = new EvenNumberCheck();
            evenNumberCheck.isNumber(byteArrayInputStream);
            assertThat(evenNumberCheck.isNumber(byteArrayInputStream), is(false));
        }

    }

    @Test
    public void positiveTest() throws IOException {
        try (ByteArrayInputStream byteArrayInputStream =
                     new ByteArrayInputStream(new byte[]{11, 13, 15, 16})) {
            EvenNumberCheck evenNumberCheck = new EvenNumberCheck();
            assertThat(evenNumberCheck.isNumber(byteArrayInputStream), is(true));
        }
    }

}