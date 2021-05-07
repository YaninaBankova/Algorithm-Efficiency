package edu.smg;

import java.util.Scanner;

public class ContainsOtherString {
	public static void main(String[] args) {
		//O(n)
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a string s1:");
		String s1 = sc.nextLine();
		System.out.println("Enter a string s2:");
		String s2 = sc.nextLine();
		sc.close();
		
		int index = -1;
		int count = 0;
		for(int i = 0; i <= s1.length(); i++) {
			if(s1.charAt(i) == s2.charAt(0) && count == 0) {
				index = i;
				count++;
			} else if(s1.charAt(i) == s2.charAt(count)) {
				count++;
			} else if (count != 0){
				i-=count;
				count = 0;
				
			}
			if(count == s2.length())
				break;
		}
		
		if(count == s2.length()) {
			System.out.println("matched at index " + index);
		} else {
			System.out.println("s2 is not a substring of s1");
		}
	}
}
