package de.ods.ccd.loc;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.endsWith;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class LocZaehlerTest {

	private LocZaehler locZaehler = new LocZaehler();
	
	@Test
	public void test_ob_die_lines_of_code_einer_datei_gezahlt_werden() throws Exception {
		ConsumerSpy consumerSpy = new ConsumerSpy();
		
		locZaehler.zaehleLinesOfCode("loc/eineDatei/", consumerSpy);
		
		assertThat(consumerSpy.getConsumed().get(0), containsString("Minenfeld.java gesamtzeilen=114, codezeilen=113"));
	}
	
	@Test
	public void test_ob_die_lines_of_code_in_einem_unterordner_gezaehlt_werden() throws Exception {
		ConsumerSpy consumerSpy = new ConsumerSpy();
		
		locZaehler.zaehleLinesOfCode("loc/dateienInUnterordnern/", consumerSpy);
		
		assertThat(consumerSpy.getConsumed().get(0), containsString("Oben.java gesamtzeilen=114, codezeilen=113"));
		assertThat(consumerSpy.getConsumed().get(1), containsString("Unten1.java gesamtzeilen=114, codezeilen=113"));
	}
}
