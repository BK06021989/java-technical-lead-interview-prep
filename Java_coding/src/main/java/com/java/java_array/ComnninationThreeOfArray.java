package com.java.java_array;

public class ComnninationThreeOfArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1, 2, 3, 4, 5, 6, 9, 10};
		int target=11;
		for(int i=0;i<arr.length;i++) {
			int left=i+1;
			int right=arr.length-1;
			while(left<right) {
				int sum=arr[i]+arr[left]+arr[right];
				if(target==sum) {
					System.out.println(arr[i]+","+arr[left]+","+arr[right]);
					left++;
					right--;
				}else if(sum<target) {
					left++;
				}else {
					right--;
				}
			}
		}
	}

}
