package chess;

import java.util.ArrayList;
import java.util.List;

import pieces.PieceOperations;
import pieces.Position;

public class Board {
	public static final String NEW_LINE = System.getProperty("line.separator");
	public static final int ROW_SIZE = 8;
	public static final int COLUMN_SIZE = 8;
	public GenerateBoardInterface boardGenerator = new ConsoleBoardGenerator();
	
	List<Rank> ranks = new ArrayList<Rank>();
	
	Board() { 
	}

	void initialize() {
		for (int i = 0; i < ROW_SIZE; i++) {
			Rank rank = new Rank(i);
			if (i==0) {
				rank.initializeWhiteExceptPawn();
			} else if (i==1) {
				rank.initializeWhitePawn();
			} else if (i==6) {	
				rank.initializeBlackPawn();
			} else if (i==7) {
				rank.initializeBlackExceptPawn();
			} else {
				rank.initializeEmpty();
			}
			ranks.add(rank);
		}
	}
	
	void initializeEmpty() {
		for (int i = 0; i < ROW_SIZE; i++) {
			Rank rank = new Rank(i);
			rank.initializeEmpty();
			ranks.add(rank);
		}
	}

	PieceOperations findPiece(String xy) {
		Position position = new Position(xy);
		return findPiece(position);
	}

	PieceOperations findPiece(Position position) {
		Rank rank = ranks.get(position.getY());
		return rank.findPiece(position);//좌표  리턴 
	}
/**
 * movePiece라는 메소드에 인자(원래 위치, 옮기려고 하는 말의 위치가 스트링으로 들어올 경우, 
 * movePiece (Position인자 )를 받도록 바꾼다. 
 * 그 후는 movePiece(Position source, Position target)이 활용
 * @param source
 * @param target
 */
	void movePiece(String source, String target) {
		movePiece(new Position(source), new Position(target));
	}
/**
 * 옮길 피스를 타겟 피스에 저장해두고, 타겟 값을 이용해서 타겟랭크로 옮긴다?
 * @param source  현재 위치 포지션 
 * @param target 이동하려는 목표 위
 */
	void movePiece(Position source, Position target) {
		PieceOperations targetPiece = findPiece(source); 
		PieceOperations sameColorPiece = findPiece(target);

		if(targetPiece.getSymbol() == '.'){
			return;
		}else if (targetPiece.matchColor(sameColorPiece.getColor())){
			return;
		} else if(!findPiece(source).getPossibleMoves().contains(target)){
			return;
		}
		else {
			PieceOperations sourcePiece = targetPiece.leave();//빈칸으로 만들어버린다.
			
			Rank sourceRank = ranks.get(source.getY());//row 한 줄 저장 
			sourceRank.move(sourcePiece, source);//옮길 피스 정체, 현 위치.
			
			Rank targetRank = ranks.get(target.getY());
			targetRank.move(targetPiece, target);
			
		}
	}

/**
 * 심볼이 다 들어간 보드를 생성 
 * @return 보드의 심볼을 스트링 형태로 리턴 
 */
	public String generateBoard() {
		return boardGenerator.generateBoard(this);
	}
	
	public void setBoardGenerator(GenerateBoardInterface boardGenerator){
		this.boardGenerator = boardGenerator;
		
	}
}
