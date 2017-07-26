package ru.job4j.loop;

/**
*Class Factorial includes method calc which calculates factorial of n.
*/
public class Factorial {
	/**
	*method calc calculates factorial of n.
	*@param n - incoming value.
	*@return fact - return factorial of n.
	*/
	public int calc(int n) {
		int fact = 1;
		for (int i = 1; i <= n; n--) {
			fact *= n;
		}
		return fact;
	}
}