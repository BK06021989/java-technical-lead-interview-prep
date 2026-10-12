package com.java.java_array;

import java.util.*;

public class ValuePositionsListInArraywithValue {

	public static void main(String[] args) {
		String[] names = { "Mia", "Leo", "Mia", "Noah", "Leo" };
		Map<String, List<Integer>> positions = new LinkedHashMap<>();
		for (int i = 0; i < names.length; i++) {
			positions.computeIfAbsent(names[i], key -> new ArrayList<>()).add(i + 1);
		}
		positions.forEach((name, indexes) -> System.out.println(indexes + " = " + name));
	}
}
//output:
//[1, 3] = Mia
//[2, 5] = Leo
//[4] = Noah