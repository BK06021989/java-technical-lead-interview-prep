package com.java.java_string;

public class StringisPalindrome {
	static boolean isPalindrome(String s) {
		int left = 0, right = s.length() - 1;
		while (left < right) {
			if (s.charAt(left++) != s.charAt(right--))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome("abcba"));//true
	}

}
