package com.intervieday;

import java.util.HashMap;
import java.util.Map;

public class LotusFlare {

	public static void main(String[] args) {
		
		String word = "Qa Automation".toLowerCase().replaceAll("\\s", "");
		// [q:1, a:3, u:1]
		
		Map<Character, Integer> hmp = new HashMap<Character, Integer>();
		
		char[] ch = word.toCharArray();
			
		for(int i=0; i<ch.length; i++) {
			if(hmp.containsKey(ch[i])) {
				hmp.put(ch[i], hmp.get(ch[i]) + 1);
			} else {
				hmp.put(ch[i], 1);
			}
		}
		
		for(Map.Entry<Character, Integer> entry : hmp.entrySet()) {
			System.out.print(entry+", ");
		}
	}
}
