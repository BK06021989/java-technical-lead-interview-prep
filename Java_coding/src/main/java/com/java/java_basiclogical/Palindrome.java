package com.java.java_basiclogical;

public class Palindrome {

	static boolean isPalindrome(String s) {
		String tempStr = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			tempStr = tempStr + s.charAt(i);
		}
		if (s.equals(tempStr)) {
			return true;
		}
		return false;
	}

	public static void main(String str[]) {
		System.out.println(isPalindrome("abcba"));
		System.out.println(palindromeCheck("abcba"));
	}
	static boolean palindromeCheck(String str) {
		String rev=new StringBuffer(str).reverse().toString();
		if(rev.contains(str)) {
			return true;
		}else
		return false;
	}

}