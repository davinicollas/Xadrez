package Boardgame;

import chess.Color;

public class Board {
	private int rows;
	private int columns;
	private Piece[][] pieces;

	public Board(int rows, int columns) {
		if(rows<1 || columns <1) {
			throw new BoardException("Erro criando o tabuleiro necessario 1 linha e 1 coluna");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public Piece piece(int row, int column) {
		if(!postitionExists(row, column)) {
			throw new BoardException("Posição nao existe no tabuleiro");
		}
		return pieces[row][column];
	}

	public Piece piece(Position position) {
		if(!postitionExists(position)) {
			throw new BoardException("Posição nao existe no tabuleiro");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	public void placePiece(Piece piece, Position position) {
		if(thereIsAsPice(position)) {
			throw new BoardException("Já possui peça nessa position" + position);
		}
		pieces[position.getRow()][position.getColumn()]=piece;
		piece.position = position;
	}
	private boolean postitionExists(int row, int column) {
		return row>=0 && row<rows && column >= 0 && column < columns;
	}
	public boolean postitionExists(Position position) {
		return postitionExists(position.getRow(), position.getColumn());
	}
	public boolean thereIsAsPice(Position position) {
		if(!postitionExists(position)) {
			throw new BoardException("Posição nao existe no tabuleiro");
		}
		return piece(position) !=null;
	}
	public Piece removePiece(Position position) {
		if(!postitionExists(position)) {
			throw new BoardException("Posição nao existe no tabuleiro");
		}
		if(piece(position)==null) {
			return null;
		}
		Piece aux = piece(position);
		aux.position = null;
		pieces[position.getRow()][position.getColumn()]=null;
		return aux;
	}
}
