package pieces;

import java.util.ArrayList;
import java.util.List;


public class Bishop extends Piece {
	public Bishop(Color color, Position position) {
		super(color, Type.BISHOP, position);
	}

	@Override
	public List<Position> getPossibleMoves() {
		List<Position> bishop = new ArrayList<Position>();
		Direction [] diagonals = Direction.diagonalDirection();
		for(Direction direction : diagonals){
			bishop.addAll(position.findsPosition(direction));
		}
		return bishop;
	}
}