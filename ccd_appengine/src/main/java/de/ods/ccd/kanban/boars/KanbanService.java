package de.ods.ccd.kanban.boars;

import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import de.ods.ccd.kanban.contracts.Board;
import de.ods.ccd.kanban.contracts.Zettel;

@Service
public class KanbanService {

	private DatenbankProvider datenbankProvider = new DatenbankProvider();
	private KonfigurationProvider konfigurationProvider = new KonfigurationProvider();
	
	@PostConstruct
	public void init() {
		Board board = konfigurationProvider.erstelleLeeresBoard();
		datenbankProvider.speichere(board);
	}
	
	public Board getBoard() {
		return datenbankProvider.getBoard();
	}

	public void neuerZettel() {
		Zettel zettel = new Zettel(UUID.randomUUID());
		zettel.setPosition(datenbankProvider.getBoard().getListeZettel().size());
		
		datenbankProvider.getBoard().getListeZettel().add(zettel);
	}
	
}
