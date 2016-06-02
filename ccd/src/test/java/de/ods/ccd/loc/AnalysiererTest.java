package de.ods.ccd.loc;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

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
	
	
	

}
