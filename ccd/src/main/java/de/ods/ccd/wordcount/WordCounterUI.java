package de.ods.ccd.wordcount;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.function.Consumer;

public class WordCounterUI {

	private WordCounter wordCounter = new WordCounter();
	private Consumer<String> display;
	
	public void setDisplay(Consumer<String> display) {
		this.display = display;		
	}

	public void berechne(BufferedReader reader) throws IOException {
		String line = reader.readLine();
		int wordCount = wordCounter.countWords(line);
		display.accept("Number of Words: " + wordCount);
	}

}
