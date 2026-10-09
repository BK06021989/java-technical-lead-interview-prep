package com.java.java_array;

import java.util.*;

public class MinCommonValueFromTwoArray {
	public static int getCommon(int[] nums1, int[] nums2) {
		Set<Integer> set = new HashSet<>();

		for (int num : nums1) {
			set.add(num);
		}

		for (int num : nums2) {
			if (set.contains(num)) {
				return num;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = { 1, 2, 3 ,5}, nums2 = { 2,3,4 };
		System.out.println(getCommon(nums1, nums2));
	}

}
