package se.lina;

import javax.swing.SwingUtilities;

import se.lina.controller.GameOfLifeBoardController;
import se.lina.model.GameOfLifeBoard;
import se.lina.model.Square;
import se.lina.view.MainWindow;
/**
 * 
 * @author Lina
 *
 */
public class GameOfLife {

	private GameOfLifeBoard gameOfLifeBoard;

	public static void main(String[] args) {
		GameOfLife game = new GameOfLife();
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				game.startGame(); 
			}
		});
	}

	protected void startGame() {

		int rows = 20;
		int columns = 20;

		gameOfLifeBoard = new GameOfLifeBoard(new Square[rows][columns], new Square[rows][columns]);
		GameOfLifeBoardController gameOfLifeBoardController= new GameOfLifeBoardController(gameOfLifeBoard);
		MainWindow mainWindow = new MainWindow(gameOfLifeBoardController, rows, columns);
		gameOfLifeBoard.addObserver(mainWindow);
		
	}

	public GameOfLife() {

	}

}
