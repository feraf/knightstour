package br.com.feraf.knightstour;

import br.com.feraf.knightstour.utils.Position;

public class Board {
	private int numRows;
	private int numCols;
	private int [][] board;
	
	public Board() {
		numRows = 8;
		numCols = 8;
		
		init();
	}
	
	public Board(int cols, int rows) {
		numRows = rows;
		numCols = cols;
		
		init();
	}
	
	private void init() {
		board = new int[numCols][numRows];
		
		for (int i = 0; i < numCols; i++) {
			for (int j = 0; j < numRows; j++) {
				board[i][j] = -1;
			}
		}
	}
	
	private boolean canMoveTo(Position position) {
		int x = position.getXPosition();
		int y = position.getYPosition();
		
		if (x < 0) return false;
		if (x >= numRows) return false;
		
		if (y < 0) return false;
		if (y >= numCols) return false;
		
		if (board[y][x] != -1) return false;
		
		return true;
	}
	
	
	private void setStep(Position position, int step) {
		int x = position.getXPosition();
		int y = position.getYPosition();
		
		board[y][x] = step;
	}

	public void clearStep(int step) {
		for(int i = 0; i < numCols; i++) {
			for (int j = 0; j < numRows; j++) {
				if (board[i][j] == step) {
					board[i][j] = -1;
					return;
				}
			}
		}
	}
	
	public boolean moveTo(Position position, int step) {
		if (canMoveTo(position)) {
			setStep(position, step);
			
			return true;
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		StringBuilder separatorLine = new StringBuilder();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < numCols; i++) {
			separatorLine.append(" ----");
		}
		separatorLine.append("\n");
		
		sb.append(separatorLine);
		for (int x = 0; x < numCols; x++) {
			sb.append("|");
			for (int y = 0; y < numRows; y++) {
				sb.append(" ")
					.append((board[x][y] < 10 && board[x][y] > -1) ? "0" : "")
					.append(board[x][y])
					.append(" |");
			}
			sb.append("\n");
			sb.append(separatorLine);
		}
		
		return sb.toString();
	}
	
}
