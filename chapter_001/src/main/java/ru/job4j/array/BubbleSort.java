package ru.job4j.array;
/**
*public class BubbleSort includes method sort which enables to sort array.
*/
public class BubbleSort {
	/**
	*public method back sorts the received array.
	*@param array - received array.
	*@return return sorted array.
	*/
	public int[] back(int[] array) {
		int tmp;
		for (int i = 0; i <= array.length - 1; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j] > array[j + 1]) {
					tmp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = tmp;
				}
			}
		}
	return array;
	}
}