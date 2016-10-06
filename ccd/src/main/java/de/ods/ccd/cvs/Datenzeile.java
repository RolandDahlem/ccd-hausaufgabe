package de.ods.ccd.cvs;

import java.util.Arrays;
import java.util.List;

class Datenzeile {
	List<String> werte;

	public Datenzeile(String[] werte) {
		this.werte = Arrays.asList(werte);
	}
}
