package se.lina.model;

public interface GameObserver {

	void updatedBoard(Square[][] gameOfLifeBoard);

	void changeBoardSize(int noOfRows, int noOfColumns);
	
	
}
