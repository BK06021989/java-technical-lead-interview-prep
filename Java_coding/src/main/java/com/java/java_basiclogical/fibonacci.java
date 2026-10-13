package com.java.java_basiclogical;
import java.util.*;
public class fibonacci {
	static List<Long> fibonacci(int n) {
	    if (n < 0) throw new IllegalArgumentException("n must be non-negative");

	    List<Long> result = new ArrayList<>();
	    long a = 0, b = 1;

	    for (int i = 0; i < n; i++) {
	        result.add(a);
	        long next = a + b;
	        a = b;
	        b = next;
	    }
	    return result;
	}
	public static void main(String[] args) {
		System.out.println(fibonacci(5));
	}

}
