package se.lina.view.buttons;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

public final class TileJButton extends JButton {

	private static final long serialVersionUID = 1L;
	private boolean isLit;
	private int row;
	private int column;

	public TileJButton(int row, int column, int buttonSize) {
		this.row = row;
		this.column = column;
		isLit = false;
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(buttonSize, buttonSize));
	}

	public void changeColor(boolean shouldBeLit) {
		if (shouldBeLit) {
			turnOnLightInTile();
		} else {
			turnOffLightInTile();
		}
	}

	public void turnOffLightInTile() {
		setBackground(Color.WHITE);
		isLit = false;
	}

	public void turnOnLightInTile() {
		setBackground(Color.BLACK);
		isLit = true;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public boolean isLit() {
		return isLit;
	}

	@Override
	public String toString() {
		return "Button " + row + " " + column;
	}
}
