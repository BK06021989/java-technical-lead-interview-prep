package com.java.java_basiclogical;

import java.util.*;

public class Fibonacci 
{
	public static List<Long> fibonacci(int num){
		List<Long> result=new ArrayList<>();
			long a=0,b=1;
		for(int i=0;i<=num;i++){
			result.add(a);
			long c=a+b;
			a=b;
			b=c;
		}
		return result;
	}
	public static void main(String[] args) 
	{
		System.out.println(fibonacci(7));//[0, 1, 1, 2, 3, 5, 8, 13]
	}
}

