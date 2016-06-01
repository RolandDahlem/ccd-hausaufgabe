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
	
	@Override
	public String toString() {
		return aufgaben.toString();
	}

	public void ergaenzeNutzerantworten(Fragebogen antwortbogen) {
		
		for(int i=0; i< antwortbogen.getAufgaben().size(); i++){
			String nutzerantwort = antwortbogen.getAufgaben().get(i).getNutzerantwort();
			aufgaben.get(i).setNutzerantwort(nutzerantwort);
		}

	}
}
