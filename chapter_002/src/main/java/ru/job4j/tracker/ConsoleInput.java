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
}