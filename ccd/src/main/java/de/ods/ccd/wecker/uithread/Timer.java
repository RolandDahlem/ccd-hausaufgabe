package de.ods.ccd.wecker.uithread;

public class Timer implements Runnable {

	private volatile boolean isRunning = true;

	private final int abfrageintervall_millis;

	private Arbeiter arbeitAble;
	
	public Timer(Arbeiter arbeitAble) {
		this.arbeitAble = arbeitAble;
		this.abfrageintervall_millis = 1000;
	}
	
	@Override
	public void run() {
		try {
			while (true) {

				if(isRunning){
					arbeitAble.macheArbeit();
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
