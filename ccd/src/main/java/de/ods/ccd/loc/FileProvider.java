package de.ods.ccd.loc;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Consumer;

public class FileProvider {

	String ermittleDateinamen(String pfad) throws URISyntaxException {
		URI uri = ClassLoader.getSystemResource(pfad).toURI();
		Path dir = Paths.get(uri);
		return dir.toString();
	}
	
	void leseCodedatei(String ordnerPfad, Consumer<String> consumer) throws IOException {
		Path ordner = Paths.get(ordnerPfad);
		try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(ordner)) {
            for (Path path : directoryStream) {
            	consumer.accept(path.toString());
            }
        }
	}

	public List<String> leseZeilen(String dateiname) throws IOException {
		Path path = Paths.get(dateiname);
		return Files.readAllLines(path, Charset.forName("UTF-8"));
	}



}
