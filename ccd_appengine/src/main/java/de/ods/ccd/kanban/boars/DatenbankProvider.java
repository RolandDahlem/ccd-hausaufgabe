package de.ods.ccd.kanban.boars;

import de.ods.ccd.kanban.contracts.Board;

public class DatenbankProvider {

	private Board board;

	public void speichere(Board board) {
		this.board = board;
	}

	public Board getBoard() {
		return board;
	}

}
