package de.ods.ccd.russischebauern;

public class Multiplikator {

	public int mult(int i, int j) {
		Tabelle tabelle = new Tabelle(i, j);
		return tabelle.auswerten();
	}

}
