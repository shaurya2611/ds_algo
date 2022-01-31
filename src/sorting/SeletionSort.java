package sorting;

import java.util.Scanner;

public class SeletionSort extends CommonMethods {
	
	// Selection Sort - Find  MINIMUM in each iteration and replace from the starting elements
	// Complexity -> average-> O(n^2) , worst -> O(n^2)
	
	public static void selectionSort(int[] arr) {
	    for (int i = 0; i < arr.length-1; i++) {
			int idxMin = i;
			for (int j = i+1; j < arr.length; j++) {
				if(isSmaller(arr, j,idxMin))
					idxMin = j;
			}
			swap(arr, i, idxMin);
		}
	  }
	
	 
	public static void main(String[] args) {
		int[] arr = {5,7,-2,4,1,3};
		    selectionSort(arr);
		    print(arr);
	}


}
