/**
 * Board.java
 *
 * This class represents the game board for the Tic Tac Toe game.
 * It provides methods for initializing the board, printing its current state,
 * validating and making moves, checking for a winning condition, and
 * verifying if the board is full.
 *
 * The Board class encapsulates all logic and data related to the game board.
 */

package tic_tac_toe;

public class Board {
    private char[][] board; // Represents the 3x3 grid for the game board

    /**
     * Constructor - initializes the game board as a 3x3 grid with default values.
     */
    public Board() {
        board = new char[3][3];
        initializeBoard();
    }

    /**
     * Initializes the game board by setting all cells to the default character '-'.
     */
    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-'; // Empty cell represented by '-'
            }
        }
    }

    /**
     * Prints the current state of the game board to the console.
     * Each row of the board is printed on a new line for readability.
     */
    public void printBoard() {
        System.out.println("Current board state:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Checks if a given move is valid by ensuring the specified row and column
     * are within bounds and that the cell is empty.
     *
     * @param row The row index of the move.
     * @param col The column index of the move.
     * @return true if the move is valid; false otherwise.
     */
    public boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-';
    }

    /**
     * Makes a move on the board by placing the specified player's character
     * in the specified row and column.
     *
     * @param row    The row index for the move.
     * @param col    The column index for the move.
     * @param player The character representing the player ('X' or 'O').
     */
    public void makeMove(int row, int col, char player) {
        board[row][col] = player;
    }

    /**
     * Reverts a move by clearing the specified cell, setting it back to the default '-'.
     *
     * @param row The row index of the move to undo.
     * @param col The column index of the move to undo.
     */
    public void undoMove(int row, int col) {
        board[row][col] = '-';
    }

    /**
     * Checks if the specified player has won the game by completing a row, column, or diagonal.
     *
     * @param player The character representing the player to check ('X' or 'O').
     * @return true if the player has a winning combination; false otherwise.
     */
    public boolean isWinner(char player) {
        // Check rows and columns for a win
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                    (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }
        // Check diagonals for a win
        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }

    /**
     * Checks if the game board is completely filled, which would result in a tie
     * if there is no winner.
     *
     * @return true if all cells are occupied; false otherwise.
     */
    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false; // At least one cell is empty
                }
            }
        }
        return true; // All cells are filled
    }
}