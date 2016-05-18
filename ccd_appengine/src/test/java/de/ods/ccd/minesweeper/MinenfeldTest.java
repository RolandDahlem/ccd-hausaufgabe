package de.ods.ccd.minesweeper;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class MinenfeldTest {

	@Test
	public void test_ob_mogelzettel_erstellt_wird() {

		String minenfeld_raw =
				".*.\n" +
				"...\n" +
				"...\n";
		
		Minenfeld minenfeld = new Minenfeld(minenfeld_raw);
		
		assertThat(minenfeld.minenfeld.length, is(3));
		assertThat(minenfeld.minenfeld[0][0], is('.'));
		assertThat(minenfeld.minenfeld[0][1], is('*'));
		assertThat(minenfeld.toString(), is(minenfeld_raw));
	}
}
