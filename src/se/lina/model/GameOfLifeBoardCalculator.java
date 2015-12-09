package se.lina.model;

public final class GameOfLifeBoardCalculator {

	private Square[][] gameOfLifeBoard;
	private int column;
	private int row;

	public int calculateLitSqauresAround(final Square[][] gameOfLifeBoard, final int row, final int column) {

		this.gameOfLifeBoard = gameOfLifeBoard;
		this.row = row;
		this.column = column;
		
		return isLitToTheLeft() + isLitTopLeft() + isLitAbove() + isLitTopRight() + isLitToTheRight()
				+ isLitBottomRight() + isLitBelow() + isLitBottomLeft();
	}

	private int isLitBottomLeft() {
		if (column > 0) {
			if (row < (gameOfLifeBoard[0].length - 1)) {
				if (gameOfLifeBoard[row + 1][column - 1].isLit()) {
					return 1;
				}
			}
		}
		return 0;
	}

	private int isLitToTheLeft() {
		if (column > 0) {
			if (gameOfLifeBoard[row][column - 1].isLit()) {
				return 1;
			}
		}
		return 0;
	}

	private int isLitTopLeft() {
		if (column > 0) {
			if (row > 0) {
				if (gameOfLifeBoard[row - 1][column - 1].isLit()) {
					return 1;
				}
			}
		}
		return 0;
	}

	private int isLitAbove() {
		if (row > 0) {
			if (gameOfLifeBoard[row - 1][column].isLit()) {
				return 1;
			}
		}
		return 0;
	}

	private int isLitTopRight() {
		if (column < (gameOfLifeBoard.length - 1)) {
			if (row > 0) {
				if (gameOfLifeBoard[row - 1][column + 1].isLit()) {
					return 1;
				}
			}
		}
		return 0;
	}

	private int isLitToTheRight() {
		if (column < (gameOfLifeBoard.length - 1)) {
			if (gameOfLifeBoard[row][column + 1].isLit()) {
				return 1;
			}
		}
		return 0;
	}

	private int isLitBottomRight() {
		if (column < (gameOfLifeBoard.length - 1)) {
			if (row < (gameOfLifeBoard[0].length - 1)) {
				if (gameOfLifeBoard[row + 1][column + 1].isLit()) {
					return 1;
				}
			}
		}
		return 0;
	}

	private int isLitBelow() {
		if (row < (gameOfLifeBoard[0].length - 1)) {
			if (gameOfLifeBoard[row + 1][column].isLit()) {
				return 1;
			}
		}
		return 0;
	}

}