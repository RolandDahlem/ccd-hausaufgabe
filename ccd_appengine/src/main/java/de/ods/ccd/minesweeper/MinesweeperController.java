package de.ods.ccd.minesweeper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MinesweeperController {
	
	@Autowired
	MinesweeperService service;
	
	@RequestMapping(value = "/minesweeper_input", method = RequestMethod.GET)
	public String zeigeTextumbruchInputFelder(ModelMap model) {

		model.addAttribute("minenfeld", ".*.\n...\n...");

		return "minesweeper_input";
	}

	@RequestMapping(value = "/minesweeper_loesen", method = RequestMethod.GET)
	public String umbrechen(ModelMap model, @RequestParam("umbruchstext") String minenfeld) {
		
		String mogelzettel = service.erzeugeMogelzettel(minenfeld);
		model.addAttribute("mogelzettel", mogelzettel);

		
		return "minesweeper_input";
	}
		
}