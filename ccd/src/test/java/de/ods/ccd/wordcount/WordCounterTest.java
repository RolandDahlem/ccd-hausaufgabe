package de.ods.ccd.wordcount;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class WordCounterTest {

	@Test
	public void test_ob_woerter_in_einem_normalen_satz_gezaehlt_werden() {
		WordCounter wordCounter = new WordCounter();
		
		assertThat(wordCounter.countWords("Mary had a little lamb"), is(5));
	}

	@Test
	public void test_ob_woerter_bei_meheren_trennern_gezaehlt_werden() {
		WordCounter wordCounter = new WordCounter();
		
		assertThat(wordCounter.countWords("Mary had a     little lamb"), is(5));
	}
	
	@Test
	public void test_ob_woerter_bei_zahlen_als_trenner_gezaehlt_werden() {
		WordCounter wordCounter = new WordCounter();
		
		assertThat(wordCounter.countWords("Mary had a7little lamb"), is(5));
	}
	
	@Ignore("Anforderungen ändern? :) ")
	@Test
	public void test_ob_woerter_bei_umlauten_gezaehlt_werden() {
		WordCounter wordCounter = new WordCounter();
		
		assertThat(wordCounter.countWords("Märy had a little lamb"), is(6));
	}
	
	@Test
	public void test_ob_woerter_in_leeren_saetzen_gezaehlt_werden() {
		WordCounter wordCounter = new WordCounter();
		
		assertThat(wordCounter.countWords(""), is(0));
	}
	
}
