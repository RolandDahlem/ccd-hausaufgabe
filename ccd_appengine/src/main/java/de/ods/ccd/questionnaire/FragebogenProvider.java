package de.ods.ccd.questionnaire;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class FragebogenProvider {

	@Value("classpath:questionnaire.txt")
	private Resource inputfile;

	public List<String> leseFragebogenDatei() throws IOException {
		return Files.readAllLines(inputfile.getFile().toPath(), Charset.forName("UTF-8"));
	}

}
