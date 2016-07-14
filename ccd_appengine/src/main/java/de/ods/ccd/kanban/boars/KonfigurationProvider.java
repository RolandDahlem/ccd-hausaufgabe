package de.ods.ccd.kanban.boars;

import java.util.ArrayList;
import java.util.List;

import de.ods.ccd.kanban.contracts.Board;
import de.ods.ccd.kanban.contracts.Spalte;
import de.ods.ccd.kanban.contracts.Zettel;

public class KonfigurationProvider {

	public Board erstelleLeeresBoard() {
		return erstelleBeispielboard();
	}

	private Board erstelleBeispielboard() {
		List<Spalte> spalten = new ArrayList<>();
		spalten.add(new Spalte("todo", -1));
		spalten.add(new Spalte("in Progress", 3));
		spalten.add(new Spalte("almost done", -1));
		spalten.add(new Spalte("done", -1));
		
		List<Zettel> listeZettel = new ArrayList<>();
		
		return new Board(spalten, listeZettel);
	}
}
