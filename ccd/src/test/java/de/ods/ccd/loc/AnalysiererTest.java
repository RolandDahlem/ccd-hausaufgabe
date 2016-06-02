package de.ods.ccd.loc;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class AnalysiererTest {

	private Analysierer analysierer = new Analysierer();
	
	@Test
	public void test_ob_eine_datei_analysiert_wird() throws Exception {
		
		String dateiPfad = new FileProvider().ermittleDateinamen("loc/eineDatei/Minenfeld.java");		
		Einzelergebnis einzelergebnis = analysierer.analysiereDatei(dateiPfad);
		
		assertThat(einzelergebnis.getGesamtzeilen(), is(114));
		assertThat(einzelergebnis.getCodezeilen(), is(113));
	}
	
	@Test
	public void test_ob_eine_kommentarzeile_erkannt_wird() throws Exception {

		assertThat(analysierer.isKommentarzeile("     "), is(false));
		assertThat(analysierer.isKommentarzeile("//"), is(true));
		assertThat(analysierer.isKommentarzeile("         //"), is(true));
		assertThat(analysierer.isKommentarzeile("		// Ich bin ein Kommentar"), is(true));
	}
	
	@Test
	public void test_ob_korrekt_aggregiert_wird() throws Exception {
		
		List<Einzelergebnis> ergebnisse = new ArrayList<Einzelergebnis>();
		
		Einzelergebnis erg1 = new Einzelergebnis();
		erg1.setGesamtzeilen(111);
		erg1.setCodezeilen(100);
		ergebnisse.add(erg1);
		
		Einzelergebnis erg2 = new Einzelergebnis();
		erg2.setGesamtzeilen(1111);
		erg2.setCodezeilen(1000);
		ergebnisse.add(erg2);
		
		Einzelergebnis ergebnis = analysierer.agreggiere(ergebnisse);
		
		assertThat(ergebnis.getGesamtzeilen(), is(1222));
		assertThat(ergebnis.getCodezeilen(), is(1100));
	}
	
	
	

}
