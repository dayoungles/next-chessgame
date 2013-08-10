package chess;

import junit.framework.TestCase;
import pieces.Empty;
import pieces.Pawn;
import pieces.Piece;
import pieces.Piece.Color;
import pieces.Position;
import pieces.King;

public class BoardTest extends TestCase {
	private Board board;
	
	@Override
	protected void setUp() throws Exception {
		board = new Board();
	}
	
	public void testCreate() throws Exception {
		board.initialize();
		assertEquals(RankTest.WHITE_PAWN_RANK, board.generateRank(1));
		assertEquals(RankTest.BLACK_PAWN_RANK, board.generateRank(6));
	}
	
	public void testPrint() throws Exception {
		board.initialize();
		String expected = 
			RankTest.BLACK_EXCEPT_PAWN_RANK + Board.NEW_LINE +
			RankTest.BLACK_PAWN_RANK + Board.NEW_LINE +
			createEmptyRank() + 
			createEmptyRank() + 
			createEmptyRank() + 
			createEmptyRank() +
			RankTest.WHITE_PAWN_RANK + Board.NEW_LINE +
			RankTest.WHITE_EXCEPT_PAWN_RANK + Board.NEW_LINE;
		assertEquals(expected, board.generateBoard());
		System.out.println(board.generateBoard());
	}
	
	private String createEmptyRank() {
		return RankTest.EMPTY_RANK + Board.NEW_LINE;
	}
	
	public void testFindPiece() throws Exception {
		board.initialize();
		assertEquals('R', board.findPiece("a8").getSymbol());
		assertEquals('k', board.findPiece("e1").getSymbol());
	}
	
	public void testInitializeEmpty() throws Exception {
		board.initializeEmpty();
		System.out.println(board.generateBoard());
	}
	
	public void testMovePiece() throws Exception {
		board.initialize();
		Position source = new Position("a2");
		Piece sourcePiece = board.findPiece(source);
		assertEquals(new Pawn(Color.WHITE, source), sourcePiece);
		
		Position target = new Position("e8");
		board.movePiece(source, target);
		assertEquals(new Empty(Color.NOCOLOR, source), board.findPiece(source));
		assertEquals(new Pawn(Color.WHITE, target), board.findPiece(target));
		System.out.println(board.generateBoard());
		
		board.initialize();
		Position source1 = new Position("a3");
		Piece sourcePiece1 = board.findPiece(source1);
		assertEquals(new Empty(Color.NOCOLOR, source1), sourcePiece1);
		
		Position target1 = new Position("e7");
		board.movePiece(source1, target1);
		assertEquals(new Empty(Color.NOCOLOR, source1), board.findPiece(source1));
		assertEquals(new Pawn(Color.BLACK, target1), board.findPiece(target1));
		System.out.println(board.generateBoard());
	}
	
	public void testIfSameColorPiece() throws Exception {
		board.initialize();
		Position source = new Position ("e1");
		Piece sourcePiece = board.findPiece(source);
		assertEquals(new King(Color.WHITE, source), sourcePiece);
		
		Position target = new Position("d2");
		board.movePiece(source, target);
		assertEquals(new Pawn(Color.WHITE, target), board.findPiece(target));
		
	}
	public void testMovePieceWithGetPossibleMove() throws Exception {
		board.initialize();
		Position source = new Position("a2");
		Position target = new Position("a4");
		
		board.movePiece(source, target);
		assertEquals(new Empty(Color.NOCOLOR, source), board.findPiece(source));
		assertEquals(new Pawn(Color.WHITE, target), board.findPiece(target));
		System.out.println(board.generateBoard());
	}
	
}
