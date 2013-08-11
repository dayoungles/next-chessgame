package chess;


public class ConsoleBoardGenerator implements GenerateBoardInterface{
	public static final String NEW_LINE = System.getProperty("line.separator");
	public static final int ROW_SIZE = 8;
	public static final int COLUMN_SIZE = 8;
	
	/**
	 * 랭크의 인덱스를 받아서 그 줄의 심볼을 리턴..
	 * @param rankIndex
	 * @return Symbol set of row
	 */
	@Override
	public String generateRank(Board board, int rankIndex) {
		Rank rank = board.ranks.get(rankIndex);
		StringBuilder sb = new StringBuilder();
		sb.append(rank.generate());
		return sb.toString();
	}
	
	@Override
	public String generateBoard(Board board){
		StringBuilder sb = new StringBuilder();
		for (int i = ROW_SIZE; i > 0; i--) {
			sb.append(generateRank(board, i-1) + NEW_LINE);
		}
		return sb.toString();
	}
	
}
