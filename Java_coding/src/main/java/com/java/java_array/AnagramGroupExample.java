package com.java.java_array;

import java.util.*;

public class AnagramGroupExample {

	public static void main(String[] args) {

		String[] input = { "eat", "tea", "tan", "ate", "nat", "bat" };
		// output=[[eat, tea, ate], [bat], [tan, nat]]
		Map<String, List<String>> map = new HashMap<>();

		for (String word : input) {

			char[] chars = word.toCharArray();
			Arrays.sort(chars);

			String key = new String(chars);

			map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
		}
		System.out.println(new ArrayList<>(map.values()));

	}
}
