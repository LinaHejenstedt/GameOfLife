package se.lina.view.buttons;

import java.awt.Color;

import se.lina.controller.GameOfLifeBoardController;

public final class ChangeSpeedButton extends AbstractJButton {

	private static final long serialVersionUID = 1L;
	private int time;

	public ChangeSpeedButton(int time, GameOfLifeBoardController controller) {
		super(controller, "Speed: " + time + "ms");
		this.time = time;
		setBackground(Color.CYAN);
	}

	public int getTime() {
		return time;
	}
}
