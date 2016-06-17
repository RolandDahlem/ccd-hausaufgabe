package de.ods.ccd.wecker;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Uhrzeit {

	private Calendar zeit;

	public Uhrzeit(Calendar weckzeit) {
		this.zeit = weckzeit;
	}

	public Uhrzeit(long aktuelleUhrzeit) {
		this(parse(aktuelleUhrzeit));		
	}

	public Uhrzeit(Uhrzeit aktuelleZeit, String weckzeitString) throws ParseException {
		this(parse(aktuelleZeit, weckzeitString));	
	}

	@Override
	public String toString() {
		return format(zeit.getTime());
	}

	private static String format(Date time) {
		SimpleDateFormat zeitformater = new SimpleDateFormat("HH:mm:ss");
		String format = zeitformater.format(time);
		return format;
	}
	
	private static Calendar parse(long aktuelleUhrzeit) {
		Calendar eingabe = new GregorianCalendar(Locale.GERMAN);
		eingabe.setTimeInMillis(aktuelleUhrzeit);
		return eingabe;
	}

	public String formatiereVorsprungZu(Uhrzeit vergleich) {
		long restzeit_in_msec = unterschiedInMsec(vergleich);
		return formatiereDauer(restzeit_in_msec);
	}

	private long unterschiedInMsec(Uhrzeit vergleich) {
		return zeit.getTimeInMillis() - vergleich.zeit.getTimeInMillis();
	}

	private String formatiereDauer(long restzeit_in_msec) {
		long restzeit_in_sec = restzeit_in_msec/1000;
		long restzeit_in_min = restzeit_in_sec/60;
		long restzeit_in_std = restzeit_in_min/60;
		
		DecimalFormat df = new DecimalFormat("00");
		return df.format(restzeit_in_std) + ":" + df.format(restzeit_in_min) + ":" + df.format(restzeit_in_sec);
	}

	private static Calendar parse(Uhrzeit jetzt, String weckzeitString) throws ParseException {
		DateFormat format = new SimpleDateFormat("HH:mm:ss", Locale.GERMAN);

		Calendar eingabe = new GregorianCalendar(Locale.GERMAN);
		eingabe.setTime(format.parse(weckzeitString));
		
		Calendar weckzeit = jetzt.zeit;
		weckzeit.set(Calendar.HOUR_OF_DAY, eingabe.get(Calendar.HOUR_OF_DAY));
		weckzeit.set(Calendar.MINUTE, eingabe.get(Calendar.MINUTE));
		weckzeit.set(Calendar.SECOND, eingabe.get(Calendar.SECOND));
		
		return weckzeit;
	}

	public boolean istSpaeterAls(Uhrzeit vergleich) {
		return  unterschiedInMsec(vergleich) < 0;
	}

	
}
