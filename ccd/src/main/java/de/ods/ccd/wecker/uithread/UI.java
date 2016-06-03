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
	private Arbeiter arbeiter;
	private ArbeitAble arbeitAble;

	public UI(ArbeitAble arbeitAble, Arbeiter arbeiter) {
		this.arbeitAble = arbeitAble;
		this.arbeiter = arbeiter;
		arbeiter.setOutput(konsoleOutput);
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
			System.out.println("Bitte Befehl eingeben: ");
			
			arbeitAble.verarbeiteBenutzereingabe(br);
			
			arbeiter.resume();
		}
		
	}



}
