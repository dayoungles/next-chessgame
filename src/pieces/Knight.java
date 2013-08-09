package pieces;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {
	public Knight(Color color, Position position) {
		super(color, Type.KNIGHT, position);
	}

	@Override
	List<Position> getPossibleMoves() {
		List<Position> knightList = new ArrayList<Position>();
		Direction[] knightDirection = Direction.forKnightDirection();
		for (Direction direction : knightDirection){
			knightList.addAll(super.position.findKnightPosition(direction));
		}
		return knightList;
	}
}