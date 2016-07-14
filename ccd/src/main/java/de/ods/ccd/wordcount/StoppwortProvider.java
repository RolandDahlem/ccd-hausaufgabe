package de.ods.ccd.wordcount;

import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class StoppwortProvider {

	public List<String> getStoppwoerter() {
		try {
			URL url = ClassLoader.getSystemResource("wordcount/stoppwort.txt");
			Path path = Paths.get(url.toURI());
			return Files.readAllLines(path, Charset.forName("UTF-8"));
		} catch (Exception e) {
			throw new RuntimeException("Fehler beim Einlesen der Stoppwortliste", e);
		}
	}

}
