package de.ods.ccd.questionnaire.domain;

import java.util.ArrayList;
import java.util.List;

public class Aufgabe {

	private String frage;
	private List<String> antwortmoeglichkeiten = new ArrayList<String>();
	private int richtigeAntwortIndex = -1;
	private int nutzerantwortIndex = -1;
	
	public String getFrage() {
		return frage;
	}

	public void setFrage(String frage) {
		this.frage = frage;
	}

	public List<String> getAntwortmoeglichkeiten() {
		return antwortmoeglichkeiten;
	}


	public int getRichtigeAntwortIndex() {
		return richtigeAntwortIndex;
	}

	public void setRichtigeAntwortIndex(int richtigeAntwort) {
		this.richtigeAntwortIndex = richtigeAntwort;
	}

	public int getNutzerantwortIndex() {
		return nutzerantwortIndex;
	}

	public void setNutzerantwortIndex(int nutzerantwort) {
		this.nutzerantwortIndex = nutzerantwort;
	}

	public void ergaenzeAntwortmoeglichkeit(String zeile) {
		antwortmoeglichkeiten.add(zeile);
	}

	public String getRichtigeAntwort() {
		return antwortmoeglichkeiten.get(getRichtigeAntwortIndex());
	}

	@Override
	public String toString() {
		return frage;
	}
}
