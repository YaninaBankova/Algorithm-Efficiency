package edu.smg;

import java.util.LinkedList;
import java.util.Scanner;

public class MaxIncreasingSymbols {
	
 public static void main(String[] args){
	 //O(n^2)
	 Scanner sc = new Scanner(System.in);
		System.out.println("Enter a string:");
		String str = sc.nextLine();
		sc.close();
		LinkedList<Character> max = new LinkedList<Character>();
		for(int i = 0; i < str.length(); i++) {
			LinkedList<Character> list = new LinkedList<Character>();
			list.add(str.charAt(i));
			for(int j = i + 1; j < str.length(); j++) {
				if(list.getLast() < str.charAt(j)) {
					list.add(str.charAt(j));
				}
			}
			if(max.size() < list.size()) {
				max.clear();
				max.addAll(list);
			}
		}
		System.out.println(max);
 }
}
