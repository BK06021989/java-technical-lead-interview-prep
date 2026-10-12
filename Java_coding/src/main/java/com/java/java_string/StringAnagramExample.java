package com.java.java_string;

import java.util.Arrays;

public class StringAnagramExample {
	public static void main(String[] args) {
		String str1 = "listen";
		String str2 = "silent";

		boolean result = isAnagram(str1, str2);
		System.out.println(str1 + " and " + str2 + " are anagrams? " + result);// true

		// Another example
		System.out.println("triangle and integral are anagrams? " + isAnagram("triangle", "integral"));// true
		System.out.println("apple and paple are anagrams? " + isAnagram("apple", "papled"));// false
	}

	public static boolean isAnagram(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;

		char[] arr1 = s1.toLowerCase().toCharArray();
		char[] arr2 = s2.toLowerCase().toCharArray();

		Arrays.sort(arr1);
		Arrays.sort(arr2);

		return Arrays.equals(arr1, arr2);
	}
}
