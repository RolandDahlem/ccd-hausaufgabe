package de.ods.ccd.loc;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class LocZaehlerTest {

	private LocZaehler locZaehler = new LocZaehler();
	
	@Test
	public void test_ob_die_lines_of_code_einer_datei_gezahlt_werden() throws Exception {
		ConsumerSpy consumerSpy = new ConsumerSpy();
		
		locZaehler.zaehleLinesOfCode("loc/eineDatei/", consumerSpy);
		
		assertThat(consumerSpy.getConsumed().get(0), containsString("Minenfeld.java"));
	}
	
	@Test
	public void test_ob_eine_datei_analysiert_wird() throws Exception {
		
		String dateiPfad = new FileProvider().ermittleDateinamen("loc/eineDatei/Minenfeld.java");		
		Einzelergebnis einzelergebnis = locZaehler.analysiereDatei(dateiPfad);
		
		assertThat(einzelergebnis.getGesamtzeilen(), is(112));
	}
	
	
	
	
}
