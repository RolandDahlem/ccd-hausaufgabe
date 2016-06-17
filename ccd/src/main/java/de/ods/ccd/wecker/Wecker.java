package de.ods.ccd.wecker;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.function.Consumer;

import de.ods.ccd.wecker.uithread.Arbeiter;

public class Wecker implements Arbeiter {

	private static final Uhrzeit INVALIDE_WECKZEIT = null;

	public static class AktuelleZeitProvider {
		public long getAktuelleUhrzeit() {
			return System.currentTimeMillis();
		}
	}

	private Consumer<String> display;
	private Uhrzeit weckzeit = INVALIDE_WECKZEIT;
	private AktuelleZeitProvider aktuelleZeitProvider;

	public Wecker() {
		setAktuelleZeitProvider(new AktuelleZeitProvider());
	}

	public void setAktuelleZeitProvider(AktuelleZeitProvider aktuelleZeitProvider) {
		this.aktuelleZeitProvider = aktuelleZeitProvider;
	}

	@Override
	public void setDisplay(Consumer<String> display) {
		this.display = display;
	}

	@Override
	public void macheArbeit() {
		
		Uhrzeit jetzt = getAktuelleZeit();
		display.accept("Es ist " + jetzt + " Uhr");
		
		if (istWeckzeitValide()) {				
			String restzeit = weckzeit.formatiereVorsprungZu(jetzt);
			display.accept("Weckzeit " + weckzeit + " Restzeit " + restzeit);
		}
	}

	private boolean istWeckzeitValide() {
		if(weckzeit == INVALIDE_WECKZEIT){
			return false;
		}
		
		if(weckzeit.istFrueherAls(getAktuelleZeit())){
			return false;
		}
		return true;
	}

	@Override
	public void verarbeiteBenutzereingabe(BufferedReader br) throws IOException {
		this.weckzeit = leseWeckzeitEin(br);
	}

	private Uhrzeit leseWeckzeitEin(BufferedReader br) throws IOException {
		System.out.println("Bitte Weckzeit im Format HH:mm:ss (Bsp.: 15:15:15) eingeben: ");

		String weckzeitString = br.readLine();
		
		try{
			return new Uhrzeit(getAktuelleZeit(), weckzeitString);
		} catch (ParseException e) {
			display.accept("Falsches Format in '" + weckzeitString + "' Bitte HH:mm:ss benutzen (Bsp.: 15:15:15)");
			return INVALIDE_WECKZEIT;
		}
		
	}

	private Uhrzeit getAktuelleZeit() {
		return new Uhrzeit(aktuelleZeitProvider.getAktuelleUhrzeit());
	}

}
