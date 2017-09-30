package br.com.feraf.knightstour;

import br.com.feraf.knightstour.utils.KnightMoves;
import br.com.feraf.knightstour.utils.Position;

public class App {
	private final boolean DEBUG_STATUS = false;
	private final boolean DEBUG_BOARD = false;
	
	
	private Board board;
	private Knight knight;
	private int count;
	
	public App() {
		board = new Board();
		knight = new Knight();
		count = 1;
	}
	public static void main(String[] args) {
		App app = new App();
		
		app.start();
	}
	
	private void start() {
		
		int step = 0;
		board.moveTo(knight.getPosition(), step++);
		
		chooseMove(step);		
		
		System.out.println(board);
	}
	
	private boolean chooseMove(int step) {
		Position lastPosition = knight.getPosition();
		
		for (KnightMoves move : KnightMoves.values()) {
			if (nextMove(move, step)) {
				return true;
			}else {
				board.clearStep(step);
				knight.setPosition(lastPosition);
			}
		}
		
		return false;
	}
	
	private boolean nextMove(KnightMoves move, int step) {
		if (step == 64) return true;
		
		debug("Moving to " + move + " - Step: " + step);
		Position newMove = knight.moveTo(move);
		
		if (board.moveTo(newMove, step)) {
			knight.validateMove();
			return chooseMove(step + 1);
		}
		
		return false;
	}
	
	
	public void debug(String s) {
		if (DEBUG_STATUS) {
			System.out.println("[" + count++ + "] " + s);
		}
		if (DEBUG_BOARD) {
			System.out.println(board);
		}
	}
}
