package de.ods.ccd_gui.textumbruch;

import java.util.StringTokenizer;

class Umbrecher {

	private StringTokenizer tokenizer;
	private int maximalbreite;

	private String aktuelleZeile;
	private int startIndex = 0;
	private int endIndex;
	
	private StringBuilder result = new StringBuilder();

	public Umbrecher(String umbruchstext, int maximalbreite) {
		this.tokenizer = new StringTokenizer(umbruchstext, "\n");
		this.maximalbreite = maximalbreite;
	}

	public String umbrechen() {

		while(tokenizer.hasMoreTokens()){
			haengeZeileAn();
		}
		
		return result.toString();
	}

	private void haengeZeileAn() {
		this.aktuelleZeile = tokenizer.nextToken();
		startIndex = 0;
		
		while (startIndex + maximalbreite < aktuelleZeile.length()) {
			heangeNaechstenAbschnittAn();
		}

		heangeRestAn();
	}

	private void heangeNaechstenAbschnittAn() {
		endIndex = getEndeIndex();
		result.append(aktuelleZeile.substring(startIndex, endIndex));
		if (endIndex < aktuelleZeile.length()) {
			result.append("\n");
		}
		startIndex = endIndex + 1;
	}

	private int getEndeIndex() {
		for (int i = maximalbreite + startIndex; i > startIndex; i--) {
			char zeichen = aktuelleZeile.charAt(i);
			if (zeichen == ' ') {
				return i;
			}
		}

		return behandleZuLangeWorter();
	}

	private int behandleZuLangeWorter() {
		for (int i = maximalbreite + startIndex; i < aktuelleZeile.length(); i++) {
			char zeichen = aktuelleZeile.charAt(i);
			if (zeichen == ' ') {
				return i;
			}
		}

		return aktuelleZeile.length();
	}

	private void heangeRestAn() {
		if (startIndex < aktuelleZeile.length()) {
			String rest = aktuelleZeile.substring(startIndex);
			result.append(rest);
		}
		
		if(tokenizer.hasMoreTokens()){
			result.append("\n");
		}
	}

}
