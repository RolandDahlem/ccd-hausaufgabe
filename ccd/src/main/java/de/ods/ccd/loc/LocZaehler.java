package de.ods.ccd.loc;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;
import java.util.function.Consumer;

public class LocZaehler {

	private FileProvider fileProvider = new FileProvider();
			
	public void zaehleLinesOfCode(String pfad, Consumer<String> gui) throws IOException, URISyntaxException {
		
		String ordnerPfad = fileProvider.ermittleDateinamen(pfad);

		fileProvider.leseCodedatei(ordnerPfad, new Consumer<String>() {

			@Override
			public void accept(String dateiname) {
				
				try {
					Einzelergebnis einzelergebnis = analysiereDatei(dateiname);
					gui.accept(dateiname + " " + einzelergebnis.toString());
				} catch (IOException e) {
					e.printStackTrace();
				}

			}		
			
		});
	}

	Einzelergebnis analysiereDatei(String dateiname) throws IOException {
				
		List<String> zeilen = fileProvider.leseZeilen(dateiname);
		
		Einzelergebnis ergebnis = new Einzelergebnis();
		ergebnis.setGesamtzeilen(zeilen.size());
		
		return ergebnis;
	}

    

}
