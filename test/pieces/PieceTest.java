package pieces;

import pieces.PieceOperations.Color;
import junit.framework.TestCase;

public class PieceTest extends TestCase {
	public void testIsWhite() throws Exception {
		Piece whitePawn = new Pawn(Color.WHITE, null);
		assertTrue(whitePawn.isWhite());
	}

	public void testIsBlack() throws Exception {
		Piece blackPawn = new Pawn(Color.BLACK, null);
		assertTrue(blackPawn.isBlack());
	}
	
	public void testMove() throws Exception {
		Position source = new Position("a1");
		Position target = new Position("a8");
		PieceOperations whitePawn = new Pawn(Color.WHITE, source);
		assertEquals(new Pawn(Color.WHITE, target), whitePawn.move(target));
	}
	
	public void testLeave() throws Exception {
		Position source = new Position("a1");
		PieceOperations whitePawn = new Pawn(Color.WHITE, source);
		assertEquals(new Empty(Color.NOCOLOR, source), whitePawn.leave());
	}
	
	public void testEmptyGetPossibleMove() throws Exception {
		Empty test = new Empty(PieceOperations.Color.NOCOLOR, new Position("a3") );
		assertEquals(0, test.getPossibleMoves().size());
	}
	
	public void testRookGetPossibleMove() throws Exception {
		Rook rook = new Rook(PieceOperations.Color.BLACK, new Position(0,0));
		assertEquals(14, rook.getPossibleMoves().size());
		System.out.println(rook.getPossibleMoves());
		
		Rook rook2 = new Rook(PieceOperations.Color.BLACK, new Position("b2"));
		assertEquals(14, rook2.getPossibleMoves().size());
	}
	public void testBishopGetPossibleMove() throws Exception {
		Bishop bishop = new Bishop(PieceOperations.Color.WHITE, new Position("c8"));
		assertEquals(7, bishop.getPossibleMoves().size());
		
		Bishop bishop2 = new Bishop(PieceOperations.Color.WHITE, new Position("d5"));
		assertEquals(13, bishop2.getPossibleMoves().size());
		
	}
	public void testQueenGetPossibleMove() throws Exception {
		Queen queen = new Queen(PieceOperations.Color.BLACK, new Position("e1"));
		assertEquals(21, queen.getPossibleMoves().size());
		
		Queen queen2 = new Queen(PieceOperations.Color.BLACK, new Position("d5"));
		assertEquals(27, queen2.getPossibleMoves().size());
	}
	public void testKingGetPossibleMove() throws Exception {
		King king = new King(PieceOperations.Color.BLACK, new Position("d5"));
		assertEquals(8, king.getPossibleMoves().size());
		System.out.println(king.getPossibleMoves());
	}
	public void testPawnGetPossibleMove() throws Exception {
		Pawn pawn = new Pawn(PieceOperations.Color.BLACK, new Position("e7"));
		System.out.println(pawn.getPossibleMoves());
		assertEquals(2, pawn.getPossibleMoves().size());
		
		Pawn pawn2 = new Pawn(PieceOperations.Color.BLACK, new Position("c5"));
		System.out.println(pawn2.getPossibleMoves());
		assertEquals(1, pawn2.getPossibleMoves().size());
		
		Pawn pawn1 = new Pawn(PieceOperations.Color.WHITE, new Position("a2"));
		System.out.println(pawn1.getPossibleMoves());
		assertEquals(2, pawn1.getPossibleMoves().size());
		
		
		Pawn pawn3 = new Pawn(PieceOperations.Color.WHITE, new Position("c5"));
		assertEquals(1, pawn3.getPossibleMoves().size());
		System.out.println(pawn3.getPossibleMoves());
	}
	
	public void testKnightGetPossibleMove() throws Exception {
		Knight knight = new Knight(PieceOperations.Color.BLACK, new Position("d6"));
		System.out.println(knight.getPossibleMoves());
		assertEquals(8, knight.getPossibleMoves().size());
	}
	public void testIsValid() throws Exception {
		Position source = new Position("a1");
		Position target = new Position("a9");
		PieceOperations whitePawn = new Pawn(Color.WHITE, source);
		assertEquals(new Pawn(Color.WHITE, target), whitePawn.move(target));//에러 나는 것 확인;
	}

}
