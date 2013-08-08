package pieces;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import chess.Board;

public class Position {
	private static final char COLUMN_START_CHAR = 'a';

	private int x;
	private int y;
/**
 * position의 생성자 중 스트링으로 인자를 받아서 x좌표와 y좌표로 쪼개서, 저장.
 * @param position
 */
	public Position(String position) {
		// 에러 상태에 대한 처리 필요함.
		this.x = generateColumnIndex(position.charAt(0));
		this.y = Integer.parseInt(position.substring(1)) - 1;
	}
/**
 * x, y좌표를 각각 인자로 받게 되면 곧장  x, y좌표  설정 
 * @param x
 * @param y
 */
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
/**
 *  x축은 캐릭터, 즉 알파벳이다. 이걸 숫자로 변환하는 메소드.
 * @param columnIndex는
 * @return
 */
	private int generateColumnIndex(char columnIndex) {
		int target = Character.getNumericValue(columnIndex);
		int source = Character.getNumericValue(COLUMN_START_CHAR);
		return target - source;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
	
	Position move(Direction direction) {
		return new Position(this.x + direction.getXDegree(), this.y + direction.getYDegree());
	}

	List<Position> findsPosition(Direction direction) {
		ArrayList<Position> positions = new ArrayList<Position>();
		Position currentPosition = move(direction);
		
		while(currentPosition.isValid()) {
			positions.add(currentPosition);
			currentPosition = currentPosition.move(direction);
		}
		return positions;
	}
	
	List<Position> findKingPosition(Direction direction){
		ArrayList<Position> positions = new ArrayList<Position>();
		Position currentPosition = move(direction);
		positions.add(currentPosition);
		return positions;
	}
	List<Position> findPawnPosition(Direction  direction){
		ArrayList<Position> positions = new ArrayList<Position>();
		Position currentPosition; //=move(direction); 
//		if (currentPosition.getY() == 1 || currentPosition.getY() == 6){
//			for(int i = 0; i<2; i++){
//				currentPosition = move(direction);
//				positions.add(currentPosition);
//			}
//		} else {
			currentPosition = move(direction);
			positions.add(currentPosition);
//		}

		return positions;
	}
	
	boolean isValid() {
		if ( y < 0 || y >= Board.ROW_SIZE) {
			return false;
		}

		if ( x < 0 || x >= Board.COLUMN_SIZE) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Position [x=" + x + ", y=" + y + "]";
	}




}
