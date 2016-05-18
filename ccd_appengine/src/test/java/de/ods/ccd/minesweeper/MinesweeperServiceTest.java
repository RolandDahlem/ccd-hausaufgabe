package de.ods.ccd.minesweeper;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class MinesweeperServiceTest {

	MinesweeperService service = new MinesweeperService();

	@Test
	public void test_ob_mogelzettel_erstellt_wird() {

		String minenfeld =
				".*.\n" +
				"...\n" +
				"...\n";

		String mogelzettel_soll =
				"1*1\n" +
				"111\n" +
				"000";
		
		assertThat(service.erzeugeMogelzettel(minenfeld), is(mogelzettel_soll));
	}
	
	

}
