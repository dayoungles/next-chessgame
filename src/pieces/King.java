package pieces;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {
	public King(Color color, Position position) {
		super(color, Type.KING, position);
	}

	@Override
	List<Position> getPossibleMoves() {
		List<Position> kingList = new ArrayList<Position>();
		Direction[] kingDirection = Direction.forRoyalDirection();
		for (Direction direction : kingDirection){
			kingList.addAll(super.position.findKingPosition(direction));
		}
		return kingList;
	}
}

