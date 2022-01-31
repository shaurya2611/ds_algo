package sorting;

public class QuickSort {
	
	/* It is based on PIVOTING algo. When array get partitioned using PIVOT the position 
	 * of pivoted element in array get fixed
	 * Sol - Idea is to apply PARTITION on every element of array starting from last element
	 * Complexity - avg-> O(nlogn) , worst -> O(n^2)*/
	public static void quickSort(int[] arr, int lo, int hi) {
		//base case
		if(lo>hi)
			return;		
		//induction
	    int pivot = arr[hi]; //starting from last element
	    int pivotIndex = partition(arr, pivot, lo, hi);// get index of pivot element
	    // Hypothesis
	    quickSort(arr, lo, pivotIndex-1);
	    quickSort(arr, pivotIndex+1, hi);
	    
	  }

	  public static int partition(int[] arr, int pivot, int lo, int hi) {
	    System.out.println("pivot -> " + pivot);
	    int i = lo, j = lo;
	    while (i <= hi) {
	      if (arr[i] <= pivot) {
	        swap(arr, i, j);
	        i++;
	        j++;
	      } else {
	        i++;
	      }
	    }
	    System.out.println("pivot index -> " + (j - 1));
	    return (j - 1);
	  }

	  // used for swapping ith and jth elements of array
	  public static void swap(int[] arr, int i, int j) {
	    System.out.println("Swapping " + arr[i] + " and " + arr[j]);
	    int temp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = temp;
	  }

	  public static void print(int[] arr) {
	    for (int i = 0; i < arr.length; i++) {
	      System.out.print(arr[i] + " ");
	    }
	    System.out.println();
	  }

	  public static void main(String[] args) throws Exception {
	    int[] arr = {6,8,2,0,9,4};
	    quickSort(arr, 0, arr.length - 1);
	    print(arr);
	  }


}
