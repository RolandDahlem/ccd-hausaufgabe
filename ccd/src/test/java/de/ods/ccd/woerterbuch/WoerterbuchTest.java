package de.ods.ccd.woerterbuch;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class WoerterbuchTest {

	private String toDictionaryString(String input) {
		return Woerterbuch.toDictionary(input).toString();
	}
	
	@Test
	public void test_ob_mehrfache_eintraege_konvertiert_werden_koennen() {
		assertThat(toDictionaryString("a=1;b=2;c=3"), is("{a=1, b=2, c=3}"));
	}

	@Test
	public void test_ob_istgleich_auch_value_sein_kann() {
		assertThat(toDictionaryString("a==1"), is("{a==1}"));
	}
	

	@Test
	public void test_ob_leerer_wert_ignoriert_wird() {
		assertThat(toDictionaryString("a=1;;b=2"), is("{a=1, b=2}"));
	}
	

	@Test(expected=RuntimeException.class)
	public void test_ob_benutzerfehler_zu_exceptions_fuehren() {
		toDictionaryString("=1");
	}
	
	@Test
	public void test_ob_leerer_value_erlaubt_ist() {
		assertThat(toDictionaryString("a="), is("{a=}"));
	}
	
	@Test
	public void test_grenzfall_leer() {
		assertThat(toDictionaryString(""), is("{}"));
	}
	
	@Test(expected=RuntimeException.class)
	public void test_grenzfall_null() {
		toDictionaryString(null);
	}
}
