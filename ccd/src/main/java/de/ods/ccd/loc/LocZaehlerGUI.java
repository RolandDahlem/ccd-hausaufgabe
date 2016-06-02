package de.ods.ccd.loc;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.function.Consumer;

public class LocZaehlerGUI {

	private static class GUI implements Consumer<String> {

		@Override
		public void accept(String line) {
			System.out.println(line);
		}
		
	}
	
	public static void main(String[] args) throws IOException, URISyntaxException {
		new LocZaehler().zaehleLinesOfCode("loc/dateienInUnterordnern/", new GUI());
	}

}
