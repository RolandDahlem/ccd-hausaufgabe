package de.ods.ccd.loc;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class LocZaehlerTest {

	private LocZaehler locZaehler = new LocZaehler();
	
	@Test
	public void test_ob_die_lines_of_code_einer_datei_gezahlt_werden() throws Exception {
		ConsumerSpy gui = new ConsumerSpy();
		
		locZaehler.zaehleLinesOfCode("loc/eineDatei/", gui);
		
		assertThat(gui.getConsumed().get(0), containsString("Minenfeld.java gesamtzeilen=114, codezeilen=113"));
	}
	
	@Test
	public void test_ob_die_lines_of_code_in_einem_unterordner_gezaehlt_werden() throws Exception {
		ConsumerSpy gui = new ConsumerSpy();
		
		locZaehler.zaehleLinesOfCode("loc/dateienInUnterordnern/", gui);
		
		String letzteZeile = gui.getConsumed().get(gui.getConsumed().size() -1);
		assertThat(letzteZeile, containsString("gesamtzeilen=342, codezeilen=339"));
	}
	

	
	
	
	
}
