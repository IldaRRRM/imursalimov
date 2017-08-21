package ru.job4j.array;
/**
*Public class ControlTask includes method contains, which cheks equal words in a string.
*/

	public class ControlTask {
	/**
	*Method contains used for checking equal elemetens in the string.
	*@param origin - The string to check.
	*@param sub - content for checking.
	*@return result of checking.
	*/
	 public boolean contains(String origin, String sub) {
		boolean result = false;
		// Char array of origin.
		char[] or = origin.toCharArray();
		// Char array of sub.
		char[] su = sub.toCharArray();
		// summ of equals letters.
		int sum = 0;
		for (int i = 0; i < su.length - 1; i++) {
			for (int j = 0; j < or.length - 1; j++) {
				if (su[i] == or[j] && su[i + 1] == or[j + 1]) {
					sum += 1;
					break;
				} //end of if.
			} // end of second for.
		} // end of first for.
		if (sum == su.length - 1) {
			result = true;
		} // end of if.
		return result;
	} // end of method contains.
} // end of class ControlTask.