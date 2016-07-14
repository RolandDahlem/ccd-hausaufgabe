package de.ods.ccd.wordcount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URISyntaxException;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class WordCounterUI {

	private WordCounter wordCounter;
	private Consumer<String> display;
	
	public WordCounterUI() {
		wordCounter = new WordCounter();
		wordCounter.setStoppwoerter(new FileProvider().getStoppwoerter());
	}
	
	public void setDisplay(Consumer<String> display) {
		this.display = display;		
	}

	public static void main(String[] args) throws IOException, URISyntaxException {
		WordCounterUI wordCounterUI = new WordCounterUI();
		wordCounterUI.setDisplay(new KonsoleOutput());
		wordCounterUI.berechne(new InputStreamReader(System.in), args);
	}
		
	public void berechne(Reader reader, String[] filenames) throws IOException {
		String satz = holeInput(reader, filenames);
		int wordCount = wordCounter.countWords(satz);
		display.accept("Number of Words: " + wordCount);
	}

	private String holeInput(Reader reader, String[] filenames) throws IOException {
		
		if(filenames.length == 0){
			display.accept("Enter your text: ");
			try(BufferedReader br=new BufferedReader(reader)){
				return br.readLine();
			}	
		} else {
			return new FileProvider().leseDatei(filenames[0]).stream().collect(Collectors.joining(" "));
		}
	
	}

}
