package se.lina.view.buttons;

import java.awt.Color;

import se.lina.controller.GameOfLifeBoardController;

public final class ExitJButton extends AbstractJButton {

	private static final long serialVersionUID = -3465745521357559538L;

	public ExitJButton(GameOfLifeBoardController controller) {
		super(controller, "Exit");

		setBackground(Color.RED);
	}

}
