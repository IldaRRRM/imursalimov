package ru.job4j.loop;

	/**
	*Class Paint includes method piramid, which bouilds the piramid.
	*/
	public class Paint {
	/**
	*Method piramid drows the piramid.
	*@param h - height of the piramid.
	*@return - return final string.
	*/
	public String piramid(int h) {
		StringBuilder pr = new StringBuilder();
		StringBuilder qk = new StringBuilder("^");
		StringBuilder z = new StringBuilder(" ");
		for (int i = 0; i <= h; i++) {
			if (i > 1) {
				pr.append(System.getProperty("line.separator"));
			} // end if
			if (i >= 1 && h - i != 0) {
				for (int k = 0; k < h - i; k++) {
				pr.append(z);
				} //end of cycle for, which used for making spaces.
			}
			for (int j = 0; (j < (i - 1) + i); j++) {
				pr.append(qk);
			  } // end of for2.
			} // end of for1.
		String result = pr.toString();
		return result;
		} //end of method piramid.
	} //end of Paint.

