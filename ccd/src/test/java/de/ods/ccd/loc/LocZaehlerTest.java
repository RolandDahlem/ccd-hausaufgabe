package de.ods.ccd.loc;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.endsWith;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

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
		
		List<String> guiZeilen = consumerSpy.getConsumed();
		
		String letzteZeile = guiZeilen.get(guiZeilen.size() -1);

		assertThat(letzteZeile, containsString("gesamtzeilen=342, codezeilen=339"));
	}
	

	
	
	
	
}
