package de.ods.ccd.kanban.contracts;

import java.util.List;

public class Board {
	private List<Spalte> spalten;
	private List<Zettel> listeZettel;

	public Board(List<Spalte> spalten, List<Zettel> listeZettel) {
		this.spalten = spalten;
		this.listeZettel = listeZettel;
	}

	public List<Spalte> getSpalten() {
		return spalten;
	}

	public List<Zettel> getListeZettel() {
		return listeZettel;
	}

}
