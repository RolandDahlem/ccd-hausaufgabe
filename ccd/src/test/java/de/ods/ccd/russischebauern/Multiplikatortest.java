package de.ods.ccd.russischebauern;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class Multiplikatortest {
	
	@Test
	public void test_ob_eins_mit_einer_zahl_multipliziert_werden_kann() throws Exception {
		assertThat(mult(1,3), is(1*3));
	}
		
	private int mult(int i, int j) {
		return new Multiplikator().mult(i,j);
	}
	
}
