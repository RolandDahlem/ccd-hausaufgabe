package de.ods.ccd.cvs;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class CVSTabelliererTest {

	CVSTabellierer tabellierer = new CVSTabellierer();
	
	@Test
	public void test_ob_richtig_tabelliert_wird() {
		
		
		List<String> csv = Arrays.asList(new String[]{"Name;Alter", "Peter;35"});
		List<String> formatierteZeilen = tabellierer.tabellieren(csv);
		
		assertThat(formatierteZeilen.size(), is(3));
		assertThat(formatierteZeilen.get(0), is("Name |Alter|"));
		assertThat(formatierteZeilen.get(1), is("-----|-----|"));
		assertThat(formatierteZeilen.get(2), is("Peter|35   |"));
	}
	
	@Test
	public void test_ob_daten_zerlegt_werden() {
		
		List<String> csv = Arrays.asList(new String[]{"Name;Alter", "Peter;35"});
		List<Datenzeile> datenzeilen = tabellierer.datenZerlegenInDatenzeilen(csv);
		
		assertThat(datenzeilen.size(), is(2));
		assertThat(datenzeilen.get(0).werte.size(), is(2));
		assertThat(datenzeilen.get(0).werte.get(0), is("Name"));
	}
	
	@Test
	public void test_ob_spaltenbreiten_ermittelt_werden() {
		
		List<Datenzeile> datenzeilen = new ArrayList<Datenzeile>();
		datenzeilen.add(new Datenzeile(new String[]{"Name", "Alter"}));
		datenzeilen.add(new Datenzeile(new String[]{"Peter", "35"}));
		
		List<Integer> spaltenbreiten = tabellierer.spaltenbreitenErmitteln(datenzeilen);
		
		assertThat(spaltenbreiten.size(), is(2));
		assertThat(spaltenbreiten.get(0), is("Peter".length()));
		assertThat(spaltenbreiten.get(1), is("Alter".length()));
	}
	
	@Test
	public void test_ob_die_tabellenausgabe_ermittelt_wird() {
		
		List<Datenzeile> datenzeilen = new ArrayList<Datenzeile>();
		datenzeilen.add(new Datenzeile(new String[]{"Name", "Alter"}));
		datenzeilen.add(new Datenzeile(new String[]{"Peter", "35"}));
		
		List<Integer> spaltenbreiten = new ArrayList<>();
		spaltenbreiten.add("Peter".length());
		spaltenbreiten.add("Alter".length());
		
		List<String> formatierteZeilen = tabellierer.tabellenAusgabeErstellen(datenzeilen, spaltenbreiten);
		
		assertThat(formatierteZeilen.size(), is(3));
		assertThat(formatierteZeilen.get(0), is("Name |Alter|"));
		assertThat(formatierteZeilen.get(1), is("-----|-----|"));
		assertThat(formatierteZeilen.get(2), is("Peter|35   |"));

	}
	

}
