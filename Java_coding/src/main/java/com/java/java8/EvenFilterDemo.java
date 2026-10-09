package com.java.java8;

/*How would you filter even numbers from an array or list 
using a Predicate or a functional interface in Java?*/
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EvenFilterDemo {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		// Predicate to check even numbers
		Predicate<Integer> isEven = n -> n % 2 == 0;

		// Filtering using Streams
		List<Integer> evenNumbers = numbers.stream().filter(isEven).collect(Collectors.toList());
		System.out.println(evenNumbers); // Output: [2, 4, 6]
	}
}
