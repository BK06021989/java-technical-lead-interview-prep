package com.java.java_array;

import java.util.*;

public class AnagramGroupExample {
	public static Map<String, List<String>> AnagramGroup(String[] input){
		Map<String, List<String>> map=new HashMap<>();
		List<String> list=new ArrayList<>();
		for(String str:input){
			char[] charStr=str.toLowerCase().toCharArray();
			Arrays.sort(charStr);
			list.add(new String(charStr));
		}
		for(String strList:list){
					List<String> listWord=new ArrayList<>();
			for(int i=0;i<=list.size()-1;i++){
				if(strList.equals(list.get(i))){
					listWord.add(strList);
				}
			}
			map.put(strList,listWord);
		}
		return map;

	}
	public static void main(String[] args) {
		//System.out.println(AnagramGroup(input));
				//output {aet=[aet, aet, aet], abt=[abt], ant=[ant, ant]}
				
		String[] input = { "eat", "tea", "tan", "ate", "nat", "bat" };
		
		Map<String, List<String>> map = new HashMap<>();

		for (String word : input) {

			char[] chars = word.toCharArray();
			Arrays.sort(chars);

			String key = new String(chars);

			//map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
			if (!map.containsKey(key)) {
			    map.put(key, new ArrayList<>());
			}
			map.get(key).add(word);
		}
		System.out.println(new ArrayList<>(map.values()));
		// output=[[eat, tea, ate], [bat], [tan, nat]]
	}
}
