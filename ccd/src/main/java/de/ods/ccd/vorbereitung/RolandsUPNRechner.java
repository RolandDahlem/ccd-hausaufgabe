package de.ods.ccd.vorbereitung;

public class RolandsUPNRechner {
	
	public static void main(String[] args) {
		RolandsUPNRechner upn = new RolandsUPNRechner();

		String ausdrucksString = join(args, " ");
		Double ergebnis = upn.berechne(ausdrucksString);
		System.out.println(ergebnis);
	}
	
	private static String join(String[] elements, String delimiter) {
		if (elements == null || elements.length == 0) {
			return "";
		}

		StringBuilder builder = new StringBuilder();
		for (String provider : elements) {
			if (builder.length() > 0) {
				builder.append(delimiter);
			}
			builder.append(provider.toString());
		}
		return builder.toString();
	}
	
	public Double berechne(String ausdrucksString) {
		Ausdruck ausdruck = new Ausdruck(ausdrucksString);
		return ausdruck.auswerten();
	}
}
