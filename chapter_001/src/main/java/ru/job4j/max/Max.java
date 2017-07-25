package ru.job4j.max;
/**
*Class Max is a class which includes method max, which finds maximum of 2 values.
*/
public class Max {
	/**
	*Method max - method which returns of the greatest value.
	*@param first - first value.
	*@param second - second value.
	*@return return of max value.
	*/
	public int max(int first, int second) {
		return first > second ? first : second;
	}
	/**
	*method max3 - method whisch returns the great value of the the 3.
	*@param third - third value.
	*@param first - first value.
	*@param second - second value.
	*@return - return of max value.
	*/
	public int max3(int first, int second, int third) {
		return max(max(first, second), third);
	}
}