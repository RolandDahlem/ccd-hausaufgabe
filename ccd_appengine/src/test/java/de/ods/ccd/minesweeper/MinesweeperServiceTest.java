package de.ods.ccd.minesweeper;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Ignore;
import org.junit.Test;

public class MinesweeperServiceTest {

	MinesweeperService service = new MinesweeperService();

	@Test
	public void test_ob_mogelzettel_erstellt_wird() {

		String minenfeld =
				".*.\n" +
				"...\n" +
				"...";

		String mogelzettel_soll =
				"1*1\n" +
				"111\n" +
				"000";
		
		assertThat(service.erzeugeMogelzettel(minenfeld), is(mogelzettel_soll));
	}
	
	@Test
	@Ignore
	public void test_ob_rechteckiger_mogelzettel_erstellt_wird() {

		String minenfeld =
				".*\n" +
				"..\n" +
				"..\n" +
				"..";

		String mogelzettel_soll =
				"1*\n" +
				"11\n" +
				"..\n" +
				"..";
		
		assertThat(service.erzeugeMogelzettel(minenfeld), is(mogelzettel_soll));
	}
	
	@Test
	@Ignore
	public void test_ob_ein_mal_ein_feld_erstellt_wird() {
		String minenfeld =
				".";

		String mogelzettel_soll =
				"0";
		
		assertThat(service.erzeugeMogelzettel(minenfeld), is(mogelzettel_soll));
	}

}
