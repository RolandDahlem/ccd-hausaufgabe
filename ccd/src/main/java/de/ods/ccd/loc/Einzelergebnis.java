package de.ods.ccd.loc;

public class Einzelergebnis {

	private int gesamtzeilen;
	private int codezeilen;
	private int standardabweichung;

	public int getGesamtzeilen() {
		return gesamtzeilen;
	}

	public void setGesamtzeilen(int gesamtzeilen) {
		this.gesamtzeilen = gesamtzeilen;
	}

	public int getCodezeilen() {
		return codezeilen;
	}

	public void setCodezeilen(int codezeilen) {
		this.codezeilen = codezeilen;
	}

	public int getStandardabweichung() {
		return standardabweichung;
	}

	public void setStandardabweichung(int standardabweichung) {
		this.standardabweichung = standardabweichung;
	}

	@Override
	public String toString() {
		return "gesamtzeilen=" + gesamtzeilen + ", codezeilen=" + codezeilen + ", standardabweichung="
				+ standardabweichung;
	}

}
