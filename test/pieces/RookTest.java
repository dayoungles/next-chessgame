package pieces;

import junit.framework.TestCase;

public class RookTest extends TestCase {
	public void testRookGetPossibleMove() throws Exception {
		Rook rook = new Rook(Piece.Color.BLACK, new Position(0,0));
		assertEquals(14, rook.getPossibleMoves().size());
		System.out.println(rook.getPossibleMoves());
		
		Rook rook2 = new Rook(Piece.Color.BLACK, new Position("b2"));
		assertEquals(14, rook2.getPossibleMoves().size());
	}
}
