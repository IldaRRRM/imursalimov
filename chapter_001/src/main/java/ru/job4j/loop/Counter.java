package ru.job4j.loop;

/**
*Public class Counter is including his own method for searching summ of even numbers.
*/

public class Counter {
	/**
	*method add calculated summ of even numbers from "start" to "finish".
	*@return - retrun summ of even numbers.
	*@param start - value which is starting loop.
	*@param finish - value which is ending loop.
	*/
	public int add(int start, int finish) {
		int result = 0;
		for (int i = start; i <= finish; i++) {
			if (i % 2 == 0) {
				result += i;
			}
		}
		return result;
	}
}
