package ru.job4j.tracker;

import java.util.Scanner;
/**
*Class consoleInput is used for console Input.
*/
public class ConsoleInput implements Input {
	/**
	 * Object scanner is used for read from keyboard.
	 */
	private Scanner scanner = new Scanner(System.in);

	/**
	 * @param question - question for input.
	 * @return - return the answer.
	 */
	public String ask(String question) {
		System.out.print(question);
		return scanner.nextLine();
	}

	/**
	 * Overload method ask.
	 * @param question - question.
	 * @param range - range of our menu.
	 * @return - key for our menu.
	 */
	public int ask(String question, int[] range) {
		int key = Integer.valueOf(this.ask(question));
		boolean exist = false;
		for (int value : range) {
			if (value == key) {
				exist = true;
				break;
			}
		}
		if (exist) {
			return key;
		} else {
			throw new MenuOutException("Out of range");
		}

	}
}