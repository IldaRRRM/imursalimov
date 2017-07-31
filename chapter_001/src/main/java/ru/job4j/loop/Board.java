package ru.job4j.loop;

/**
*Class Board includes method paint which draws a chese board.
*/
class Board {
	/**
	*Method paint draws the chese board.
	*@param width - width of board.
	*@param height - height of board.
	*@return - return final string.
	*/
	public String paint(int width, int height) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < height; i++) {
			if (i > 0) {
				sb.append(System.getProperty("line.separator"));
			}
			for (int j = 0; j < width; j++) {
				if ((j + i) % 2 == 0) {
					sb.append("x");
				} else {
					sb.append(" ");
				}
			}
		}
		String result = sb.toString();
		return result;
	}
}