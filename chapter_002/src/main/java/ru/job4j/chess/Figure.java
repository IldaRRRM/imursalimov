package ru.job4j.chess;
/**
* abstract class Figure.
*/
public abstract class Figure {
	/**
	* position on the board.
	*/
	final Cell position;
	/**
	 * @param position - position of figure.
	 */
	Figure(Cell position) {
		this.position = position;
	}
	/**
	 * method way returns cells, which figures must go.
	 * @param dist - position, which figure should goes.
	 * @return - cells, which figure should goes.
	 * @throws ImpossibleMoveException - impossible move.
	 */
	abstract Cell[] way(Cell source, Cell dist) throws ImpossibleMoveException;
	/**
	 * @param dist - new position of figure.
	 * @return - new figure with new position.
	 */
	abstract Figure clone(Cell dist);

}