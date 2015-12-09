package se.lina.view.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import se.lina.controller.GameOfLifeBoardController;

public abstract class AbstractJButton extends JButton implements ActionListener {

	private static final long serialVersionUID = -3942924809919446554L;
	private GameOfLifeBoardController controller;

	public AbstractJButton(GameOfLifeBoardController controller, String name) {
		this.controller = controller;
		addActionListener(this);
		setText(name);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		onClick(e);
	}

	private void onClick(ActionEvent e) {

		Object eventSource = e.getSource();

		if (eventSource instanceof StartJButton) {
			controller.startSimulation();
		} else if (eventSource instanceof PauseBoardJButton) {
			controller.pauseSimulation();
		} else if (eventSource instanceof ExitJButton) {
			System.exit(0);
		} else if (eventSource instanceof CleanBoardJButton) {
			controller.cleanBoard();
		} else if (eventSource instanceof ChangeSpeedButton) {
			controller.changeSimulationTime(((ChangeSpeedButton) eventSource).getTime());
		} else if (eventSource instanceof ChangeSizeButton) {
			int rows = ((ChangeSizeButton) eventSource).getRows();
			int columns = ((ChangeSizeButton) eventSource).getColumns();
			controller.changeSize(rows, columns);
		}

	}

}
