package de.ods.ccd.questionnaire;

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
		
		List<Aufgabe> parseAufgaben = new AufgabenParser(zeilen).parse();
		
		return parseAufgaben;
	}

}
