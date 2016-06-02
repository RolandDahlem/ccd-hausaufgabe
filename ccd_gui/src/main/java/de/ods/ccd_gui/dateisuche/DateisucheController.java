package de.ods.ccd_gui.dateisuche;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DateisucheController {

	@Autowired
	DateisucheService service;

	@RequestMapping(value = "/dateisuche_input", method = RequestMethod.GET)
	public String zeigeDateisucheInputFelder(ModelMap model) {

		model.addAttribute("verzeichnispfad", "C:/workspace/gelb1/ccd_gui/src/main/webapp");

		return "dateisuche_input";
	}

	@RequestMapping(value = "/dateisuche_suche", method = RequestMethod.GET)
	public String sucheInDateien(ModelMap model, @RequestParam("verzeichnispfad") String verzeichnispfad, @RequestParam("suchwort") String suchwort) {

		String suchergebnis = service.suchen(verzeichnispfad, suchwort);

		model.addAttribute("verzeichnispfad", verzeichnispfad);
		model.addAttribute("suchwort", suchwort);
		model.addAttribute("suchergebnis", suchergebnis);

		return "dateisuche_input";
	}

}