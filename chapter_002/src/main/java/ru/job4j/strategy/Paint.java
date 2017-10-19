package ru.job4j.strategy;
/**
*class Paint includes method draw, which used for painting our figures.
*/
public class Paint {
    /**
     * method draw is used for painting our figures.
     * @param shape - recieved shape.
     */

	public void draw(Shape shape) {
        System.out.println(shape.pic());
	}
}