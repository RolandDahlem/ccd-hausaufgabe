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
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.junit.Before;
import org.junit.Test;

public class WeckerTest {

	private static class MockDisplay implements Consumer<String>{

		private List<String> ausgabe = new ArrayList<>();
		
		@Override
		public void accept(String zeile) {
			System.out.println(zeile);
			ausgabe.add(zeile);
		}

//		public List<String> getAusgabe() {
//			return ausgabe;
//		}

		public String getLetzteAusgabe() {
			return ausgabe.get(ausgabe.size() -1);
		}
		
	}

	private MockDisplay ui;
	private Wecker wecker;
	
	@Before
	public void weckerVorbereiten(){
		this.ui = new MockDisplay();
		this.wecker = new Wecker();
		wecker.setDisplay(ui);
	}
	
	@Test
	public void test_ob_die_weckzeit_gespeichert_werden_kann() throws Exception {

		gibEin("9:30");
		wecker.macheArbeit();
		
		assertThat(ui.getLetzteAusgabe(), is("Weckzeit 9:30"));
	}

	private void gibEin(String eingabe) throws UnsupportedEncodingException, IOException {
		InputStream inputstream = new ByteArrayInputStream(eingabe.getBytes(Charset.forName("UTF-8")));
		InputStreamReader reader = new InputStreamReader(inputstream, "UTF-8");
		BufferedReader bufferedReader = new BufferedReader(reader);
		wecker.verarbeiteBenutzereingabe(bufferedReader);
	}

}
