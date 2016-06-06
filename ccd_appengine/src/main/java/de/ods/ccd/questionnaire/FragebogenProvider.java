package de.ods.ccd.questionnaire;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class FragebogenProvider {

	@Value("classpath:/WEB-INF/questionnaire.txt")
	private Resource inputfile;
	
	public List<String> leseFragebogenDatei() throws IOException {
		
		File file = new File("WEB-INF/questionnaire.txt");
		
		if(file.exists()){
			// appengine
			try(InputStream inputStream = new FileInputStream(file)){
				return stream2StringList(inputStream);
			}
		} else {
			// tests
			return Files.readAllLines(inputfile.getFile().toPath(), Charset.forName("UTF-8"));
		}
	}

	public static List<String> stream2StringList(InputStream in) throws IOException {
		List<String> lines = new ArrayList<String>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
		String line;
		while ((line = reader.readLine()) != null) {
			lines.add(line);
		}
		return lines;
	}
	
}
