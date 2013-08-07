package pieces;

import junit.framework.TestCase;

public class QueenTest extends TestCase {
	public void testQueenGetPossibleMove() throws Exception {
		Queen queen = new Queen(Piece.Color.BLACK, new Position("e1"));
		assertEquals(21, queen.getPossibleMoves().size());
		
		Queen queen2 = new Queen(Piece.Color.BLACK, new Position("d5"));
		assertEquals(27, queen2.getPossibleMoves().size());
	}
}
