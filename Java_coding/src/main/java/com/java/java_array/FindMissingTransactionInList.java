package com.java.java_array;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindMissingTransactionInList {

	public static void main(String[] args) {
		List<Integer> transactions = Arrays.asList(1001, 1002, 1004, 1007, 1008);

		int min = Collections.min(transactions);
		int max = Collections.max(transactions);

		Set<Integer> available = new HashSet<>(transactions);

		List<Integer> missing = IntStream.rangeClosed(min, max).filter(n -> !available.contains(n)).boxed()
				.collect(Collectors.toList());
		System.out.println(missing);
	}
}
