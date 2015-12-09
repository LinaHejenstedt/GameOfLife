package se.lina.view;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import se.lina.controller.GameOfLifeBoardController;
import se.lina.model.GameObserver;
import se.lina.model.Square;

public final class MainWindow implements GameObserver{

	private static final int windowHeight = 750;
	private GameOfLifeBoardController gameBoardController;
	private int noOfRows;
	private int noOfColumns;
	private JFrame mainFrame;
	private GameJPanel gameBoardPanel;
	private StartJPanel startPanel;
	private int buttonSize;

	public MainWindow(GameOfLifeBoardController gameBoardController,
			int noOfRows, int noOfColumns) {
		this.gameBoardController = gameBoardController;
		this.noOfRows = noOfRows;
		this.noOfColumns = noOfColumns;
		initateMainFrame();
	}

	private void initateMainFrame() {

		buttonSize = windowHeight/noOfRows;
		int startPanelWidth=200;
		
		mainFrame= new JFrame("Game Of Life");
		mainFrame.setLayout(new FlowLayout());
		
		startPanel = new StartJPanel(gameBoardController, windowHeight, startPanelWidth);
		gameBoardPanel = new GameJPanel(gameBoardController, noOfRows, noOfColumns, buttonSize);
		
		mainFrame.add(gameBoardPanel);
		mainFrame.add(startPanel);

		mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		mainFrame.pack();
		mainFrame.setVisible(true);
		
	}

	@Override
	public void updatedBoard(Square[][] gameOfLifeBoard) {
		
		gameBoardPanel.updateBoardTiles(gameOfLifeBoard);

	}

	@Override
	public void changeBoardSize(int noOfRows, int noOfColumns) {
		
		this.noOfRows = noOfRows;
		this.noOfColumns = noOfColumns;
		buttonSize = windowHeight/noOfRows;

		mainFrame.remove(gameBoardPanel);
		gameBoardPanel = new GameJPanel(gameBoardController, noOfRows, noOfColumns, buttonSize);
		mainFrame.add(gameBoardPanel);
		
		mainFrame.pack();
	}
}
