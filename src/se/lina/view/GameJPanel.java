package se.lina.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import se.lina.controller.GameOfLifeBoardController;
import se.lina.model.Square;
import se.lina.view.buttons.TileJButton;

public final class GameJPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private List<TileJButton> buttons;
	private GameOfLifeMouseListener listener;

	public GameJPanel(GameOfLifeBoardController controller, int noOfRows, int noOfColumns, int buttonSize) {

		buttons = new ArrayList<TileJButton>();
		listener = new GameOfLifeMouseListener(controller);

		this.setName("GAME OF LIFE BOARD");
		this.setBackground(Color.CYAN);

		this.setLayout(new GridLayout(noOfRows, noOfColumns, 1, 1));

		for (int row = 0; row < noOfRows; row++) {
			for (int column = 0; column < noOfColumns; column++) {
				TileJButton tempButton = new TileJButton(row, column, buttonSize);
				tempButton.addMouseListener(listener);
				this.add(tempButton);
				buttons.add(tempButton);
			}
		}

	}

	public void updateBoardTiles(Square[][] gameOfLifeBoard) {

		for (int row = 0; row < gameOfLifeBoard.length; row++) {
			for (int column = 0; column < gameOfLifeBoard[0].length; column++) {
				for (TileJButton button : buttons) {
					if (button.getRow() == row && button.getColumn() == column) {
						button.changeColor(gameOfLifeBoard[row][column].isLit());
					}
				}

			}
		}
	}

}
