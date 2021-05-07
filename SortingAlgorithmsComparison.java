package edu.smg;

import java.util.Random;

public class SortingAlgorithmsComparison {

	public static void main(String[] args) {
		timeNeeded(50_000);
		timeNeeded(100_000);
		timeNeeded(150_000);
		timeNeeded(200_000);
		timeNeeded(250_000);
		timeNeeded(300_000);
	}
	public static void timeNeeded(int size) {
		System.out.println(size + " elements");
		
		int[] array1 = new int[size];
		int[] array2 = new int[size];
		int[] array3 = new int[size];
		int[] array4 = new int[size];
		int[] array5 = new int[size];
		Random rand = new Random();
		for(int i = 0; i < size; i++) {
			int random = rand.nextInt(500_000);
			array1[i] = random;
			array2[i] = random;
			array3[i] = random;
			array4[i] = random;
			array5[i] = random;
		}
		
		long currentTime = System.currentTimeMillis();
		selectionSort(array1);
		long endTime = System.currentTimeMillis();
		System.out.println("Selection sort: " + (endTime - currentTime));

		currentTime = System.currentTimeMillis();
		insertionSort(array2);
		endTime = System.currentTimeMillis();
		System.out.println("Insertion sort: " + (endTime - currentTime));
		
		currentTime = System.currentTimeMillis();
		bubbleSort(array3);
		endTime = System.currentTimeMillis();
		System.out.println("Bubble sort: " + (endTime - currentTime));
		
		currentTime = System.currentTimeMillis();
		mergeSort(array4);
		endTime = System.currentTimeMillis();
		System.out.println("Merge sort: " + (endTime - currentTime));
		
		currentTime = System.currentTimeMillis();
		quickSort(array5, 0, array5.length - 1);
		endTime = System.currentTimeMillis();
		System.out.println("Quick sort: " + (endTime - currentTime));
		
		System.out.println();
		
	}
	
	public static void selectionSort(int[] list) {
		for (int i = 0; i < list.length - 1; i++) {
// Find the minimum in the list[i..list.length-1]
			int currentMin = list[i];
			int currentMinIndex = i;
			for (int j = i + 1; j < list.length; j++) {
				if (currentMin > list[j]) {
					currentMin = list[j];
					currentMinIndex = j;
				}
			}
// Swap list[i] with list[currentMinIndex] if necessary
			if (currentMinIndex != i) {
				list[currentMinIndex] = list[i];
				list[i] = currentMin;
			}
		}
	}
	
	public static void insertionSort(int[] list) {
		for (int i = 1; i < list.length; i++) {
			/**
			 * Insert list[i] into a sorted sublist
			 *  list[0..i-1] so that list[0..i] is
			 * sorted.
			 */
			int currentElement = list[i];
			int k;
			for (k = i - 1; k >= 0 && list[k] > currentElement; k--) {
				list[k + 1] = list[k];
			}
// Insert the current element into list[k + 1]
			list[k + 1] = currentElement;
		}
	}
	
	public static void bubbleSort(int[] list) {
		boolean needNextPass = true;
		for (int k = 0; k < list.length - 1 && needNextPass; k++) {
			// Array may be sorted and next pass not needed
			needNextPass = false;
			for (int i = 0; i < list.length - k - 1; i++) {
				if (list[i] > list[i + 1]) {
					// Swap list[i] with list[i + 1]
					int temp = list[i];
					list[i] = list[i + 1];
					list[i + 1] = temp;
					needNextPass = true; // Next pass still needed
				}
			}
		}
	}
	
	
	public static void mergeSort(int[] list) {
		if (list.length > 1) {
// Merge sort the first half
			int[] firstHalf = new int[list.length / 2];
			System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
			mergeSort(firstHalf);
// Merge sort the second half
			int secondHalfLength = list.length - list.length / 2;
			int[] secondHalf = new int[secondHalfLength];
			System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);
			mergeSort(secondHalf);
// Merge firstHalf with secondHalf into list
			merge(firstHalf, secondHalf, list);
		}
	}

	/** Merge two sorted lists */
	public static void merge(int[] list1, int[] list2, int[] temp) {
		int current1 = 0;
		int current2 = 0;
		int current3 = 0;

		while (current1 < list1.length && current2 < list2.length) {
			if (list1[current1] < list2[current2])
				temp[current3++] = list1[current1++];
			else
				temp[current3++] = list2[current2++];
		}
		while (current1 < list1.length)
			temp[current3++] = list1[current1++];
		while (current2 < list2.length)
			temp[current3++] = list2[current2++];
	}
	
	public static void quickSort(int[] list, int first, int last) {
		if (last > first) {
			int pivotIndex = partition(list, first, last);
			quickSort(list, first, pivotIndex - 1);
			quickSort(list, pivotIndex + 1, last);
		}
	}

	/** Partition the array list[first..last] */
	public static int partition(int[] list, int first, int last) {
		int pivot = list[first]; // Choose the first element as the pivot
		int low = first + 1; // Index for forward search
		int high = last; // Index for backward search
		while (high > low) {
// Search forward from left
			while (low <= high && list[low] <= pivot)
				low++;
//Search backward from right
			while (low <= high && list[high] > pivot)
				high--;
//Swap two elements in the list
			if (high > low) {
				int temp = list[high];
				list[high] = list[low];
				list[low] = temp;
			}
		}
		while (high > first && list[high] >= pivot)
			high--;
//Swap pivot with list[high]
		if (pivot > list[high]) {
			list[first] = list[high];
			list[high] = pivot;
			return high;
		} else {
			return first;
		}
	}

}
