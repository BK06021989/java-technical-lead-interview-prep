package com.java.java_array;

import java.util.*;
import java.util.stream.*;

public class MissingArraysNumbers {
	public static void main(String[] args) {
		List<Integer> num = Arrays.asList(1, 2, 4, 5, 6, 7, 9);
		int min = Collections.min(num);
		int max = Collections.max(num);
		List<Integer> missingNumbers = IntStream.rangeClosed(min, max)
				.filter(n -> !num.contains(n)).boxed()
				.collect(Collectors.toList());
		System.out.println("Missing Numbers:" + missingNumbers);
	}
}