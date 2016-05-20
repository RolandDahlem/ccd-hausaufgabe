package de.ods.ccd.questionnaire;

import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import de.ods.ccd.AbstractSpringIntegrationTest;
import de.ods.ccd.questionnaire.domain.Aufgabe;

public class InteractorsIntegrationTest extends AbstractSpringIntegrationTest{

	@Autowired
	private Interactors interactors;
	
	@Test
	public void test_ob_die_vorgabe_datei_eingelesen_wird() throws Exception {
		List<Aufgabe> aufgaben = interactors.start();

		assertThat(aufgaben.size(), is(2));
	}

	@Test
	public void test_ob_die_format_eigenheiten_ausgebuegelt_werden() throws Exception {
		Aufgabe ersteAufgabe = interactors.start().get(0);

		assertThat(ersteAufgabe.getFrage(), endsWith("?"));
		assertThat(ersteAufgabe.getRichtigeAntwort(), is("Cat"));
	}
	
	@Test
	public void test_ob_weiss_nicht_vorhanden_ist() throws Exception {
		List<Aufgabe> aufgaben = interactors.start();

		String letzteAntortMoeglichkeit = aufgaben.get(0).getAntwortmoeglichkeiten().get(aufgaben.get(0).getAntwortmoeglichkeiten().size()-1);
		assertThat(letzteAntortMoeglichkeit, is("Weiß nicht"));
	}
}
