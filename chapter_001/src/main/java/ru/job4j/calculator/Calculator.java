package ru.job4j.calculator;
/**
*Class Calculator - the elementary calculator with 5 function add(summ), subtract, div and multiply.
*@author Ildar
*@since 13.07.2017.
*/
public class Calculator {
	/**
	*@param result - result.
	*/
	private double result;

	/**
	*method add - the summ of two arguments.
	*@param first - it is a first argument.
	*@param second - it is a second argument.
	*@result - result
	*/

	public void add(double first, double second) {
		this.result = first + second;
	}

	/**
	*method subtract - the subtract of two arguments.
	*@param x1 - it is a first argument.
	*@param x2 - it is a second argument.
	*@result - result.
	*/

	public void subtract(double x1, double x2) {
		this.result = x1 - x2;
	}

	/**
	*method div - the divide of two arguments.
	*@param y1 - it is a first argument.
	*@param y2 - it is a second argument.
	*@result - result.
	*/
	public void div(double y1, double y2) {
		this.result = y1 / y2;
	}

	/**
	*method multiply - the multiply of two arguments.
	*@param q1 - it is a first argument.
	*@param q2 - it is a second argument.
	*@result - result
	*/

	public void multiply(double q1, double q2) {
		this.result = q1 * q2;
	}

	/**
	*method getResult - method which returns a result.
	*@return - result.
	*/
	public double getResult() {
		return this.result;
	}
}
