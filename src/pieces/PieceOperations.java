package pieces;

import java.util.List;

public interface PieceOperations {

	public enum Color {
		WHITE,
		BLACK,
		NOCOLOR;
	}
	public char getSymbol();

	public boolean matchColor(Color color);

	public PieceOperations leave();

	public PieceOperations move(Position target);

	public List<Position> getPossibleMoves();

	public int hashCode();

	public boolean equals(Object obj);

	public String toString();
	
	public Color getColor();

}