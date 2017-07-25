package ru.job4j.condition;
/**
*Class Triangle is class for finding area of triangle with 3 Points.
*/
public class Triangle {
	/**
	*Private field a of Triangle.
	*/
	private Point a;
	/**
	*Private field b of Triangle.
	*/
	private Point b;
	/**
	*Private field c of Triangle.
	*/
	private Point c;
	/**
	*Constructor of Triangle.
	*@param a - x and y of a.
	*@param b - x and y of b.
	*@param c - x and y of c.
	*/
	public Triangle(Point a, Point b, Point c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	/**
	*@return - return value of triangle area.
	*/
	public double area() {
		double result = Math.abs(0.5 * ((a.getX() - c.getX()) * (b.getY() - c.getY()) - (b.getX() -  c.getX()) * (a.getY() - c.getY())));
		return result;
	}
	/**
	*method possible shows that can we build a triangle through these points.
	*@return - return boolean result, flase or true (can we or not).
	*/
	public boolean possible() {
		if ((a.getX() == b.getX() && a.getY() == b.getY()) || (a.getX() == c.getX() && a.getY() == c.getY())) {
		return false;
		} else if (b.getX() == c.getX() && b.getY() == c.getY()) {
		return false;
		}
		return true;
	}
}