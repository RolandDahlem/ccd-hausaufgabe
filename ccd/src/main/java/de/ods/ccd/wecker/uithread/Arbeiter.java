package de.ods.ccd.wecker.uithread;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.function.Consumer;

public interface Arbeiter {

	void setDisplay(Consumer<String> display);
	
	void macheArbeit();

	void verarbeiteBenutzereingabe(BufferedReader br) throws IOException;



}
