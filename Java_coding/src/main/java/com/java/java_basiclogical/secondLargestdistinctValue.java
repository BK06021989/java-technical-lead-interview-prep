package com.java.java_basiclogical;

public class secondLargestdistinctValue {
	static int secondLargest(int[] values) {
	    Integer largest = null;
	    Integer second = null;

	    for (int value : values) {
	        if (largest == null || value > largest) {
	            second = largest;
	            largest = value;
	        } else if (value != largest &&
	                   (second == null || value > second)) {
	            second = value;
	        }
	    }

	    if (second == null) {
	        throw new IllegalArgumentException("No second-largest distinct value");
	    }
	    return second;
	}
	public static void main(String[] args) {
		int[] values= {3,5,7,2,25,34,78};
		System.out.println(secondLargest(values));

	}

}
