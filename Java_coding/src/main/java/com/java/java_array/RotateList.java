package com.java.java_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RotateList {
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
		int k = 2;//output:[4, 5, 1, 2, 3]
		//int k = 3;//output:[3, 4, 5, 1, 2]
		rotateRight(numbers, k);
		System.out.println(numbers); // [4, 5, 1, 2, 3]
	}

	private static <T> void rotateRight(List<T> list, int k) {
		if (list.isEmpty()) {
			return;
		}
		int rotations = k % list.size();
		Collections.rotate(list, rotations);
	}
}
