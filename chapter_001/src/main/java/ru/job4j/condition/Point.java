package ru.job4j.condition;
/**
*Class Point describes the position of a point.
*/
public class Point {
	/**
	*@param x field of Point.
	*/
	private int x;
	/**
	*param y field of Point.
	*/
	private int y;
	/**
	*Point Constructor.
	*@param x - position on x.
	*@param y - position on y.
	*/
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	/**
	*Getter for x.
	*@return return x.
	*/
	public int getX() {
		return this.x;
	}
	/**
	*Getter for y.
	*@return return y.
	*/
	public int getY() {
		return this.y;
	}
	/**
	*method is shows belongs point with (x,y) for y(x) = a * x + b.
	*@param a - coefficient.
	*@param b - coefficient.
	*@return - return true.
	*/
	public boolean is(int a, int b) {
		if (this.y == a * this.x + b) {
			return true;
		}
	return false;
	}
}