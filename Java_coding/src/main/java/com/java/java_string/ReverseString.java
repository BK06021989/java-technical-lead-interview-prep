package com.java.java_string;

public class ReverseString {
	static String reverse(String s) {
		char[] chars = s.toCharArray();
		for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
			char temp = chars[i];
			chars[i] = chars[j];
			chars[j] = temp;
		}
		return new String(chars);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverse("abcdef"));
	}

}
