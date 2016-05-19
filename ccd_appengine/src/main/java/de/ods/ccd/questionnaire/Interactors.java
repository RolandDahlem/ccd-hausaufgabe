package de.ods.ccd.questionnaire;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.ods.ccd.questionnaire.domain.Aufgabe;

@Controller
public class Interactors {
	
	@Autowired
	private FragebogenProvider fragebogenProvider;
	
	@Autowired
	private AufgabenFactory aufgabenFactory;
	
	@RequestMapping(value = "/questionnaire_input", method = RequestMethod.GET)
	public String zeigeLeerenFragebogen(ModelMap model) throws IOException {

		List<Aufgabe> aufgaben = start();
		model.addAttribute("aufgaben", aufgaben);
		return "questionnaire_input";
	}

	List<Aufgabe> start() throws IOException {
		List<String> zeilen = fragebogenProvider.leseFragebogenDatei();
		List<Aufgabe> aufgaben = aufgabenFactory.erstelleAufgaben(zeilen);
		aufgaben = aufgabenFactory.ergeanzeWeissNicht(aufgaben);
		return aufgaben;
	}
			
}