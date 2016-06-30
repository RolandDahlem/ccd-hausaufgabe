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

	public static class Alarm {

		public void start() {
			System.out.println("Alarm gestartet");
		}

		public void stopp() {
			System.out.println("Alarm gestoppet");
		}
		
	}
	
	private Consumer<String> display;
	private Uhrzeit weckzeit = INVALIDE_WECKZEIT;
	private AktuelleZeitProvider aktuelleZeitProvider;
	private Alarm alarm;

	public Wecker() {
		this.aktuelleZeitProvider = new AktuelleZeitProvider();
		this.alarm = new Alarm();
	}

	public void setAktuelleZeitProvider(AktuelleZeitProvider aktuelleZeitProvider) {
		this.aktuelleZeitProvider = aktuelleZeitProvider;
	}

	public void setAlarm(Alarm alarm) {
		this.alarm = alarm;
	}
	
	@Override
	public void setDisplay(Consumer<String> display) {
		this.display = display;
	}

	@Override
	public void macheArbeit() {
		
		StringBuilder ausgabe = new StringBuilder();
		
		Uhrzeit jetzt = getAktuelleZeit();
		ausgabe.append("Es ist " + jetzt + " Uhr");
		
		if(sollAlarmStarten()){
			alarm.start();
		}
		
		if (istWeckzeitValide()) {				
			ausgabe.append(" Weckzeit " + weckzeit);
			if (istRestzeitValide()) {				
				String restzeit = weckzeit.formatiereVorsprungZu(jetzt);
				ausgabe.append(" Restzeit " + restzeit);
			}
		}

		display.accept(ausgabe.toString());
	}

	private boolean sollAlarmStarten() {
		
		if(weckzeit == INVALIDE_WECKZEIT){
			return false;
		}
		
		return getAktuelleZeit().istSpaeterAls(weckzeit);
	}

	private boolean istWeckzeitValide() {
		return weckzeit != INVALIDE_WECKZEIT;
	}

	private boolean istRestzeitValide() {
		return weckzeit.istSpaeterAls(getAktuelleZeit());
	}
	
	@Override
	public void verarbeiteBenutzereingabe(BufferedReader br) throws IOException {
		System.out.println("Bitte Aktion Auswählen: ");
		System.out.println("  1: Weckzeit setzen");
		System.out.println("  2: Wecker stoppen");
		
		String aktion = br.readLine();
		
		if(aktion.equals("1")){
			this.weckzeit = leseWeckzeitEin(br);
		} if (aktion.equals("2")){
			this.weckzeit = INVALIDE_WECKZEIT;
			this.alarm.stopp();
		}
		
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
