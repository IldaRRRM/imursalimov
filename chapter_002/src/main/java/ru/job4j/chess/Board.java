package ru.job4j.chess;
/**
 *
 */
public class Board {
    /**
     * Figures array.
     */
   static Figure[] figures = new Figure[32];
    /**
     * index.
     */
    private int index = 0;
    /**
     * method addFigure to figures array.
     * @param figure
     */
    public void addFigure(Figure figure) {
        figures[index++] = figure;
    }
    /**
     * fill chessBoard with unic numbers : 11, 21 , 31 ....
     * @param board - board, which we'll fill.
     * @return - chessBoard with numbers.
     */
    public static int[][] fillBoard(int[][] board) {
        int iter = 11;
        for (int i = board.length - 1; i >= 0; i--) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = i + iter;
                iter += 10;
                if (j == board.length - 1) {
                    iter = 11;
                }
            }
        }
        return board;
    }
}


