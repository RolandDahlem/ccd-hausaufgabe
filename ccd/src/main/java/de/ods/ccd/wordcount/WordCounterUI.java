package de.ods.ccd.wordcount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URISyntaxException;
import java.util.function.Consumer;

public class WordCounterUI {

	private WordCounter wordCounter = new WordCounter();
	private Consumer<String> display;
	
	public void setDisplay(Consumer<String> display) {
		this.display = display;		
	}

	public static void main(String[] args) throws IOException, URISyntaxException {
		WordCounterUI wordCounterUI = new WordCounterUI();
		wordCounterUI.setDisplay(new KonsoleOutput());
		wordCounterUI.berechne(new InputStreamReader(System.in));
	}
	
	public void berechne(Reader reader) throws IOException {
		
		display.accept("Enter your text: ");
		
		String line = holeInput(reader);
		int wordCount = wordCounter.countWords(line);
		display.accept("Number of Words: " + wordCount);
	}

	private String holeInput(Reader reader) throws IOException {
		try(BufferedReader br=new BufferedReader(reader)){
			return br.readLine();
		}		
	}

}
