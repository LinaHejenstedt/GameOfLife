package se.lina.view.buttons;

import java.awt.Color;

import se.lina.controller.GameOfLifeBoardController;

public final class PauseBoardJButton extends AbstractJButton {

	private static final long serialVersionUID = -7675604815833675901L;

	public PauseBoardJButton(GameOfLifeBoardController controller) {
		super(controller, "Pause Simulation");
		setBackground(Color.YELLOW);

	}

}
