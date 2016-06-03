package de.ods.ccd.wecker.uithread;

import java.util.function.Consumer;

public class Arbeiter implements Runnable {

	private volatile boolean isRunning = true;

	private final int abfrageintervall_millis;

	private ArbeitAble arbeitAble;
	
	public Arbeiter(ArbeitAble arbeitAble) {
		this.arbeitAble = arbeitAble;
		this.abfrageintervall_millis = 1000;
	}

	private Consumer<String> display;

	public void setOutput(Consumer<String> display) {
		this.display = display;
	}
	
	@Override
	public void run() {
		try {
			while (true) {

				if(isRunning){
					arbeitAble.macheArbeit(display);
				}
				
				Thread.sleep(abfrageintervall_millis);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void stop() {
		isRunning = false;
	}

	public void resume() {
		isRunning = true;
	}

}
