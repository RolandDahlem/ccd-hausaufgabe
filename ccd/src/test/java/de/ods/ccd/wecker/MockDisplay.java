package de.ods.ccd.wecker;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class MockDisplay implements Consumer<String>{

	private List<String> ausgabe = new ArrayList<>();
	
	@Override
	public void accept(String zeile) {
		System.out.println(zeile);
		ausgabe.add(zeile);
	}

	public String getLetzteAusgabe() {
		return ausgabe.get(ausgabe.size() -1);
	}

	public String getVorLetzteAusgabe() {
		return ausgabe.get(ausgabe.size() -2);
	}
	
}