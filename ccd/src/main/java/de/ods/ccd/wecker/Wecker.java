package de.ods.ccd.wecker;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Consumer;

import de.ods.ccd.wecker.uithread.Arbeiter;

public class Wecker implements Arbeiter {

	private Consumer<String> display;
	private String weckzeit;

	@Override
	public void setDisplay(Consumer<String> display) {
		this.display = display;
	}
	
	@Override
	public void macheArbeit() {
		SimpleDateFormat zeitformater = new SimpleDateFormat("HH:mm:ss");
		String uhrzeit = zeitformater.format(new Date());
		display.accept("Es ist " + uhrzeit + " Uhr");
		if (weckzeit != null) {
			display.accept("Weckzeit " + weckzeit);
		}
		
	}

	@Override
	public void verarbeiteBenutzereingabe(BufferedReader br) throws IOException {
		System.out.println("Bitte Weckzeit eingeben: ");
		this.weckzeit = br.readLine();
	}


	


}
