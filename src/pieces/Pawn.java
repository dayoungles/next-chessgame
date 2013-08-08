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
		Direction[] pawnDirection = Direction.forPawnDirection();
			//폰의 색깔에 따라서 남,북을 결정하고 싶은데 폰을 받는 법??
		if(super.color == Piece.Color.BLACK){
			//for (Direction direction : pawnDirection ){
				/*
				 * for를 없애고 남쪽으로 한칸 가도록 한다.??어떻게 해야하나?ㅠㅜㅠ
				 */
				pawnList.addAll(super.position.findPawnPosition(Direction.SOUTH));//한칸씩 전진 성공 ㅠㅠDirection.SOUTH잊지말자.ㅠㅠ
			//}
			return pawnList;
		}else if(super.color == Piece.Color.WHITE) {
			//for (Direction dirIter : pawnDirection){
				pawnList.addAll(super.position.findPawnPosition(Direction.NORTH));
			//}
			return pawnList;
		}
		return pawnList;
	}
}
