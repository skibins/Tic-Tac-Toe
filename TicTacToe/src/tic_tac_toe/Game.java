/**
 * Game.java
 *
 * This class contains the main game logic for Tic Tac Toe, including player and computer moves,
 * the game loop, and victory conditions. It interacts with the Board class to update and display
 * the game board and determine valid moves and winners.
 *
 * The Game class manages the flow of the game by alternating between player and computer turns
 * and implementing a strategy to ensure the computer does not lose.
 */

package tic_tac_toe;

import java.util.Scanner;

public class Game {
    private Board board;       // Represents the game board instance
    private char currentPlayer; // Indicates the current player ('X' for human, 'O' for computer)

    /**
     * Constructor - initializes a new game, creating a Board instance and setting the
     * initial player to 'X' (human).
     */
    public Game() {
        board = new Board();
        currentPlayer = 'X'; // X represents the human player, O represents the computer
    }

    /**
     * Starts the main game loop. Alternates turns between the human player and the computer
     * until there is a winner or the board is full. Displays the board after each move and
     * announces the result (win, lose, or draw).
     */
    public void playGame() {
        while (true) {
            board.printBoard(); // Display the current board state
            if (currentPlayer == 'X') {
                playerMove();
            } else {
                computerMove();
            }

            // Check if the current player has won
            if (board.isWinner(currentPlayer)) {
                board.printBoard();
                System.out.println(currentPlayer == 'X' ? "Congratulations! You win!" : "Computer wins!");
                break;
            }

            // Check if the board is full and result is a draw
            if (board.isBoardFull()) {
                board.printBoard();
                System.out.println("It's a draw!");
                break;
            }

            // Switch to the other player
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }

    /**
     * Handles the player's move. Prompts the player for a row and column, validates the move,
     * and updates the board. If the move is invalid, it prompts the player to try again.
     */
    private void playerMove() {
        Scanner scanner = new Scanner(System.in);
        int row, col;
        while (true) {
            System.out.print("Enter row (0, 1, 2) and column (0, 1, 2) for your move: ");
            row = scanner.nextInt();
            col = scanner.nextInt();
            if (board.isValidMove(row, col)) {
                board.makeMove(row, col, currentPlayer); // Place player's move on the board
                break;
            } else {
                System.out.println("Invalid move! Please try again.");
            }
        }
    }

    /**
     * Handles the computer's move. The computer first checks if it can win immediately.
     * If not, it tries to block the player from winning. If neither option is possible,
     * it makes a random move.
     */
    private void computerMove() {
        System.out.println("Computers move...");
        // Step 1: Attempt to win the game
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.isValidMove(i, j)) {
                    board.makeMove(i, j, 'O');
                    if (board.isWinner('O')) {
                        return; // Computer wins with this move
                    } else {
                        board.undoMove(i, j); // Undo move if it doesn't win
                    }
                }
            }
        }

        // Step 2: Attempt to block the player's winning move
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.isValidMove(i, j)) {
                    board.makeMove(i, j, 'X');
                    if (board.isWinner('X')) {
                        board.makeMove(i, j, 'O'); // Block player's winning move
                        return;
                    } else {
                        board.undoMove(i, j); // Undo move if it doesn't block
                    }
                }
            }
        }

        // Step 3: Make a random move if no win or block is possible
        while (true) {
            int row = (int) (Math.random() * 3);
            int col = (int) (Math.random() * 3);
            if (board.isValidMove(row, col)) {
                board.makeMove(row, col, 'O');
                break;
            }
        }
    }
}