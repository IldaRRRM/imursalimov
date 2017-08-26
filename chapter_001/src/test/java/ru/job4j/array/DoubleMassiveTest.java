package ru.job4j.array;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Created by ildar on 27.08.17.
 * public class DoubleMassiveTest using for testing method "association" form class DoubleMassive.
 */
public class DoubleMassiveTest {
    /**
     *Public method associationTest used for testing method association from class DoubleMassive.
     */
    @Test
    public void associationTest() {
        DoubleMassive sb = new DoubleMassive();
        int[] firstAr = {1, 2, 5, 6, 8};
        int[] secondAr = {3, 7, 9, 10};
        int[] expectAr = {1, 2, 3, 5, 6, 7, 8, 9, 10};
        int[] resultArray = sb.association(firstAr, secondAr);
        assertThat(resultArray, is(expectAr));
    }
}
