package pieces;


/**
 * 이동방향 관련 enum class
 * @author dayoungle
 */
public enum Direction {
	NORTH(0, 1),
	NORTHEAST(1, 1),
	EAST(1, 0),
	SOUTHEAST(1, -1),
	SOUTH(0, -1),
	SOUTHWEST(-1, -1),
	WEST(-1, 0),
	NORTHWEST(-1, 1),
	
	K_NNW (-1, 2),
	K_NNE (1, 2),
	K_EEN (2, 1),
	K_EES (2, -1),
	K_SSE (1, -2),
	K_SSW (-1,-2),
	K_WWS (-2, -1),
	K_WWN (-2, 1);
	
	

	private int xDegree;
	private int yDegree;

	private Direction(int xDegree, int yDegree) {
		this.xDegree = xDegree;
		this.yDegree = yDegree;
	}

	public int getXDegree() {
		return xDegree;
	}

	public int getYDegree() {
		return yDegree;
	}
	//
	public static Direction[] linearDirection() {
		return new Direction[] { NORTH, EAST, SOUTH, WEST };
	} 

	public static Direction[] diagonalDirection() {
		return new Direction[] { NORTHEAST, SOUTHEAST, SOUTHWEST, NORTHWEST };
	}
	public static Direction[] forRoyalDirection(){
		return new Direction[] { NORTH, EAST, SOUTH, WEST, NORTHEAST, SOUTHEAST, SOUTHWEST, NORTHWEST };
	}

	public static Direction[] forPawnDirection() {
		return new Direction[] {NORTH, SOUTH};
	}
	public static Direction[] forKnightDirection(){
		return new Direction[] {K_EEN, K_EES, K_NNE, K_NNW, K_SSE, K_SSW, K_WWN, K_WWS};
	}
}
