package br.com.feraf.knightstour;

import br.com.feraf.knightstour.utils.KnightMoves;
import br.com.feraf.knightstour.utils.Position;

public class Knight {
	private Position actualPosition;
	private Position newPosition;
	
	public Knight() {
//		this.actualPosition = new Position(4, 0);
		this.actualPosition = new Position();
		this.newPosition = new Position(actualPosition);
	}
	
	private void resetMove() {
		if (newPosition != actualPosition)
			newPosition = new Position(actualPosition);
	}
	
	public void validateMove() {
		if (actualPosition != newPosition)
			actualPosition = new Position(newPosition);
	}
	
	public Position getPosition() {
		return actualPosition;
	}
	
	public void setPosition(Position position) {
		actualPosition = position;
	}
	
	public Position moveTo(KnightMoves move) {
		resetMove();
		
		switch (move) {
			case ENE:
				moveToENE();
				break;
			case ESE:
				moveToESE();
				break;
			case NNE:
				moveToNNE();
				break;
			case NNW:
				moveToNNW();
				break;
			case SSE:
				moveToSSE();
				break;
			case SSW:
				moveToSSW();
				break;
			case WNW:
				moveToWNW();
				break;
			case WSW:
				moveToWSW();
				break;
			default:
				break;
		}
		
		return newPosition;
	}
	
	private void moveToNNE() {
		newPosition.moveToNorth(2);
		newPosition.moveToEast(1);
	}
	
	private void moveToENE() {
		newPosition.moveToNorth(1);
		newPosition.moveToEast(2);
	}
	
	private void moveToESE() {
		newPosition.moveToSouth(1);
		newPosition.moveToEast(2);
	}
	
	private void moveToSSE() {
		newPosition.moveToSouth(2);
		newPosition.moveToEast(1);
	}
	
	private void moveToSSW() {
		newPosition.moveToSouth(2);
		newPosition.moveToWest(1);
	}
	
	private void moveToWSW() {
		newPosition.moveToSouth(1);
		newPosition.moveToWest(2);
	}
	
	private void moveToWNW() {
		newPosition.moveToNorth(1);
		newPosition.moveToWest(2);
	}
	
	private void moveToNNW() {
		newPosition.moveToNorth(2);
		newPosition.moveToWest(1);
	}
}
