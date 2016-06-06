package de.ods.ccd.wecker;

import java.io.IOException;
import java.net.URISyntaxException;

import de.ods.ccd.wecker.uithread.UI;

public class WeckerUI {

	public static void main(String[] args) throws IOException, URISyntaxException {
		UI.start(new Wecker());
	}

}
