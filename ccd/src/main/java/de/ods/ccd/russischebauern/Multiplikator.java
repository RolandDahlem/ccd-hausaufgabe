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
		
	}
	
	private Deque<Zeile> stack = new ArrayDeque<Zeile>();
	
	public int mult(int i, int j) {
		stack.push(new Zeile(i, j));
		return stackAuswerten(stack);
	}

	private int stackAuswerten(Deque<Zeile> stack) {
		Zeile zeile = stack.pop();
		return zeile.j;
	}

}
