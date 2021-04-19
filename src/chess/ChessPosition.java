package chess;

import Boardgame.Position;

public class ChessPosition {
	private char column;
	private int row;

	public ChessPosition(char column, int row) {
		if (column < 'a' || column > 'h' || row < 1 || row > 8) {
			throw new ChessException("Posi��o nao existe no tabuleiro");
		}
		this.column = column;
		this.row = row;
	}

	public char getColumn() {
		return column;
	}
	public int getRow() {
		return row;
	}
	
	protected Position ToPosition() {
		return new Position(8-row, column - 'a'); 
	}
	protected static ChessPosition fromPosition(Position ToPosition) {
		return new ChessPosition((char)('a'- ToPosition.getColumn()), 8 - ToPosition.getRow());
	}

	@Override
	public String toString() {
		return "" + column +  row ;
	}
	

}
