package de.ods.ccd.kanban.contracts;

public class Spalte {
	private String ueberschrift;
	private int wipLimit;

	public Spalte(String ueberschrift, int wipLimit) {
		this.ueberschrift = ueberschrift;
		this.wipLimit = wipLimit;
	}

	public String getUeberschrift() {
		return ueberschrift;
	}

	public int getWipLimit() {
		return wipLimit;
	}

}
