package de.ods.ccd.cvs;

import java.util.ArrayList;
import java.util.List;

public class CVSTabellierer {

	public List<String> tabellieren(List<String> csv) {

		List<Datenzeile> datenzeilen = datenZerlegenInDatenzeilen(csv);
		List<Integer> spaltenbreiten = spaltenbreitenErmitteln(datenzeilen);
		List<String> formatierteZeilen = tabellenAusgabeErstellen(datenzeilen, spaltenbreiten);

		return formatierteZeilen;
	}

	List<Datenzeile> datenZerlegenInDatenzeilen(List<String> csv) {

		List<Datenzeile> datenzeilen = new ArrayList<Datenzeile>();

		for (String zeile : csv) {
			String[] werte = zeile.split(";");
			datenzeilen.add(new Datenzeile(werte));
		}

		return datenzeilen;
	}

	List<Integer> spaltenbreitenErmitteln(List<Datenzeile> datenzeilen) {

		int spaltenAnzahl = datenzeilen.get(0).werte.size();

		List<Integer> spaltenbreiten = new ArrayList<>();

		for (int spaltenIndex = 0; spaltenIndex < spaltenAnzahl; spaltenIndex++) {
			int maxBreite = ermittleBreiteEinerSpalte(datenzeilen, spaltenIndex);
			spaltenbreiten.add(maxBreite);
		}

		return spaltenbreiten;
	}

	private int ermittleBreiteEinerSpalte(List<Datenzeile> datenzeilen, int spaltenIndex) {
		int maxBreite = 0;
		for (Datenzeile datenzeile : datenzeilen) {
			int breite = datenzeile.werte.get(spaltenIndex).length();
			if (breite > maxBreite) {
				maxBreite = breite;
			}
		}
		return maxBreite;
	}

	List<String> tabellenAusgabeErstellen(List<Datenzeile> datenzeilen, List<Integer> spaltenbreiten) {
		
		List<String> formatierteZeilen = new ArrayList<String>();
		
		ergeanzeDatenZeilen(datenzeilen, spaltenbreiten, formatierteZeilen);
		ergeanzeFormatierungszeile(spaltenbreiten, formatierteZeilen);
				
		return formatierteZeilen;
	}

	private void ergeanzeDatenZeilen(List<Datenzeile> datenzeilen, List<Integer> spaltenbreiten, List<String> formatierteZeilen) {
		for(int zeilenindex=0; zeilenindex<datenzeilen.size(); zeilenindex++ ){
			Datenzeile datenzeile = datenzeilen.get(zeilenindex);
			
			StringBuilder builder = new StringBuilder();
			for(int spaltenIndex=0; spaltenIndex<spaltenbreiten.size(); spaltenIndex++){
				Integer spaltenbreite = spaltenbreiten.get(spaltenIndex);
				String zellenWert = datenzeile.werte.get(spaltenIndex);
				String zelle = fuelleZelleAuf(zellenWert, spaltenbreite, " ");
				builder.append(zelle);
			}
			
			formatierteZeilen.add(builder.toString());
		}
	}

	private void ergeanzeFormatierungszeile(List<Integer> spaltenbreiten, List<String> formatierteZeilen) {
		StringBuilder builder = new StringBuilder();
		for(int spaltenIndex=0; spaltenIndex<spaltenbreiten.size(); spaltenIndex++){
			Integer spaltenbreite = spaltenbreiten.get(spaltenIndex);
			String zelle = fuelleZelleAuf("", spaltenbreite, "-");
			builder.append(zelle);
		}
		
		formatierteZeilen.add(1, builder.toString());
	}
		
	private String fuelleZelleAuf(String zellenWert, Integer spaltenbreite, String fuellZeichen) {
		StringBuilder builder = new StringBuilder();
		builder.append(zellenWert);
		while(builder.length() < spaltenbreite){
			builder.append(fuellZeichen);
		}
		
		builder.append("|");
		
		return builder.toString();
	}

}
