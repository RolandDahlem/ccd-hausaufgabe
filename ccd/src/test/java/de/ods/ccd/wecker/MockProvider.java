package de.ods.ccd.wecker;

import de.ods.ccd.wecker.Wecker.AktuelleZeitProvider;

class MockProvider extends AktuelleZeitProvider{

	private long zeit = 0;
	public long getAktuelleUhrzeit() {
		return zeit;
	}

	public void setZeit(long zeit) {
		this.zeit = zeit;
	}
	
}
