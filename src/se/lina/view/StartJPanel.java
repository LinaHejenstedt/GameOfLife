package se.lina.view;

import java.awt.Font;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import se.lina.controller.GameOfLifeBoardController;
import se.lina.view.buttons.*;

public final class StartJPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public StartJPanel(GameOfLifeBoardController controller, int windowHeigth, int startPanelWidth) {
		
		setLayout(new GridLayout(15, 0, 0, 20));
		
		JLabel header = new JLabel("Simulation choices");
		setLabelStyleBoldCenter(header);
		this.add(header);

		this.add(new StartJButton(controller));
		this.add(new PauseBoardJButton(controller));
		this.add(new CleanBoardJButton(controller));
		this.add(new ExitJButton(controller));
		
		JLabel sizeHeader = new JLabel("Size choices");
		setLabelStyleBoldCenter(sizeHeader);
		this.add(sizeHeader);

		this.add(new ChangeSizeButton(20, 20, controller));
		this.add(new ChangeSizeButton(40, 40, controller));
		this.add(new ChangeSizeButton(50, 50, controller));

		JLabel speedHeader = new JLabel("Simulation rate choices");
		setLabelStyleBoldCenter(speedHeader);
		this.add(speedHeader);

		this.add(new ChangeSpeedButton(1000, controller));
		this.add(new ChangeSpeedButton(500, controller));
		this.add(new ChangeSpeedButton(250, controller));
	}

	private void setLabelStyleBoldCenter(JLabel speedHeader) {
		speedHeader.setFont(new Font("Helvetica", Font.BOLD, 15));
		speedHeader.setHorizontalAlignment(JLabel.CENTER);
	}

}
