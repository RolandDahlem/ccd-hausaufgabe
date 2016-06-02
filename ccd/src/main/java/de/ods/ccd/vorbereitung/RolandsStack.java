package de.ods.ccd.vorbereitung;

import java.util.ArrayList;

public class RolandsStack <T extends Object> {

	private ArrayList<T> liste;

	public RolandsStack() {
		liste = new ArrayList<T>();
	}
	
	public int count() {
		return liste.size();
	}

	public void push(T element) {
		liste.add(element);
	}

	public T pop() {
		return liste.remove(liste.size() -1);
	}

	public T peek() {
		return liste.get(liste.size() - 1);
	}

	public void clear() {
		liste.clear();
	}

}
