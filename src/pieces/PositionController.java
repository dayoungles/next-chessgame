package pieces;

import java.util.ArrayList;
import java.util.List;

public class PositionController {
	private Position position;;

	public PositionController(Position position) {
		this.position = position;
	}

	public List<Position> findsLinearPositionAll() {//Rook 친구.
		Direction[] linears = Direction.linearDirection();
		List<Position> positions = new ArrayList<Position>();//arrayList와 그냥 list의 관계는 overriding이라고 함. 
		for (Direction direction : linears) {
			positions.addAll(position.findsPosition(direction));
		}
		return positions;
	}

	public List<Position> findsDiagonalPositionAll() {//bishop 친
		Direction[] diagonals = Direction.diagonalDirection();
		List<Position> positions = new ArrayList<Position>();
		for (Direction direction : diagonals) {
			positions.addAll(position.findsPosition(direction));
		}
		return positions;
	}
}
