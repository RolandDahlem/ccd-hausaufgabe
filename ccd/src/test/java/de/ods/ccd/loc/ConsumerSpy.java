package de.ods.ccd.loc;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

class ConsumerSpy implements Consumer<String> {

	private List<String> consumed = new ArrayList<String>();

	@Override
	public void accept(String t) {
		consumed.add(t);
	}

	public List<String> getConsumed() {
		return consumed;
	}

}
