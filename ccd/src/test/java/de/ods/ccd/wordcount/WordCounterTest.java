package de.ods.ccd.wordcount;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Test;

public class WordCounterTest {

	private WordCounter wordCounter = new WordCounter();
	
	@Test
	public void test_ob_woerter_in_einem_normalen_satz_gezaehlt_werden() {
		assertThat(wordCounter.countWords("Mary had little lamb"), is(4));
	}

	@Test
	public void test_ob_woerter_bei_meheren_trennern_gezaehlt_werden() {
		assertThat(wordCounter.countWords("Mary had     little lamb"), is(4));
	}
	
	@Test
	public void test_ob_woerter_bei_zahlen_als_trenner_gezaehlt_werden() {
		assertThat(wordCounter.countWords("Mary had a7little lamb"), is(5));
	}
	
	@Test
	public void test_ob_woerter_in_leeren_saetzen_gezaehlt_werden() {
		assertThat(wordCounter.countWords(""), is(0));
	}
	
	@Test
	public void test_ob_stoppwoerter_beachtet_werden() {
		wordCounter.setStoppwoerter(Arrays.asList("a", "in", "out", "the"));
		
		assertThat(wordCounter.countWords("Mary had a little lamb"), is(4));
	}	
	
	@Test
	public void test_ob_uniq_woerter_beachtet_werden() {
		assertThat(wordCounter.countUniqueWords("Hallo Welt, Hallo Stefan"), is(3));
	}	
	
	@Test
	public void test_ob_uniq_woerter_case_sensitive_sind() {
		assertThat(wordCounter.countUniqueWords("HALLO Welt, hallo Stefan"), is(4));
	}	
	
}
