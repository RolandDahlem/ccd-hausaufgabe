package de.ods.ccd.wecker.uithread;

public class UIThread {

	public UIThread(ArbeitAble arbeitAble) {
		Arbeiter arbeiter = new Arbeiter(arbeitAble);
		UI ui = new UI(arbeitAble, arbeiter);
		
		Thread thread_wecker = new Thread(arbeiter);
		Thread thread_ui = new Thread(ui);

		thread_wecker.start();
		thread_ui.start();
		
	}

	
}
