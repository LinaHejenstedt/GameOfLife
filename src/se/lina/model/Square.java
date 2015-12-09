package se.lina.model;

public final class Square {

	private boolean isLit;
	private int noOfNeighbours;

	public Square() {
		isLit = false;
		noOfNeighbours = 0;
	}

	protected void turnOffLight() {
		isLit = false;
	}

	protected void turnOnLight() {
		isLit = true;
	}

	public boolean isLit() {
		return isLit;
	}

	public int getNoOfNeighbours() {
		return noOfNeighbours;
	}

	public void setNoOfNeighbours(int noOfNeigbours) {
		this.noOfNeighbours = noOfNeigbours;
	}
}
