package de.ods.ccd.russischebauern;

import java.util.ArrayDeque;
import java.util.Deque;

public class Multiplikator {

	private static class Zeile{
		
		private int i,j;
		
		public Zeile(int i, int j) {
			this.i = i;
			this.j = j;
		}

		public Zeile naechsteZeile() {
			return new Zeile(i >> 1, j << 1);
		}

		@Override
		public String toString() {
			return "Zeile [i=" + i + ", j=" + j + "]";
		}

	}
	
	public int mult(int i, int j) {
		Deque<Zeile> stack = tabelleErstellen(i, j);
		return tabelleAuswerten(stack);
	}

	private Deque<Zeile> tabelleErstellen(int i, int j) {
		Deque<Zeile> stack = new ArrayDeque<Zeile>();
		Zeile zeile = new Zeile(i, j);
		stack.push(zeile);
		
		while(zeile.i >= 1){
			zeile = zeile.naechsteZeile();
			stack.push(zeile);
		}
		return stack;
	}

	private int tabelleAuswerten(Deque<Zeile> stack) {
		int ergebnis = 0;
		while(stack.isEmpty() == false){
			Zeile zeile = stack.pop();
			
			if(zeile.i % 2 != 0){
				ergebnis += zeile.j;
			}
		}
		
		return ergebnis;
	}

}
