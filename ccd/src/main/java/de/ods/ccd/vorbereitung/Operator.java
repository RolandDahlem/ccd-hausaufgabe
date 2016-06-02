package de.ods.ccd.vorbereitung;

enum Operator {
	
	addieren("+") {

		@Override
		public Double operiere(Double zahl1, Double zahl2) {
			return zahl1 + zahl2;
		}

	},

	subtrahieren("-") {

		@Override
		public Double operiere(Double zahl1, Double zahl2) {
			return zahl1 - zahl2;
		}

	},
	
	multiplizieren("*") {

		@Override
		public Double operiere(Double zahl1, Double zahl2) {
			return zahl1 * zahl2;
		}

	},
	
	dividieren("/") {

		@Override
		public Double operiere(Double zahl1, Double zahl2) {
			return zahl1 / zahl2;
		}

	};
	
	private String zeichen;

	Operator(String zeichen) {
		this.zeichen = zeichen;
	}

	public abstract Double operiere(Double zahl1, Double zahl2);
	
	
	public static Operator getOperatorVon(String operatorZeichen) {
		for (Operator operator : Operator.values()) {
			if(operator.zeichen.equals(operatorZeichen)){
				return operator;
			}
		}
		
		throw new IllegalArgumentException("Kein Operator '" + operatorZeichen + "'");
	}
}
