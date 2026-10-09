package com.java.java_string;
//Input: s = "abcabcbb"
//Output: 3
import java.util.*;
public class LongestSubstring {
	public static int lengthOfLongestSubstring(String str) {
		int maxlen = 0;
		int left = 0;
		Set<Character> set = new HashSet<>();
		for (int right = 0; right < str.length(); right++) {
			while (set.contains(str.charAt(right))) {
				set.remove(str.charAt(left));
				left++;
			}
			set.add(str.charAt(right));
			maxlen = Math.max(maxlen, right - left + 1);
		}
		return maxlen;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
	}

}
