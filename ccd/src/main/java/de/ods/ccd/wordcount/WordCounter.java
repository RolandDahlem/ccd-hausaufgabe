package de.ods.ccd.wordcount;

import java.util.ArrayList;
import java.util.List;

public class WordCounter {

	private List<String> stoppwoerter = new ArrayList<>();

	public int countWords(String satz) {
		
		List<String> woerter = parseWoerter(satz);
		woerter.removeAll(stoppwoerter);
		return woerter.size();
	}

	private List<String> parseWoerter(String satz) {
		List<String> woerter = new ArrayList<>();
		
		StringBuilder letztesWort = new StringBuilder();
		for(int i=0; i<satz.length(); i++){
			char zeichen = satz.charAt(i);
			if(Character.isAlphabetic(zeichen)){
				letztesWort.append(zeichen);
			} else {
				letztesWort = haengeWortAn(woerter, letztesWort);
			}
		}
		
		haengeWortAn(woerter, letztesWort);
		return woerter;
	}

	private StringBuilder haengeWortAn(List<String> woerter, StringBuilder letztesWort) {
		if(letztesWort.length() != 0){
			woerter.add(letztesWort.toString());
			letztesWort = new StringBuilder();
		} else {
			// z.B: 2 Leerezeichen hintereinander
		}
		return letztesWort;
	}

	public void setStoppwoerter(List<String> stoppwoerter) {
		this.stoppwoerter = stoppwoerter;		
	}

}
