/**
 * Main.java
 *
 * This file contains the main entry point for the Tic Tac Toe game.
 * It initializes the game and starts the gameplay loop.
 *
 * The Main class is responsible for setting up and starting a new instance
 * of the tic_tac_toe.Game class, where the core game logic is executed.
 */

package tic_tac_toe;

public class Main {

    /**
     * Main method - the entry point of the Tic Tac Toe game application.
     * It initializes an instance of the tic_tac_toe.Game class and starts the game by
     * calling the playGame() method.
     *
     * @param args Command line arguments (not used in this application).
     */
    public static void main(String[] args) {
        Game game = new Game(); // Initialize a new game instance
        game.playGame(); // Start the game loop
    }
}