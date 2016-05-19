package de.ods.ccd.questionnaire;

import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.apache.taglibs.standard.lang.jstl.EqualsOperator;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.mockito.internal.matchers.GreaterOrEqual;
import org.springframework.beans.factory.annotation.Autowired;

import de.ods.ccd.AbstractSpringIntegrationTest;
import de.ods.ccd.questionnaire.domain.Aufgabe;

public class QuestionnaireServiceIntegrationTest extends AbstractSpringIntegrationTest{

	@Autowired
	private QuestionnaireService service;
	
	@Test
	public void test_ob_die_vorgabe_datei_eingelesen_wird() throws Exception {
		List<Aufgabe> aufgaben = service.start();

		assertThat(aufgaben.size(), is(2));
		assertThat(aufgaben.get(0).getFrage(), endsWith("?"));
	}

	@Test
	public void test_ob_weiss_nicht_vorhanden_ist() throws Exception {
		List<Aufgabe> aufgaben = service.start();

		String letzteAntortMoeglichkeit = aufgaben.get(0).getAntwortmoeglichkeiten().get(aufgaben.get(0).getAntwortmoeglichkeiten().size()-1);
		assertThat(letzteAntortMoeglichkeit, is("Weiß nicht"));
	}
}
