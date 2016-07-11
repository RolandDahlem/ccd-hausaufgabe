package de.ods.ccd.kanban.boars;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import de.ods.ccd.kanban.contracts.Board;

@Controller
public class KanbanInteractors {
	
	
//	@Autowired
//	private AufgabenFactory aufgabenFactory;
		
	@RequestMapping("/kanban/start")
	public @ResponseBody Board start(ModelMap model) throws IOException {
		return new Board(null, null);
	}
	
}
