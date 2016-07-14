package de.ods.ccd.wordcount;

import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileProvider {

	public List<String> getStoppwoerter() {
		return leseVonDatei("wordcount/stoppwort.txt");
	}

	public List<String> leseDatei(String dateiname) {
		return leseVonDatei("wordcount/" + dateiname);
	}
	
	private List<String> leseVonDatei(String name) {
		try {
			URL url = ClassLoader.getSystemResource(name);
			Path path = Paths.get(url.toURI());
			return Files.readAllLines(path, Charset.forName("UTF-8"));
		} catch (Exception e) {
			throw new RuntimeException("Fehler beim Einlesen der Stoppwortliste", e);
		}
	}



}
