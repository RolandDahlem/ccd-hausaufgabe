package de.ods.ccd.loc;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class LocZaehler {

	private FileProvider fileProvider = new FileProvider();
	private Analysierer analysierer = new Analysierer();
	
	
	public void zaehleLinesOfCode(String pfad, Consumer<String> gui) throws IOException, URISyntaxException {
		
		String ordnerPfad = fileProvider.ermittleDateinamen(pfad);

		List<Einzelergebnis> ergebnisse = leseCodedatei(ordnerPfad, gui);
		
		agreggiere(ergebnisse, gui);
	}

	void agreggiere(List<Einzelergebnis> ergebnisse, Consumer<String> gui) {
		
		Einzelergebnis gesamtErgebnis = analysierer.agreggiere(ergebnisse);
		
		gui.accept(gesamtErgebnis.toString());
	}

	private List<Einzelergebnis> leseCodedatei(String ordnerPfad, Consumer<String> gui) throws IOException {
		
		List<Einzelergebnis> ergebnisse = new ArrayList<Einzelergebnis>();
		
		fileProvider.leseCodedatei(ordnerPfad, new Consumer<String>() {

			@Override
			public void accept(String dateiname) {
				
				try {
					Einzelergebnis einzelergebnis = analysierer.analysiereDatei(dateiname);
					gui.accept(dateiname + " " + einzelergebnis.toString());
					ergebnisse.add(einzelergebnis);
				} catch (IOException e) {
					e.printStackTrace();
				}

			}		
			
		});
		
		return ergebnisse;
	}
    

}
