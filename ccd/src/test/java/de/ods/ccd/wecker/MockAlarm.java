package de.ods.ccd.wecker;

import de.ods.ccd.wecker.Wecker.Alarm;

class MockAlarm extends Alarm {

	boolean machtKrach = false;
	
	public void start() {
		machtKrach = true;
	}
	
	@Override
	public void stopp() {
		machtKrach = false;
	}
	
}
