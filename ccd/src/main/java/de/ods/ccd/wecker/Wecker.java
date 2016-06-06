package de.ods.ccd.wecker;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Consumer;

import de.ods.ccd.wecker.uithread.Arbeiter;

public class Wecker implements Arbeiter {

	private Consumer<String> display;

	@Override
	public void setDisplay(Consumer<String> display) {
		this.display = display;
	}
	
	@Override
	public void macheArbeit() {
		SimpleDateFormat zeitformater = new SimpleDateFormat("HH:mm:ss");
		String uhrzeit = zeitformater.format(new Date());
		display.accept("Es ist " + uhrzeit + " Uhr");
	}

	@Override
	public void verarbeiteBenutzereingabe(BufferedReader br) throws IOException {
		String line = br.readLine();
		System.out.println(" --- line: " + line);
	}


	


}
