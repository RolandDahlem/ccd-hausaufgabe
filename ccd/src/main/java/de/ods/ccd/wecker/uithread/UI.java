package de.ods.ccd.wecker.uithread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;

public class UI implements Runnable {

	private static class KonsoleOutput implements Consumer<String> {

		@Override
		public void accept(String line) {
			System.out.println(line);
		}

	}

	private KonsoleOutput konsoleOutput = new KonsoleOutput();
	private Timer arbeiter;
	private Arbeiter arbeitAble;

	public UI(Arbeiter arbeitAble, Timer arbeiter) {
		this.arbeitAble = arbeitAble;
		this.arbeiter = arbeiter;
		arbeitAble.setDisplay(konsoleOutput);
	}

	@Override
	public void run() {

		try {
			while (true) {
				versorgeArbeiter();
				Thread.sleep(100);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void versorgeArbeiter() throws IOException {
		
		InputStreamReader isr = new InputStreamReader(System.in);
		if(isr.ready()){
			arbeiter.stop();
			BufferedReader br=new BufferedReader(isr);
			br.readLine();
			
			arbeitAble.verarbeiteBenutzereingabe(br);
			
			arbeiter.resume();
		}
		
	}

	public static void start(Arbeiter arbeiter) {
		Timer timer = new Timer(arbeiter);
		UI ui = new UI(arbeiter, timer);
		
		Thread thread_wecker = new Thread(timer);
		Thread thread_ui = new Thread(ui);

		thread_wecker.start();
		thread_ui.start();
	}
	


}
