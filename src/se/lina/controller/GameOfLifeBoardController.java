package se.lina.controller;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import se.lina.model.GameOfLifeBoard;

public class GameOfLifeBoardController {

	private GameOfLifeBoard gameOfLifeBoard;
	private ScheduledExecutorService scheduler;
	private volatile boolean gameIsRunning;
	private volatile int delay;

	public GameOfLifeBoardController(GameOfLifeBoard gameOfLifeBoard) {
		this.gameOfLifeBoard = gameOfLifeBoard;
		scheduler = Executors.newScheduledThreadPool(1);
		gameIsRunning = false;
		delay = 500;

	}

	public void turnOnLight(int row, int column) {
		gameOfLifeBoard.turnLightOn(row, column);
	}

	public void turnOffLight(int row, int column) {
		gameOfLifeBoard.turnLightOff(row, column);
	}

	public void startSimulation() {
		gameIsRunning = true;
		sendTick();
	}

	private void sendTick(){
		if (gameIsRunning){
			reCalculateBoard();
			scheduler.schedule(new Runnable() {
				@Override
				public void run() {
					sendTick();
				}
			}, delay, TimeUnit.MILLISECONDS);
		}
	}
	
	public void pauseSimulation() {
		gameIsRunning = false;
	}

	public void reCalculateBoard() {
		gameOfLifeBoard.reCalculateBoard();
	}

	public void cleanBoard() {
		pauseSimulation();
		gameOfLifeBoard.cleanBoard();
	}

	public void changeSimulationTime(int delay) {
		this.delay = delay;
	}

	public void changeSize(int rows, int columns) {
		pauseSimulation();
		gameOfLifeBoard.changeSize(rows, columns);
	}

}
