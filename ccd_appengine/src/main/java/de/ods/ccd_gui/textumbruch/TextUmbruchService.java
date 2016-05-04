package de.ods.ccd_gui.textumbruch;

import org.springframework.stereotype.Service;

@Service
public class TextUmbruchService {

	public String umbrechen(String umbruchstext, int maximalbreite) {
		return new Umbrecher(umbruchstext, maximalbreite).umbrechen();
	}

}
