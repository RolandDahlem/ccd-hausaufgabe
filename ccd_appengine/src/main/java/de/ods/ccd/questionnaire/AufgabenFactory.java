package de.ods.ccd.questionnaire;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import de.ods.ccd.questionnaire.domain.Aufgabe;

@Service
public class AufgabenFactory {

	List<Aufgabe> ergeanzeWeissNicht(List<Aufgabe> aufgaben) {
		for (Aufgabe aufgabe : aufgaben) {
			aufgabe.ergaenzeAntwortmoeglichkeit("Weiß nicht");
		}
		return aufgaben;
	}

	List<Aufgabe> erstelleAufgaben(List<String> zeilen) {
		List<Aufgabe> parseAufgaben = parseAufgaben(zeilen);
		
		return parseAufgaben;
	}

	private List<Aufgabe> parseAufgaben(List<String> zeilen) {
		List<Aufgabe> aufgaben = new ArrayList<>();

		Aufgabe aktuelleAufgabe = null;
		for (int zeilennummer = 0; zeilennummer < zeilen.size(); zeilennummer++) {
			String zeile = zeilen.get(zeilennummer);
			if (zeile.startsWith("?")) {
				if(aktuelleAufgabe != null){
					aufgaben.add(aktuelleAufgabe);
				}
				aktuelleAufgabe = new Aufgabe();
				
				aktuelleAufgabe.setFrage(fragezeichenAnsEndeSetzen(zeile));
			} else if (zeile.startsWith("*")) {
				aktuelleAufgabe.setRichtigeAntwortIndex(zeilennummer -1);
				aktuelleAufgabe.ergaenzeAntwortmoeglichkeit(zeile.substring(1));
			} else {
				aktuelleAufgabe.ergaenzeAntwortmoeglichkeit(zeile);
			}
		}

		if(aktuelleAufgabe != null){
			aufgaben.add(aktuelleAufgabe);
		}
		
		return aufgaben;
	}

	private String fragezeichenAnsEndeSetzen(String zeile) {
		return zeile.substring(1) + "?";
	}

}
