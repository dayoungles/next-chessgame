package pieces;

import java.util.ArrayList;
import java.util.List;
//중복 코드 제거해야할 차례 다 하고 나면 퀸 커밋 해야함.

public class Queen extends Piece {
	public Queen(Color color, Position position) {
		super(color, Type.QUEEN, position);
	}

	@Override
	List<Position> getPossibleMoves() {
		List<Position> queenList = new ArrayList<Position>();
		Direction[] queenDirection = Direction.forRoyalDirection();
		
		for (Direction direction : queenDirection) {
			queenList.addAll(super.position.findsPosition(direction));
		}
		return queenList;
	}
}
