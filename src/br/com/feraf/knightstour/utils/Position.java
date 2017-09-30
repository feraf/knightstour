package br.com.feraf.knightstour.utils;

public class Position {
	private int posX;
	private int posY;
	
	public Position() {
		this.posX = 0;
		this.posY = 0;
	}
	
	public Position(int x, int y) {
		this.posX = x;
		this.posY = y;
	}
	
	public Position(Position pos) {
		this.posX = pos.getXPosition();
		this.posY = pos.getYPosition();
	}
	
	public void moveToNorth(int spots) {
		this.posY -= spots;
	}
	
	public void moveToEast(int spots) {
		this.posX += spots;
	}
	
	public void moveToSouth(int spots) {
		this.posY += spots;
	}
	
	public void moveToWest(int spots) {
		this.posX -= spots;
	}
	
	public int getXPosition() {
		return this.posX;
	}
	
	public int getYPosition() {
		return this.posY;
	}
	
	@Override
	public String toString() {
		return posX + ":" + posY;
	}
	
	@Override
	public boolean equals(Object position) {
		if (position instanceof Position) {
			Position pos = (Position) position;
			
			if (this.getXPosition() == pos.getXPosition() && this.getYPosition() == pos.getYPosition()) {
				return true;
			}
		}
		
		return false;
	}
}
