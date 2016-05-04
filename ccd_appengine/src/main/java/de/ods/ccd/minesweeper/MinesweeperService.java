package de.ods.ccd.minesweeper;

import org.springframework.stereotype.Service;

@Service
public class MinesweeperService {

	public String erzeugeMogelzettel(String minenfeld_raw) {
		
		Minenfeld minenfeld = new Minenfeld(minenfeld_raw);
		
		return minenfeld.loesen();
	} 

}
