package de.ods.ccd.russischebauern;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class Multiplikatortest {
	
	@Test
	public void test_ob_eins_mit_einer_zahl_multipliziert_werden_kann() throws Exception {
		assertThat(mult(1,3), is(1*3));
	}
		
	@Test
	public void test_ob_eine_iteration_funktioniert() throws Exception {
		assertThat(mult(2,1), is(2*1));
	}
	
	@Test
	public void test_ob_mehrere_iterationen_funktionieren() throws Exception {
		assertThat(mult(14,1), is(14*1));
	}
	
	@Test
	public void test_ob_komplexe_zahlen_multipliziert_werden_koennen() throws Exception {
		assertThat(mult(47,42), is(47*42));
	}
	
	private int mult(int i, int j) {
		return new Multiplikator().mult(i,j);
	}
	
}
