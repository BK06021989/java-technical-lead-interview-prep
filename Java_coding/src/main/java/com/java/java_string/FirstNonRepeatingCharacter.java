package com.java.java_string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatingCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="swiss";
		char chr=str.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(c->c,LinkedHashMap::new,Collectors.counting()))
		.entrySet().stream().filter(v->v.getValue()==1).map(Map.Entry::getKey).findFirst().orElse(null);
		System.out.println(chr);
		
		List<String> words = new ArrayList<>(Arrays.asList("swiss", "level", "alphabet", "aabb"));
		for(String word:words) {
		char firstChar=word.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(c->c,LinkedHashMap::new,Collectors.counting()))
				.entrySet().stream().filter(v->v.getValue()==1).map(Map.Entry::getKey).findFirst().orElse(null);
		System.out.println(firstChar);

		}	
		
	}

}
