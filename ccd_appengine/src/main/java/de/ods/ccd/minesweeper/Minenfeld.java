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
		
		for(int i=0; i<minenfeld.length; i++){
			for(int j=0; j<minenfeld.length; j++){
				if(minenfeld[i][j] == MINE_VORHANDEN){
					// TODO: Nachbarminen anpassen
					// TODO: Abschließend Minen einsetzen
				}
				mogelfeld[i][j]=0;
			}
		}
		
		return mogelfeld.toString();
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
