package ru.job4j.chess;
/**
*
*/
public abstract class Figure {
	/**
	*
	*/
	final Cell position;
	/**
	 * @param position
	 */
	Figure(Cell position) {
		this.position = position;
	}



	/**
	 *
	 * @param dist
	 * @return
	 * @throws ImpossibleMoveException
	 */
	abstract Cell[] way(Cell dist) throws ImpossibleMoveException;

	abstract boolean wayPossible(Cell position, Cell dist) throws ImpossibleMoveException;

}