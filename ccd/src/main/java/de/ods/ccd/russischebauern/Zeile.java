package de.ods.ccd.russischebauern;

class Zeile{
	
	int i,j;
	
	public Zeile(int i, int j) {
		this.i = i;
		this.j = j;
	}

	public Zeile naechsteZeile() {
		return new Zeile(i >> 1, j << 1);
	}

	@Override
	public String toString() {
		return "Zeile [i=" + i + ", j=" + j + "]";
	}

}
