import java.util.logging.Level;
import java.util.logging.Logger;

public class MainClass {
	
	public static void main(String[] args) {
		
		// Create the MainGUI instance.
		final MainGUI gui = new MainGUI("Gomoku Unit Factory");
		
		// Create a 19x19 game board.
		final int width = 800;
		Board board = new Board(width, 19);
		
		// Create the Game manager instance.
		final Game game = new Game(board);
		
		// Attach the game board's GUI component to the main frame.
		gui.attachBoard(board.getGUI());
		
		// Make the frame wrap the contents and set it visible.
		gui.pack();
		gui.setVisible(true);
		
		// Start listening for the Game Start button click.
		gui.listenGameStartButton(actionEvent -> {
				// Get the settings from the Main GUI manager.
				GameSettings settings = gui.fetchSettings();

				Logger.getGlobal().log(Level.INFO, settings.toString());
				// Make the game board visible to the user.
				gui.showBoard();

				// Apply the settings.
				game.setAIDepth(settings.getDifficulty());
				game.setAIStarts(settings.getFirstMove() == GameSettings.FirstMove.COMPUTER);

				// Start the game.
				game.start();
		});
	}
}
