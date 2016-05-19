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
public class QuestionnaireController {
	
	@Autowired
	QuestionnaireService service;
	
	@RequestMapping(value = "/questionnaire_input", method = RequestMethod.GET)
	public String zeigeTextumbruchInputFelder(ModelMap model) throws IOException {

		List<Aufgabe> aufgaben = service.start();
		
		model.addAttribute("aufgaben", aufgaben);

		return "questionnaire_input";
	}
		
}