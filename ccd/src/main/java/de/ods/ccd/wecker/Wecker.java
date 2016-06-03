package de.ods.ccd.wecker;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.function.Consumer;

import de.ods.ccd.wecker.uithread.ArbeitAble;

public class Wecker implements ArbeitAble {

	@Override
	public void macheArbeit(Consumer<String> display) {
		display.accept("Es ist " + System.currentTimeMillis() + " Uhr in msec");
	}

	@Override
	public void verarbeiteBenutzereingabe(BufferedReader br) throws IOException {
		String line = br.readLine();
		System.out.println(" --- line: " + line);
	}
	


}
