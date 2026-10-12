package com.java.java_array;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstUniqueCharFromArrayList {
	public static void main(String[] args) {
		List<String> words = new ArrayList<>(Arrays.asList("swiss", "level", "alphabet", "aabb"));

		words.forEach(word -> {
			// Build frequency map preserving order
			Map<Character, Long> freqMap = word.chars().mapToObj(c -> (char) c)
					.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

			// Find first unique character
			Optional<Character> firstUnique = freqMap.entrySet().stream().filter(e -> e.getValue() == 1)
					.map(Map.Entry::getKey).findFirst();

			System.out.println("Word: " + word + " → First unique char: " + firstUnique.orElse(null));
		});
	}
}
