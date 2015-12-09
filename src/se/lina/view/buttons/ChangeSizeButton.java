package se.lina.view.buttons;

import java.awt.Color;

import se.lina.controller.GameOfLifeBoardController;

public final class ChangeSizeButton extends AbstractJButton {
	private static final long serialVersionUID = 1L;
	private int columns;
	private int rows;

	public ChangeSizeButton(int rows, int columns, GameOfLifeBoardController controller) {
		super(controller, "Size: " + rows + "*" + columns);
		this.rows = rows;
		this.columns = columns;
		setBackground(Color.BLUE);
		setForeground(Color.WHITE);
	}

	public int getColumns() {
		return columns;
	}

	public int getRows() {
		return rows;
	}
}
