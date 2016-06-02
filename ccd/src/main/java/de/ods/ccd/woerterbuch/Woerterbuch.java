package de.ods.ccd.woerterbuch;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Woerterbuch {

	public static Map<String,String> toDictionary(String input) {
		Map<String,String> result = new HashMap<String,String>();
		
		StringTokenizer tokenizer = new StringTokenizer(input, ";");
		while(tokenizer.hasMoreTokens()){
			String token = tokenizer.nextToken();
			int trenner = token.indexOf("=");
			
			String key = token.substring(0, trenner);
			String value = token.substring(trenner+1);
			
			if(key.isEmpty()){
				throw new RuntimeException("Falsche Syntax. Kein Key für einen Value. Input: " + input);
			}
			
			result.put(key, value);
		}
		return result;
	}

}
