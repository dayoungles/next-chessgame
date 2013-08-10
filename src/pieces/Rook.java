package pieces;

import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece {
	public Rook(Color color, Position position) {
		super(color, Type.ROOK, position);
	}

	@Override
	public List<Position> getPossibleMoves() {
		Direction[] linears = Direction.linearDirection();
		List<Position> positions = new ArrayList<Position>();
		for (Direction direction : linears) {
			positions.addAll(super.position.findsPosition(direction));
		}
		return positions;
	}
}
