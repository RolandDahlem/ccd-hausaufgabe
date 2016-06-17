package de.ods.ccd.wecker;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.function.Consumer;

import de.ods.ccd.wecker.uithread.Arbeiter;

public class Wecker implements Arbeiter {

	private static final Calendar INVALIDE_WECKZEIT = null;

	public static class AktuelleZeitProvider {
		public long getAktuelleUhrzeit() {
			return System.currentTimeMillis();
		}
	}

	private Consumer<String> display;
	private Calendar weckzeit = INVALIDE_WECKZEIT;
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
			String weckzeitAusgabe = "Weckzeit " + zeitformater.format(weckzeit.getTime());
			
			Calendar jetzt = getAktuelleZeit();
			
			String jetztAusgabe = "Jetzt " + zeitformater.format(jetzt.getTime());
			System.out.println("jetztAusgabe: " + jetztAusgabe);
			
			
			long restzeit_in_msec = weckzeit.getTimeInMillis() - aktuelleZeitProvider.getAktuelleUhrzeit();
			
			long restzeit_in_sec = restzeit_in_msec/1000;
			
			DecimalFormat df = new DecimalFormat("00");
			
			String restAusgabe = "Restzeit 0:" + df.format(restzeit_in_sec);
			display.accept(weckzeitAusgabe + " " + restAusgabe);

		}
	}

	@Override
	public void verarbeiteBenutzereingabe(BufferedReader br) throws IOException {
		this.weckzeit = leseWeckzeitEin(br);
	}

	private Calendar leseWeckzeitEin(BufferedReader br) throws IOException {
		System.out.println("Bitte Weckzeit im Format HH:mm:ss (Bsp.: 15:15:15) eingeben: ");

		String weckzeitString = br.readLine();
		
		try {
			DateFormat format = new SimpleDateFormat("HH:mm:ss", Locale.GERMAN);

			Calendar eingabe = new GregorianCalendar(Locale.GERMAN);
			eingabe.setTime(format.parse(weckzeitString));
			
			Calendar weckzeit = getAktuelleZeit();
			weckzeit.set(Calendar.HOUR_OF_DAY, eingabe.get(Calendar.HOUR_OF_DAY));
			weckzeit.set(Calendar.MINUTE, eingabe.get(Calendar.MINUTE));
			weckzeit.set(Calendar.SECOND, eingabe.get(Calendar.SECOND));
			
			return weckzeit;
		} catch (ParseException e) {
			display.accept("Falsches Format in '" + weckzeitString + "' Bitte HH:mm:ss benutzen (Bsp.: 15:15:15)");
			return INVALIDE_WECKZEIT;
		}

		
	}

	private Calendar getAktuelleZeit() {
		Calendar weckzeit = new GregorianCalendar(Locale.GERMAN);
		weckzeit.setTimeInMillis(aktuelleZeitProvider.getAktuelleUhrzeit());
		return weckzeit;
	}

}
