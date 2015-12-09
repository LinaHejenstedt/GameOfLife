package se.lina.view.buttons;

import java.awt.Color;

import se.lina.controller.GameOfLifeBoardController;

public final class StartJButton extends AbstractJButton {

	private static final long serialVersionUID = 1L;

	public StartJButton(GameOfLifeBoardController controller) {
		super(controller, "Start Simulation");
		setName("Start");
		setBackground(Color.GREEN);
	}

}
