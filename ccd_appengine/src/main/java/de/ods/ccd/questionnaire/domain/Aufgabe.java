package de.ods.ccd.questionnaire.domain;

import java.util.ArrayList;
import java.util.List;

public class Aufgabe {

	private String frage;
	private List<String> antwortmoeglichkeiten = new ArrayList<String>();
	private String richtigeAntwort = "";
	private String nutzerantwort = "";
	
	public String getFrage() {
		return frage;
	}

	public void setFrage(String frage) {
		this.frage = frage;
	}

	public List<String> getAntwortmoeglichkeiten() {
		return antwortmoeglichkeiten;
	}


	public String getRichtigeAntwort() {
		return richtigeAntwort;
	}

	public void setRichtigeAntwort(String richtigeAntwort) {
		this.richtigeAntwort = richtigeAntwort;
	}

	public String getNutzerantwort() {
		return nutzerantwort;
	}

	public void setNutzerantwort(String nutzerantwort) {
		this.nutzerantwort = nutzerantwort;
	}

	public void ergaenzeAntwortmoeglichkeit(String zeile) {
		antwortmoeglichkeiten.add(zeile);
	}

	@Override
	public String toString() {
		return frage;
	}
}
