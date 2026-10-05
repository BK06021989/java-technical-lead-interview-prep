package com.java.java_string;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringCharFrequency {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "banana";

		Map<Character, Long> frequency = input.chars()
		        .mapToObj(c -> (char) c)
		        .collect(Collectors.groupingBy(
		                Function.identity(),
		                LinkedHashMap::new,
		                Collectors.counting()));

		System.out.println(frequency); // {b=1, a=3, n=2}
	}

}
