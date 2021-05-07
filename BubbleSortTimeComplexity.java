package edu.smg;

public class BubbleSortTimeComplexity {
	public static void bubbleSort(int[] list) {
		for (int k = 0; k < list.length - 1; k++) {		//1 + N + N - 1 = 2 * N
			for (int i = 0; i < list.length - 1 - k; i++) {		//N - 1 + x + N - 1 + x -> x = 1 + 2 + 3 +...+ (N - 1)
				if (list[i] > list[i + 1]) {		//3 * x
					// Swap list[i] with list[i + 1]
					int temp = list[i];		//2 * x
					list[i] = list[i + 1];		//2 * x
					list[i + 1] = temp;		//2 * x
				}
			}		//T(N) = 2N + 2N - 2 + 2x + 3x + 6x = 4N - 2 + 11x = 4N - 2 + 11(N - 1 + 1)(N - 1)/2
		}			//T(N) = 4N - 2 + 11N^2/2 - 11/2N = (11/2)N^2 - (3/2)N - 2 = O(N^2)
	}
//		public static void bubbleSort(int[] list) {
//			boolean needNextPass = true;
//			for (int k = 0; k < list.length - 1 && needNextPass; k++) {
//				// Array may be sorted and next pass not needed
//				needNextPass = false;
//				for (int i = 0; i < list.length - k - 1; i++) {
//					if (list[i] > list[i + 1]) {
//						// Swap list[i] with list[i + 1]
//						int temp = list[i];
//						list[i] = list[i + 1];
//						list[i + 1] = temp;
//						needNextPass = true; // Next pass still needed
//					}
//				}
//			}
//		}
}
