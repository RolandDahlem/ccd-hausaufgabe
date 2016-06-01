package de.ods.ccd.questionnaire.domain;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class FragebogenTest {

	@Test
	public void test_ob_unvollstaendige_frageboegen_erkannt_werden() {
		
		Aufgabe leereAntwort = new Aufgabe();
		
		Fragebogen fragebogen = erstelleFragebogenMitAntwort(leereAntwort);
		assertThat(fragebogen.isVollstaendig(), is(false));
	}

	@Test
	public void test_ob_vollstaendige_frageboegen_erkannt_werden() {
		
		Aufgabe volleAntwort = new Aufgabe();
		volleAntwort.setNutzerantwort("nutzerantwort");
		
		Fragebogen fragebogen = erstelleFragebogenMitAntwort(volleAntwort);
		assertThat(fragebogen.isVollstaendig(), is(true));
	}
	
	private Fragebogen erstelleFragebogenMitAntwort(Aufgabe leereAntwort) {
		Fragebogen fragebogen = new Fragebogen();
		
		List<Aufgabe> aufgaben = new ArrayList<Aufgabe>();

		aufgaben.add(leereAntwort);
		fragebogen.setAufgaben(aufgaben);
		return fragebogen;
	}

}
