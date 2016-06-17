package de.ods.ccd.wecker;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.function.Consumer;

import de.ods.ccd.wecker.uithread.Arbeiter;

public class Wecker implements Arbeiter {

	private static final long INVALIDE_WECKZEIT = -1;

	public static class AktuelleZeitProvider {
		public long getAktuelleUhrzeit() {
			return System.currentTimeMillis();
		}
	}

	private Consumer<String> display;
	private long weckzeit = INVALIDE_WECKZEIT;
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
		SimpleDateFormat zeitformater = new SimpleDateFormat("HH:mm:ss");
		String uhrzeit = zeitformater.format(new Date(aktuelleZeitProvider.getAktuelleUhrzeit()));
		display.accept("Es ist " + uhrzeit + " Uhr");
		if (weckzeit != INVALIDE_WECKZEIT) {
			display.accept("Weckzeit " + zeitformater.format(weckzeit));
		}

	}

	@Override
	public void verarbeiteBenutzereingabe(BufferedReader br) throws IOException {
		this.weckzeit = leseWeckzeitEin(br);
	}

	private long leseWeckzeitEin(BufferedReader br) throws IOException {
		System.out.println("Bitte Weckzeit im Format HH:mm:ss (Bsp.: 15:15:15) eingeben: ");

		String weckzeitString = br.readLine();
		
		try {
			DateFormat format = new SimpleDateFormat("HH:mm:ss", Locale.GERMAN);
			Date date = format.parse(weckzeitString);
			return date.getTime();
		} catch (ParseException e) {
			display.accept("Falsches Format in '" + weckzeitString + "' Bitte HH:mm:ss benutzen (Bsp.: 15:15:15)");
			return INVALIDE_WECKZEIT;
		}

		
	}

}
