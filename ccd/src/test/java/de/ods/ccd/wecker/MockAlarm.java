package de.ods.ccd.wecker;

import de.ods.ccd.wecker.Wecker.Alarm;

class MockAlarm extends Alarm {

	boolean machtKrach = false;
	
	public void macheKrach() {
		machtKrach = true;
	}
	
}
