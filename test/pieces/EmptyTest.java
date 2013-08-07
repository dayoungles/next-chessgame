package pieces;

import junit.framework.TestCase;

public class EmptyTest extends TestCase {
	public void testEmptyGetPossibleMove() throws Exception {
		Empty test = new Empty(Piece.Color.NOCOLOR, new Position("a3") );
		assertEquals(0, test.getPossibleMoves().size());
	}
}
