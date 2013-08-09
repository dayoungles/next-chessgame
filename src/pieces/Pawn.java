package pieces;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {
	public Pawn(Color color, Position position) {
		super(color, Type.PAWN, position);
	}

	@Override
	List<Position> getPossibleMoves() {
		List<Position> pawnList = new ArrayList<Position>();
		// Direction[] pawnDirection = Direction.forPawnDirection();
		if (isBlack()) {
			if (super.position.getY() == 6) {
				Position pawnPosition = super.position.move(Direction.SOUTH);
				pawnList.add(pawnPosition);
				pawnList.add(pawnPosition.move(Direction.SOUTH));
				return pawnList;
			} else {
				pawnList.addAll(super.position.findPawnPosition(Direction.SOUTH));// 한칸씩 전진 성공
				return pawnList;
			}
		} else if (isWhite()) {
			if (super.position.getY() == 1) {
				Position pawnPosition = super.position.move(Direction.NORTH);
				pawnList.add(pawnPosition);
				pawnList.add(pawnPosition.move(Direction.NORTH));
				return pawnList;
			} else {	
				pawnList.addAll(super.position.findPawnPosition(Direction.NORTH));
				return pawnList;
			}
		}
		return pawnList;
	}
}
