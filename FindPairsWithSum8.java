package edu.smg;

import java.util.HashSet;

public class FindPairsWithSum8 {

	public static void main(String[] args) {
		int sum = 6;
		int[] array = {-1, 6, 2, 3, 4, 5};
		int[] sortedArray = {1, 2, 4, 4, 5};
		solution1(array, sum);
		binarySearchSolution(sortedArray, sum);
		searchInBothEnds(sortedArray, sum);
		hashSetSolution(array, sum);
	}
	
	public static void solution1(int[] array, int sum) {
		for(int i = 0; i < array.length; i++) {
			for(int j = i + 1; j < array.length; j++) {
				if(array[i] + array[j] == sum) {
					System.out.println(array[i] + " + " + array[j] + " = " + sum);
					return;
				}
			}
		}
		System.out.println("No such pairs in the array");
	}
	
	
	public static void binarySearchSolution(int[] array, int sum) {
		for(int i = 0; i < array.length; i++) {
			int s = binarySearch(array, sum - array[i]);
			if(s > -1) {
				System.out.println(array[i] + " + " + array[s] + " = " + sum);
				return;
			}
		}
		System.out.println("No such pairs in the array");
	}
	
	public static int binarySearch(int[] list, int key) {
		int low = 0;
		int high = list.length - 1;
		while (high >= low) {
			int mid = (low + high) / 2;
			if (key < list[mid])
				high = mid - 1;
			else if (key == list[mid])
				return mid;
			else
				low = mid + 1;
		}
		return -1;
	}
	
	public static void searchInBothEnds(int[] array, int sum) {
		int low = 0;
		int high = array.length - 1;
		while(low < high) {
			int s2 = array[low] + array[high];
			if(s2 > sum)
				high--;
			else if(s2 < sum)
				low++;
			else {
				System.out.println(array[low] + " + " + array[high] + " = " + sum);
				return;
			}
		}
		System.out.println("No such pairs in the array");
	}
	
	public static void hashSetSolution(int[] array, int sum) {
		HashSet<Integer> comp = new HashSet<Integer>();
		for(int n: array) {
			if(comp.contains(n)) {
				System.out.println(n + " + " + (sum - n) + " = " + sum);
				return;
			}
			comp.add(sum - n);
		}
		System.out.println("No such pairs in the array");
	}
}
