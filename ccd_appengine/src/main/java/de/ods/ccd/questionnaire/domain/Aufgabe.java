package de.ods.ccd.questionnaire.domain;

import java.util.ArrayList;
import java.util.List;

public class Aufgabe {

	private String frage;
	private List<String> antwortmoeglichkeiten = new ArrayList<String>();
	private int richtigeAntwort = -1;
	private int nutzerantwort = -1;
	
	public String getFrage() {
		return frage;
	}

	public void setFrage(String frage) {
		this.frage = frage;
	}

	public List<String> getAntwortmoeglichkeiten() {
		return antwortmoeglichkeiten;
	}


	public int getRichtigeAntwort() {
		return richtigeAntwort;
	}

	public void setRichtigeAntwort(int richtigeAntwort) {
		this.richtigeAntwort = richtigeAntwort;
	}

	public int getNutzerantwort() {
		return nutzerantwort;
	}

	public void setNutzerantwort(int nutzerantwort) {
		this.nutzerantwort = nutzerantwort;
	}

	public void ergaenzeAntwortmoeglichkeit(String zeile) {
		antwortmoeglichkeiten.add(zeile);
	}

}
