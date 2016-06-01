package de.ods.ccd.questionnaire.domain;

import java.util.ArrayList;
import java.util.List;

public class Fragebogen {

	private List<Aufgabe> aufgaben = new ArrayList<>();

	public List<Aufgabe> getAufgaben() {
		return aufgaben;
	}

	public void setAufgaben(List<Aufgabe> aufgaben) {
		this.aufgaben = aufgaben;
	}
	
}
