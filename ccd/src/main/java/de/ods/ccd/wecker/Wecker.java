package de.ods.ccd.wecker;

import java.io.BufferedReader;
import java.io.IOException;
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
		display.accept("Es ist " + System.currentTimeMillis() + " Uhr in msec");
	}

	@Override
	public void verarbeiteBenutzereingabe(BufferedReader br) throws IOException {
		String line = br.readLine();
		System.out.println(" --- line: " + line);
	}


	


}
