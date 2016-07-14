package de.ods.ccd.kanban.boars;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import de.ods.ccd.kanban.contracts.Board;
import de.ods.ccd.kanban.contracts.Spalte;
import de.ods.ccd.kanban.contracts.Zettel;

@Service
public class KanbanService {

	private Board board;
	
	@PostConstruct
	public void init() {
		board = erstelleBeispielboard();
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

	public Board getBoard() {
		return board;
	}

	public void neuerZettel() {

		Zettel zettel = new Zettel(UUID.randomUUID());
		zettel.setPosition(getBoard().getListeZettel().size());
		
		getBoard().getListeZettel().add(zettel);
	}
	
}
