package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
*Class PointTest - it's a class for testing class Point.
*
*/
public class PointTest {
    /**
    *method pointBelongs shows that point(x , y) belongs to y(x) = a * x + b.
    */
    @Test
    public void pointBelongs() {
        Point point = new Point(4, 15);
        boolean result = point.is(3, 3);
        boolean expected = true;
        assertThat(result, is(expected));
    }
     /**
    *method pointNotBelongs shows that point(x, y) not belongs to y(x) = a * x + b.
    */
     @Test
 	public void pointNotBelongs() {
        Point point1 = new Point(10, 4);
        point1.is(14, 15);
        boolean result = point1.is(14, 15);
        boolean expected = false;
        assertThat(result, is(expected));
    }
}