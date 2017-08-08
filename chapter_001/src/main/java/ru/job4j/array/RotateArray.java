package ru.job4j.array;
/**
*Public class RotateArry includes a method "rotate", which rotates array in 90 deegres.
*/
public class RotateArray {
	/**
	*@param array - received array.
	*@return return the inverted array.
	*/
	public int[][] rotate(int[][] array) {
		int tmp = 1;
 		for (int i = 0; i < array.length / 2; i++) {
 			for (int j = 0; j < array.length - 1 - i; j++) {
 			tmp = array[i][j];
 			array[i][j] = array[array.length - j - 1][i];
 			array[array.length - j - 1][i] = array[array.length - i - 1][array.length - j - 1];
 			array[array.length - i - 1][array.length - j - 1] = array[j][array.length - i - 1];
 			array[j][array.length - i - 1] = tmp;
 			}
 		}
		return array;
	}
}