package de.ods.ccd.wecker.uithread;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.function.Consumer;

public interface ArbeitAble {

	void macheArbeit(Consumer<String> display);

	void verarbeiteBenutzereingabe(BufferedReader br) throws IOException;

}
