package de.ods.ccd.wordcount;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

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
		BufferedReader reader = erstelleReaderFuerString("Mary had a little lamb\n");
		wordCounterUI.berechne(reader);
		assertThat(display.getLetzteAusgabe(), is("Number of Words: 5"));
	}

	private BufferedReader erstelleReaderFuerString(String eingabe) throws UnsupportedEncodingException {
		InputStream inputstream = new ByteArrayInputStream(eingabe.getBytes(Charset.forName("UTF-8")));
		InputStreamReader reader = new InputStreamReader(inputstream, "UTF-8");
		BufferedReader bufferedReader = new BufferedReader(reader);
		return bufferedReader;
	}
	
}
