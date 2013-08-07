package pieces;

import junit.framework.TestCase;

public class BishopTest extends TestCase {
	public void testBishopGetPossibleMove() throws Exception {
		Bishop bishop = new Bishop(Piece.Color.WHITE, new Position("c8"));
		assertEquals(7, bishop.getPossibleMoves().size());
		
		Bishop bishop2 = new Bishop(Piece.Color.WHITE, new Position("d5"));
		assertEquals(13, bishop2.getPossibleMoves().size());
		
	}
}
