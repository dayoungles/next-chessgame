package chess;

import java.util.ArrayList;
import java.util.List;

import pieces.Bishop;
import pieces.Empty;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Piece;
import pieces.PieceOperations.Color;
import pieces.PieceOperations;
import pieces.Position;
import pieces.Queen;
import pieces.Rook;

public class Rank {
	private List<Piece> rank = new ArrayList<Piece>();
	
	private int rankPosition;
	/**
	 * Rank는 내가 사용하던 standardRow와 같은 역
	 * @param yPosition =row Number
	 */
	Rank(int yPosition) {
		this.rankPosition = yPosition;
	}

	void initializeEmpty() {
		for (int i = 0; i < Board.COLUMN_SIZE; i++) {
			rank.add( new Empty(PieceOperations.Color.NOCOLOR, new Position(i, rankPosition)) );
		}
	}
	
	void initializeWhitePawn() {
		for (int i = 0; i < Board.COLUMN_SIZE; i++) {
			rank.add(new Pawn(Color.WHITE, new Position(i, rankPosition)) );
		}
	}
	
	void initializeBlackPawn() {
		for (int i = 0; i < Board.COLUMN_SIZE; i++) {
			rank.add(new Pawn(Color.BLACK, new Position(i, rankPosition)) );
		}
	}
	
	void initializeWhiteExceptPawn() {
		rank.add(new Rook(Color.WHITE, new Position(0, rankPosition)) );
		rank.add(new Knight(Color.WHITE, new Position(1, rankPosition)) );
		rank.add(new Bishop(Color.WHITE, new Position(2, rankPosition)) );
		rank.add(new Queen(Color.WHITE, new Position(3, rankPosition)) );
		rank.add(new King(Color.WHITE, new Position(4, rankPosition)) );
		rank.add(new Bishop(Color.WHITE, new Position(5, rankPosition)) );
		rank.add(new Knight(Color.WHITE, new Position(6, rankPosition)) );
		rank.add(new Rook(Color.WHITE, new Position(7, rankPosition)) );
	}
	

	void initializeBlackExceptPawn() {
		rank.add(new Rook(Color.BLACK, new Position(0, rankPosition)) );
		rank.add(new Knight(Color.BLACK, new Position(1, rankPosition)) );
		rank.add(new Bishop(Color.BLACK, new Position(2, rankPosition)) );
		rank.add(new Queen(Color.BLACK, new Position(3, rankPosition)) );
		rank.add(new King(Color.BLACK, new Position(4, rankPosition)) );
		rank.add(new Bishop(Color.BLACK, new Position(5, rankPosition)) );
		rank.add(new Knight(Color.BLACK, new Position(6, rankPosition)) );
		rank.add(new Rook(Color.BLACK, new Position(7, rankPosition)) );
	}
/**
 * 심볼 한 줄로 이어붙이는 메소드.
 * @return row하나의 심볼 세트 
 */
	String generate() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < Board.COLUMN_SIZE; i++) {
			sb.append(rank.get(i).getSymbol());
		}
		return sb.toString();
	}
/**
 * @param position
 * @return x좌표 리턴하는 듯?
 */
	PieceOperations findPiece(Position position) {
		return rank.get(position.getX());
	}

/**
 * 
 * @param sourcePiece
 * @param target
 * @return
 */
	PieceOperations move(PieceOperations sourcePiece, Position target) {
		sourcePiece.move(target);
		rank.set(target.getX(), (Piece) sourcePiece);
		return sourcePiece;
	}
}
