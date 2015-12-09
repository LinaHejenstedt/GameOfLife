package se.lina.view;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

import se.lina.controller.GameOfLifeBoardController;
import se.lina.view.buttons.TileJButton;

public final class GameOfLifeMouseListener implements MouseInputListener {

	private GameOfLifeBoardController controller;

	public GameOfLifeMouseListener(GameOfLifeBoardController controller) {
		this.controller = controller;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object tile = e.getSource();
		if (tile instanceof TileJButton) {
			onClick((TileJButton) tile);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if ((e.getModifiersEx() & MouseEvent.BUTTON1_DOWN_MASK) != 0) {
			Object tile = e.getSource();
			if (tile instanceof TileJButton) {
				onPressedMouse((TileJButton) tile);
			}
		}
	}

	@Override
	public void mouseExited(MouseEvent arg0) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if ((e.getModifiersEx() & MouseEvent.BUTTON1_DOWN_MASK) != 0) {
			Object tile = e.getSource();
			if (tile instanceof TileJButton) {
				onPressedMouse((TileJButton) tile);
			}
		}
	}

	public void onPressedMouse(TileJButton tile) {
		tile.turnOnLightInTile();
		controller.turnOnLight(tile.getRow(), tile.getColumn());
	}

	public void onClick(TileJButton tile) {
		if (!tile.isLit()) {
			tile.turnOnLightInTile();
			controller.turnOnLight(tile.getRow(), tile.getColumn());
		} else if (tile.isLit()) {
			tile.turnOffLightInTile();
			controller.turnOffLight(tile.getRow(), tile.getColumn());
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseDragged(MouseEvent e) {

	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

}
