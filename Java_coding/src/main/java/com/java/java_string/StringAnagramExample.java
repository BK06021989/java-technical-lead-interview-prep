package com.java.java_string;

import java.util.Arrays;

public class StringAnagramExample {
	public static boolean isAagram(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;

		char[] arr1 = s1.toLowerCase().toCharArray();
		char[] arr2 = s2.toLowerCase().toCharArray();

		Arrays.sort(arr1);
		Arrays.sort(arr2);

		return Arrays.equals(arr1, arr2);
	}

	public static void main(String[] args) {
		String str1 = "listen";
		String str2 = "silent";
		System.out.println(str1 + " and " + str2 + " is anagram: " + isAagram(str1, str2));
	}
}
