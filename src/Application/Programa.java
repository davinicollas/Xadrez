package Application;

import Boardgame.Board;
import Boardgame.Position;
import chess.ChessMatch;

public class Programa {

	public static void main(String[] args) {
		
		ChessMatch chessmatch = new ChessMatch();
		UI.printBoard(chessmatch.getPieces());
	}

}
