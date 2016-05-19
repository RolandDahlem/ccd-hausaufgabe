package de.ods.ccd.questionnaire;

import java.util.ArrayList;
import java.util.List;

import de.ods.ccd.questionnaire.domain.Aufgabe;

class AufgabenParser {

	private final List<String> zeilen;
	
	private List<Aufgabe> aufgaben = new ArrayList<>();
	private Aufgabe aktuelleAufgabe = null;
	
	public AufgabenParser(List<String> zeilen) {
		this.zeilen = zeilen;
	}

	public List<Aufgabe> parse() {
		for (int zeilennummer = 0; zeilennummer < zeilen.size(); zeilennummer++) {
			parseZeile(zeilennummer);
		}

		wechsleAufgabe();
		return aufgaben;
	}

	private void parseZeile(int zeilennummer) {
		String zeile = zeilen.get(zeilennummer);
		if (zeile.startsWith("?")) {
			wechsleAufgabe();
			aktuelleAufgabe.setFrage(fragezeichenAnsEndeSetzen(zeile));
		} else if (zeile.startsWith("*")) {
			aktuelleAufgabe.setRichtigeAntwortIndex(zeilennummer -1);
			aktuelleAufgabe.ergaenzeAntwortmoeglichkeit(zeile.substring(1));
		} else {
			aktuelleAufgabe.ergaenzeAntwortmoeglichkeit(zeile);
		}
	}

	private void wechsleAufgabe() {
		if(aktuelleAufgabe != null){
			aufgaben.add(aktuelleAufgabe);
		}
		aktuelleAufgabe = new Aufgabe();
	}

	private String fragezeichenAnsEndeSetzen(String zeile) {
		return zeile.substring(1) + "?";
	}

}
