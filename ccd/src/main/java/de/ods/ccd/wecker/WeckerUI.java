package de.ods.ccd.wecker;

import java.io.IOException;
import java.net.URISyntaxException;

import de.ods.ccd.wecker.uithread.UIThread;

public class WeckerUI {

	public static void main(String[] args) throws IOException, URISyntaxException {
		new UIThread(new Wecker());
	}

}
