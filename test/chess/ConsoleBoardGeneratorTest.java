package chess;

import junit.framework.TestCase;

public class ConsoleBoardGeneratorTest extends TestCase {
	public static final String NEW_LINE = System.getProperty("line.separator");

	private Board board;
	private GenerateBoardInterface boardGenerator;

	@Override
	protected void setUp() throws Exception {
		board = new Board();
		boardGenerator = new ConsoleBoardGenerator();
		
	}
	
	public void testGenerateRank() throws Exception {
		
		
		board.initialize();
		assertEquals(RankTest.WHITE_PAWN_RANK, boardGenerator.generateRank(board, 1));
		assertEquals(RankTest.BLACK_PAWN_RANK, boardGenerator.generateRank(board, 6));
	}
	
	public void testGenerateBoard() throws Exception {
		
		String unhappyBoard =
				RankTest.BLACK_EXCEPT_PAWN_RANK + NEW_LINE
				+ RankTest.BLACK_PAWN_RANK + NEW_LINE 
				+ RankTest.EMPTY_RANK + NEW_LINE
				+ RankTest.EMPTY_RANK + NEW_LINE
				+ RankTest.EMPTY_RANK + NEW_LINE
				+ RankTest.EMPTY_RANK + NEW_LINE
				+ RankTest.WHITE_PAWN_RANK + NEW_LINE
				+ RankTest.WHITE_EXCEPT_PAWN_RANK + NEW_LINE;
				
		board.initialize();
		assertEquals(unhappyBoard, boardGenerator.generateBoard(board));
		System.out.println(boardGenerator.generateBoard(board));
	}
	
}
