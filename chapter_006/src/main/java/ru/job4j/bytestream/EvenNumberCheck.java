package ru.job4j.bytestream;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

@Slf4j
public class EvenNumberCheck implements StreamCheckNumber {

    /**
     * Check is there even number in stream
     *
     * @param in received inputstream
     * @return boolean result
     * @throws IOException
     */
    @Override
    public boolean isNumber(InputStream in) throws IOException {
        boolean result = false;
        try (DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(in))) {
            while (dataInputStream.available() > 0) {
                int read = dataInputStream.read();
                if (read % 2 == 0) {
                    result = true;
                }
            }
            return result;
        }
    }
}
