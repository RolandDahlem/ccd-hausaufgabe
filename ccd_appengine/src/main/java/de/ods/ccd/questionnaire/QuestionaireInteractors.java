package de.ods.ccd.questionnaire;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.ods.ccd.questionnaire.domain.Aufgabe;
import de.ods.ccd.questionnaire.domain.Fragebogen;

@Controller
public class QuestionaireInteractors {
	
	@Autowired
	private FragebogenProvider fragebogenProvider;
	
	@Autowired
	private AufgabenFactory aufgabenFactory;
	
	@RequestMapping(value = "/questionnaire_input", method = RequestMethod.GET)
	public String zeigeLeerenFragebogen(ModelMap model) throws IOException {

		Fragebogen fragebogen = leseLeerenFragebogen();
		
		model.addAttribute("fragebogen", fragebogen);
		return "questionnaire_input";
	}

    @RequestMapping(value = "/questionnaire_submit", method = RequestMethod.GET)
    public String berechnePuktzahl(ModelMap model, Fragebogen antwortbogen) throws IOException {
    	
    	Fragebogen fragebogen = leseLeerenFragebogen();
    	fragebogen.ergaenzeNutzerantworten(antwortbogen);
    	model.addAttribute("fragebogen", fragebogen);
    	
    	if(fragebogen.isVollstaendig()){
    		return "questionnaire_result";
    	} else {
    		return "questionnaire_input";
    	}
    }

    
	private Fragebogen leseLeerenFragebogen() throws IOException {
		List<Aufgabe> aufgaben = start();
		
		Fragebogen fragebogen = new Fragebogen();
		fragebogen.setAufgaben(aufgaben);
		return fragebogen;
	}
	
	List<Aufgabe> start() throws IOException {
		List<String> zeilen = fragebogenProvider.leseFragebogenDatei();
		List<Aufgabe> aufgaben = aufgabenFactory.erstelleAufgaben(zeilen);
		aufgaben = aufgabenFactory.ergeanzeWeissNicht(aufgaben);
		return aufgaben;
	}
			
}