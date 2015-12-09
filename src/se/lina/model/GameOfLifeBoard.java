package se.lina.model;

import java.util.ArrayList;
import java.util.List;

public final class GameOfLifeBoard {

	private List<GameObserver> observers;
	private Square[][] gameOfLifeBoard;
	private Square[][] boardForChanges;
	private GameOfLifeBoardCalculator calculator;

	public GameOfLifeBoard(Square[][] gameOfLifeBoard, Square[][] boardForChanges) {
		observers = new ArrayList<GameObserver>();
		calculator = new GameOfLifeBoardCalculator();

		this.gameOfLifeBoard = gameOfLifeBoard;
		this.boardForChanges = boardForChanges;

		fillBoardsWithEmptySquares();
	}

	public void reCalculateBoard() {
		calculateNoOfNeighbours();
		updateGameOfLifeBoard();
		publishUpdatedBoard();
	}

	public void turnLightOn(int row, int column) {
		gameOfLifeBoard[row][column].turnOnLight();
	}

	public void turnLightOff(int row, int column) {
		gameOfLifeBoard[row][column].turnOffLight();
	}

	public void publishUpdatedBoard() {
		observers.forEach(t -> t.updatedBoard(gameOfLifeBoard));
	}

	public void publishNewBoardSize() {
		observers.forEach(t -> t.changeBoardSize(gameOfLifeBoard.length, gameOfLifeBoard[0].length));
	}

	public void addObserver(GameObserver gameObserver) {
		observers.add(gameObserver);
	}

	public void cleanBoard() {
		for (int row = 0; row < boardForChanges.length; row++) {
			for (int column = 0; column < boardForChanges[0].length; column++) {
				turnLightOff(row, column);
			}
		}
		publishUpdatedBoard();
	}

	public void changeSize(int rows, int columns) {

		gameOfLifeBoard = new Square[rows][columns];
		boardForChanges = new Square[rows][columns];

		fillBoardsWithEmptySquares();
		publishNewBoardSize();

	}

	private void fillBoardsWithEmptySquares() {

		for (int row = 0; row < boardForChanges.length; row++) {
			for (int column = 0; column < boardForChanges[0].length; column++) {
				boardForChanges[row][column] = new Square();
				gameOfLifeBoard[row][column] = new Square();
			}
		}

	}

	private void calculateNoOfNeighbours() {
		for (int row = 0; row < gameOfLifeBoard.length; row++) {
			for (int column = 0; column < gameOfLifeBoard[0].length; column++) {
				int noAround = calculator.calculateLitSqauresAround(gameOfLifeBoard, row, column);
				boardForChanges[row][column].setNoOfNeighbours(noAround);
			}
		}
	}

	private void updateGameOfLifeBoard() {

		for (int row = 0; row < boardForChanges.length; row++) {
			for (int column = 0; column < boardForChanges[0].length; column++) {
				if (lessThanTwoOrMoreThanThreeNeighbours(row, column)) {
					turnLightOff(row, column);
				} else if (exactlyThreeNeigbours(row, column)) {
					turnLightOn(row, column);
				}
			}
		}
	}

	private boolean lessThanTwoOrMoreThanThreeNeighbours(int row, int column) {
		return (boardForChanges[row][column].getNoOfNeighbours() < 2
				|| boardForChanges[row][column].getNoOfNeighbours() > 3);
	}

	private boolean exactlyThreeNeigbours(int row, int column) {
		return boardForChanges[row][column].getNoOfNeighbours() == 3;
	}
}
