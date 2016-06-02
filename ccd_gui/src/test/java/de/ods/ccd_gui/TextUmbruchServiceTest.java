package de.ods.ccd_gui;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

import de.ods.ccd_gui.textumbruch.TextUmbruchService;

public class TextUmbruchServiceTest {

	TextUmbruchService service = new TextUmbruchService();
	
	@Test
	public void test_ob_umgebrochen_wird() {
		
		String umbruchstext = "Er fragte, wohin gehen wir.";
		int maximalbreite = 9;
		
		String ergebnis = service.umbrechen(umbruchstext, maximalbreite);
		
		assertThat(ergebnis, is("Er\nfragte,\nwohin\ngehen\nwir."));
	}
		
	@Test
	public void test_ob_zu_grosse_woerter_probleme_machen() {
		
		String umbruchstext = "Donaudampfschiffartskapiaensmuetzenfarbe ist blau";
		int maximalbreite = 9;
		
		String ergebnis = service.umbrechen(umbruchstext, maximalbreite);
		
		assertThat(ergebnis, is("Donaudampfschiffartskapiaensmuetzenfarbe\nist blau"));
	}

	@Test
	public void test_ob_zu_grosse_woerter_am_textende_probleme_machen() {
		
		String umbruchstext = "Donaudampfschiffartskapiaensmuetze";
		int maximalbreite = 9;
		
		String ergebnis = service.umbrechen(umbruchstext, maximalbreite);
		
		assertThat(ergebnis, is("Donaudampfschiffartskapiaensmuetze"));
	}
	
	@Test
	public void test_ob_abseatze_erhalten_bleiben() {
		
		String umbruchstext = "yo lo\nyolo";
		int maximalbreite = 9;
		
		String ergebnis = service.umbrechen(umbruchstext, maximalbreite);
		
		assertThat(ergebnis, is("yo lo\nyolo"));
	}

	@Test
	public void test_ob_grenzfaelle_passen() {
		
		String umbruchstext = "Er fragte,\nwohin";
		int maximalbreite = 10;
		
		String ergebnis = service.umbrechen(umbruchstext, maximalbreite);
		
		assertThat(ergebnis, is("Er fragte,\nwohin"));
	}
	
	@Test
	public void test_ob_grenzfaelle_in_der_naechsten_zeile_passen() {
		
		String umbruchstext = "Er fragte,\nwohin gehen\n";
		int maximalbreite = 11;
		
		String ergebnis = service.umbrechen(umbruchstext, maximalbreite);
		
		assertThat(ergebnis, is("Er fragte,\nwohin gehen\n"));
	}
	

	
}
