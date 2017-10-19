package ru.job4j.strategy;

import org.junit.Test;

/**
*class StrategyTest is used for testing methods pic from class Triangle and Square.
*/
public class StrategyTest {
	/**
	*method trianglePaintTest tests method pic from class Triangle.
	*/
	@Test
	public void trianglePaintTest() {
	    Paint paint = new Paint();
	    paint.draw(new Triangle());
	}
    /**
     *method squareTest tests method pic from class Square.
     */
	@Test
    public void squareTest() {
	    Paint paint = new Paint();
	    paint.draw(new Square());
    }
}