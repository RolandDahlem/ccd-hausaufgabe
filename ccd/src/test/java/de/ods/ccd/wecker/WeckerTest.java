package de.ods.ccd.wecker;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
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
	private MockAlarm alarm;
	
	@Before
	public void weckerVorbereiten(){
		this.zeitProvider = new MockProvider();
		this.wecker = new Wecker();
		this.ui = new MockDisplay();
		this.alarm = new MockAlarm();
		wecker.setDisplay(ui);
		wecker.setAktuelleZeitProvider(zeitProvider);
		wecker.setAlarm(alarm);
		
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

		gibEin("16:30:00");
		wecker.macheArbeit();
		
		assertThat(ui.getLetzteAusgabe(), containsString("Weckzeit 16:30:00"));
	}

	@Test
	public void test_ob_die_restzeit_angezeit_wird() throws Exception {

		gibEin("15:15:20");
		wecker.macheArbeit();
		
		assertThat(ui.getLetzteAusgabe(), containsString("Restzeit 00:00:05"));
	}
	
	@Test
	public void test_ob_eine_abgelaufene_restzeit_nicht_mehr_angezeigt_wird() throws Exception {

		gibEin("15:15:10");
		wecker.macheArbeit();
		
		assertThat(ui.getLetzteAusgabe(), not(containsString("Restzeit")));
	}
	
	@Test
	public void test_ob_ein_alarm_ausgeloest_wird() throws Exception {

		gibEin("15:15:20");
		wecker.macheArbeit();
		
		assertThat(alarm.machtKrach, is(true));
	}
	
	private void gibEin(String eingabe) throws UnsupportedEncodingException, IOException {
		InputStream inputstream = new ByteArrayInputStream(eingabe.getBytes(Charset.forName("UTF-8")));
		InputStreamReader reader = new InputStreamReader(inputstream, "UTF-8");
		BufferedReader bufferedReader = new BufferedReader(reader);
		wecker.verarbeiteBenutzereingabe(bufferedReader);
	}

}
