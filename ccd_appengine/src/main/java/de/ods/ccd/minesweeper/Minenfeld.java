package de.ods.ccd.minesweeper;

import java.util.StringTokenizer;

class Minenfeld {

	static final char KEINE_MINE = '.';
	static final char MINE_VORHANDEN = '*';
	
	char[][] minenfeld;


	public Minenfeld(String minenfeld_raw) {
		this.minenfeld = erzeugeMinenfeld(minenfeld_raw);		
	}

	static char[][] erzeugeMinenfeld(String minenfeld_raw) {
		int spaltenanzahl = minenfeld_raw.indexOf("\n");
		char[][] minenfeld = new char[spaltenanzahl][spaltenanzahl];
		
		StringTokenizer tokenizer = new StringTokenizer(minenfeld_raw, "\n");

		int zeilenindex = 0;
		while(tokenizer.hasMoreTokens()){
			String zeile = tokenizer.nextToken();
			
			for(int i=0; i<spaltenanzahl; i++){
				minenfeld[zeilenindex][i] = zeile.charAt(i);
			}
			
			zeilenindex++;
		}

		return minenfeld;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		for (char[] cs : minenfeld) {
			for (char c : cs) {
				builder.append(c);
			}
			
			builder.append("\n");
		}
		return builder.toString();
	}
	
	public String loesen() {
		
		int[][] mogelfeld = initialisiereFeld();
		loeseFeld(mogelfeld);
		return feld2String(mogelfeld);
	}

	private String feld2String(int[][] mogelfeld) {
		
		StringBuilder builder = new StringBuilder();
		
		for(int i=0; i<mogelfeld.length; i++){
			for(int j=0; j<mogelfeld.length; j++){
				if(this.minenfeld[i][j] == MINE_VORHANDEN){
					builder.append(MINE_VORHANDEN);
				} else {
					builder.append(mogelfeld[i][j]);
				}
			}
			if(i < mogelfeld.length-1){
				builder.append("\n");
			}
		}

		return builder.toString();
	}

	private void loeseFeld(int[][] mogelfeld) {
		for(int i=0; i<minenfeld.length; i++){
			for(int j=0; j<minenfeld.length; j++){
				if(minenfeld[i][j] == MINE_VORHANDEN){
					aktualisiereFeldMitMine(mogelfeld, i, j);
				}
			}
		}
	}

	private void aktualisiereFeldMitMine(int[][] mogelfeld, int mineX, int mineY) {		
		for (int deltaX=-1; deltaX<=+1; deltaX++) {
			for (int deltaY=-1; deltaY<=+1; deltaY++) {
				
				int x = mineX+deltaX;
				int y = mineY+deltaY;
				
				if(x >= 0 && x < mogelfeld.length && y >= 0 && y < mogelfeld.length){
					mogelfeld[x][y]++;
				}
			}
		}
	}

	private int[][] initialisiereFeld() {
		int[][] mogelfeld = new int[minenfeld.length][minenfeld.length];
		
		for(int i=0; i<minenfeld.length; i++){
			for(int j=0; j<minenfeld.length; j++){
				mogelfeld[i][j]=0;
			}
		}
		return mogelfeld;
	}

}
