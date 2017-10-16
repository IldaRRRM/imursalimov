package ru.job4j.tracker;

/**
 * interface Input - is used for input.
 */
	public  interface Input {
	/**
	 * @param question - question about application.
	 * @return - return answer.
	 */
		String ask(String question);
	}