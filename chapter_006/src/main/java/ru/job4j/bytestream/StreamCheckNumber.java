package ru.job4j.bytestream;

import java.io.IOException;
import java.io.InputStream;

public interface StreamCheckNumber {
    /**
     * Is there write number in inputstream.
     *
     * @param in received inputstream
     * @return boolean result
     * @throws IOException
     */
    boolean isNumber(InputStream in) throws IOException;


}
