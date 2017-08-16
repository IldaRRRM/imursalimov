package ru.job4j.array;

import java.util.Arrays;
/**
*public class ArrayDuplicate includes method remove, which removes the equals elements.
*/
public class ArrayDuplicate {
	/**
	*public method "remove" removes equals elements in a string array.
	*@return - return removed array.
	*@param array - received array.
	*/
	public String[] remove(String[] array) {
			String tmp = "";
			int summ = 0;
			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array.length - summ; j++) {
					if (array[i].equals(array[j]) && j > i) {
						//Counter, which to reduce the array.
						summ += 1;
						// rotate the first elemets with last in the array.
						tmp = array[j];
						array[j] = array[array.length - summ];
						array[array.length - summ] = tmp;
					} //end of if.
				} //end of second cycle for.
			} //end of first cycle for.
		return Arrays.copyOf(array, array.length - summ);
		} //end of method "remove".
	} // end of class ArrayDuplicate.