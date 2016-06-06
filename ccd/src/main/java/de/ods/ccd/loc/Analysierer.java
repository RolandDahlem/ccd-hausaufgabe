package de.ods.ccd.loc;

import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

public class Analysierer {

	private FileProvider fileProvider = new FileProvider();
	
	public Einzelergebnis analysiereDatei(String dateiname) throws IOException {
		
		List<String> zeilen = fileProvider.leseZeilen(dateiname);
		
		Einzelergebnis ergebnis = new Einzelergebnis();
		ergebnis.setGesamtzeilen(zeilen.size());
		ergebnis.setCodezeilen(zeahleCodezeilen(zeilen));
		
		return ergebnis;
	}

	private int zeahleCodezeilen(List<String> zeilen) {
		int codezeilen = 0;
		for (String zeile : zeilen) {
			if(isKommentarzeile(zeile) == false){
				codezeilen++;
			}
		}
		return codezeilen;
	}

	boolean isKommentarzeile(String zeile) {
		return Pattern.matches("[ \t]*//.*", zeile);
	}

	public Einzelergebnis agreggiere(List<Einzelergebnis> ergebnisse) {
		
		int gesamtZeilen = 0;
		int codeZeilen = 0;
		for (Einzelergebnis einzelergebnis : ergebnisse) {
			gesamtZeilen += einzelergebnis.getGesamtzeilen();
			codeZeilen += einzelergebnis.getCodezeilen();
		}
		
		Einzelergebnis ergebnis = new Einzelergebnis();
		ergebnis.setGesamtzeilen(gesamtZeilen);
		ergebnis.setCodezeilen(codeZeilen);
		
		return ergebnis;
	}

}
