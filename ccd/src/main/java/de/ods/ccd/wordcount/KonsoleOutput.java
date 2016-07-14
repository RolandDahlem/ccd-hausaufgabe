package de.ods.ccd.wordcount;

import java.util.function.Consumer;

public class KonsoleOutput implements Consumer<String> {

	@Override
	public void accept(String line) {
		System.out.println(line);
	}

}
