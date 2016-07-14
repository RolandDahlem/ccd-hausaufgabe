package de.ods.ccd.wordcount;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import de.ods.ccd.wecker.MockDisplay;

public class WordCounterUITest {

	private WordCounterUI wordCounterUI = new WordCounterUI();
	private MockDisplay display;
	
	@Before
	public void weckerVorbereiten(){
		display = new MockDisplay();
		wordCounterUI.setDisplay(display);
	}
	
	@Test
	public void test_ob_woerter_von_einem_reader_eine_korrekt_ausgabe_hervorbringen() throws Exception {
		BufferedReader reader = erstelleReaderFuerString("Mary had little lamb\n");
		wordCounterUI.berechne(reader, new String[0]);
		assertThat(display.getLetzteAusgabe(), is("Number of Words: 4"));
	}

	@Test
	public void test_ob_stoppwoerter_beachted_werden() throws Exception {
		BufferedReader reader = erstelleReaderFuerString("Mary had a little lamb\n");
		wordCounterUI.berechne(reader, new String[0]);
		assertThat(display.getLetzteAusgabe(), is("Number of Words: 4"));
	}
	
	@Test
	public void test_ob_lesen_von_datei_geht() throws Exception {
		wordCounterUI.berechne(null, new String[]{"mytext.txt"});
		assertThat(display.getLetzteAusgabe(), is("Number of Words: 4"));
	}

			
	private BufferedReader erstelleReaderFuerString(String eingabe) throws UnsupportedEncodingException {
		InputStream inputstream = new ByteArrayInputStream(eingabe.getBytes(Charset.forName("UTF-8")));
		InputStreamReader reader = new InputStreamReader(inputstream, "UTF-8");
		BufferedReader bufferedReader = new BufferedReader(reader);
		return bufferedReader;
	}
	
}
