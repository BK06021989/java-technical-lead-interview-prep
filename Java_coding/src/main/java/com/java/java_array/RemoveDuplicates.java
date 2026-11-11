package com.java.java_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;

public class RemoveDuplicates {
	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(3, 1, 2, 3, 2, 4));
		ArrayList<Integer> uniqueNumbers = new ArrayList<>(new LinkedHashSet<>(numbers));
		System.out.println(uniqueNumbers); // [3, 1, 2, 4]
		// -------------------------------
		ArrayList<Integer> uniqueNumbersList = new ArrayList<>();
		for (Integer number : numbers) {
			if (!uniqueNumbersList.contains(number)) {
				uniqueNumbersList.add(number);
			}
		}
		System.out.println(uniqueNumbersList);
	}
}