package de.ods.ccd.vorbereitung;

import java.util.NoSuchElementException;
import java.util.StringTokenizer;

class Ausdruck {
	
	private StringTokenizer tokenizer;
	private RolandsStack<Double> stack = new RolandsStack<Double>();
	private String ausdrucksString;
	
	public Ausdruck(String ausdrucksString) {
		this.ausdrucksString = ausdrucksString;
		tokenizer = new StringTokenizer(ausdrucksString, " ");
	}

	private void parseZahl() {
		stack.push(Double.parseDouble(tokenizer.nextToken()));
	}

	private void benutzeOperator() {
		Operator operator = Operator.getOperatorVon(tokenizer.nextToken());
		
		Double zahl2 = stack.pop();
		Double zahl1 = stack.pop();
		Double ergebnis = operator.operiere(zahl1, zahl2);
		stack.push(ergebnis);
	}

	private boolean hatWeitereElemente() {
		return tokenizer.hasMoreTokens();
	}

	private Double getErgebnis() {
		
		if(stack.count() != 1){
			throw new IllegalArgumentException("'" + ausdrucksString +"' ist kein gueltiger Ausdruck. Es sind noch '" + stack.count() + "' Elemente im Stack");
		}

		return stack.pop();
	}

	public Double auswerten() {
		try{
			parseZahl();
			parseZahl();
			benutzeOperator();
			
			while(hatWeitereElemente()){
				parseZahl();
				benutzeOperator();
			}
			
			return getErgebnis();
		} catch (NoSuchElementException e){
			throw new IllegalArgumentException("Ausdruck '" + ausdrucksString + "' ist nicht valide", e);
		}

	}
}
