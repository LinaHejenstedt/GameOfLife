package se.lina.view.buttons;

import java.awt.Color;

import se.lina.controller.GameOfLifeBoardController;

public final class CleanBoardJButton extends AbstractJButton {

	private static final long serialVersionUID = 1L;

	public CleanBoardJButton(GameOfLifeBoardController controller) {
		super(controller, "Clean board");
		setBackground(Color.YELLOW);
	}

}
