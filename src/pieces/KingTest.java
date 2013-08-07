package pieces;

import junit.framework.TestCase;

public class KingTest extends TestCase {
	public void testKingGetPossibleMove() throws Exception {
		King king = new King(Piece.Color.BLACK, new Position("a5"));
		assertEquals(8, king.getPossibleMoves().size());
		System.out.println(king.getPossibleMoves());
	}
}
