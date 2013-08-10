package pieces;

import java.util.List;
import java.util.ArrayList;

public class Empty extends Piece {
	public Empty(Color color, Position position) {
		super(color, Type.EMPTY, position);
	}

	@Override
	public List<Position> getPossibleMoves() {
		List<Position> list = new ArrayList<Position>();//리스트를 생성한 후 리턴하면 이동가능한 거리가 없음.
		return list;
	}
}
