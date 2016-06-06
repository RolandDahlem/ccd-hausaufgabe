package de.ods.ccd_gui.textumbruch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TextumbruchController {
	
	@Autowired
	TextUmbruchService service;
	
	@RequestMapping(value = "/textumbruch_input", method = RequestMethod.GET)
	public String zeigeTextumbruchInputFelder(ModelMap model) {

		model.addAttribute("textfeldinhalt", "Er fragte, wohin gehen wir.");
		model.addAttribute("maximalbreiteinhalt", "9");

		return "textumbruch_input";
	}

	@RequestMapping(value = "/textumbruch_umbrechen", method = RequestMethod.GET)
	public String umbrechen(ModelMap model, @RequestParam("umbruchstext") String umbruchstext, @RequestParam("maximalbreite") int maximalbreite) {
		
		String neuerText = service.umbrechen(umbruchstext, maximalbreite);
		model.addAttribute("textfeldinhalt", neuerText);
		model.addAttribute("maximalbreiteinhalt", maximalbreite);
		
		return "textumbruch_input";
	}
		
}