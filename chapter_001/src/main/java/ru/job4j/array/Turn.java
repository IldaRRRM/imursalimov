package ru.job4j.array;
/**
*Public class Turn includes method back which will reverse the elements of the array.
*/
public class Turn {
	/**
	*method back, which will reverse the elements of the array.
	*@param array - Received array.
	*@return - return  the reverse array.
	*/
	public int[] back(int[] array) {
		int tmp;
		for (int i = 0; i < array.length / 2; i++) {
			//Send to tmp the "last values" of array.
			tmp = array[array.length - 1 - i];
			//Send to "last values" the "first values" of array.
			array[array.length - 1 - i] = array[i];
			//Send to "first values" the last values of array.
			array[i] = tmp;
		}
		//return the reverse array.
		return array;
	}
}