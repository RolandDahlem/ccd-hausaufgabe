package de.ods.ccd.vorbereitung;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class RolandsUPNRechnerTest {

	@Test
	public void test_ob_addiert_werden_kann() {
		RolandsUPNRechner upn = new RolandsUPNRechner();
		assertThat(upn.berechne("2 3 +"), is(5.0));
	}
	
	@Test
	public void test_ob_subtrahiert_werden_kann() {
		RolandsUPNRechner upn = new RolandsUPNRechner();
		assertThat(upn.berechne("2 3 -"), is(-1.0));
	}
	
	@Test
	public void test_ob_multipliziert_werden_kann() {
		RolandsUPNRechner upn = new RolandsUPNRechner();
		assertThat(upn.berechne("2 3 *"), is(6.0));
	}

	@Test
	public void test_ob_geteilt_werden_kann() {
		RolandsUPNRechner upn = new RolandsUPNRechner();
		assertThat(upn.berechne("4 2 /"), is(2.0));
	}
	
	@Test
	public void test_ob_operationen_verkettet_werden_koennen() {
		RolandsUPNRechner upn = new RolandsUPNRechner();
		assertThat(upn.berechne("2 3 + 4 * "), is(20.0));
	}
	
	@Test
	public void test_ob_allen_operationen_zusammen_funktionieren() {
		RolandsUPNRechner upn = new RolandsUPNRechner();
		assertThat(upn.berechne("1 1 + 2 * 4 / 1 -"), is(0.0));
	}

	@Test(expected=IllegalArgumentException.class)
	public void test_ob_fehlermeldung_bei_keinen_parametern_korrekt_ist() {
		RolandsUPNRechner upn = new RolandsUPNRechner();
		upn.berechne("");
	}
	
}
