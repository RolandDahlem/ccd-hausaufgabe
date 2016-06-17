package de.ods.ccd.wecker;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.junit.Before;
import org.junit.Test;

public class WeckerTest {

	private MockDisplay ui;
	private Wecker wecker;
	private MockProvider zeitProvider;
	
	@Before
	public void weckerVorbereiten(){
		this.zeitProvider = new MockProvider();
		this.ui = new MockDisplay();
		this.wecker = new Wecker();
		wecker.setDisplay(ui);
		wecker.setAktuelleZeitProvider(zeitProvider);
		
		Calendar calendar = new GregorianCalendar(Locale.GERMAN);
		calendar.set(Calendar.HOUR_OF_DAY, 15);
		calendar.set(Calendar.MINUTE, 15);
		calendar.set(Calendar.SECOND, 15);
		zeitProvider.setZeit(calendar.getTimeInMillis());
	}
	
	@Test
	public void test_ob_die_aktuelle_uhrzeit_ausgegeben_wird() throws Exception {
		wecker.macheArbeit();
		
		assertThat(ui.getLetzteAusgabe(), is("Es ist 15:15:15 Uhr"));
	}
	
	@Test
	public void test_ob_die_weckzeit_gespeichert_werden_kann() throws Exception {

		gibEin("9:30:00");
		wecker.macheArbeit();
		
		assertThat(ui.getLetzteAusgabe(), containsString("Weckzeit 09:30:00"));
	}

	@Test
	public void test_ob_die_restzeit_angezeit_wird() throws Exception {

		gibEin("15:15:20");
		wecker.macheArbeit();
		
		assertThat(ui.getLetzteAusgabe(), containsString("Restzeit 0:05"));
	}
	
	private void gibEin(String eingabe) throws UnsupportedEncodingException, IOException {
		InputStream inputstream = new ByteArrayInputStream(eingabe.getBytes(Charset.forName("UTF-8")));
		InputStreamReader reader = new InputStreamReader(inputstream, "UTF-8");
		BufferedReader bufferedReader = new BufferedReader(reader);
		wecker.verarbeiteBenutzereingabe(bufferedReader);
	}

}
