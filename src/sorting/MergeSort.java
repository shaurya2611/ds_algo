package sorting;

public class MergeSort extends MergeSortedArray{

	// Complexity -> average-> O(nlogn) , worst -> O(nlogn)
	public static int[] mergeSort(int[] arr, int lo, int hi) {
		  if(lo==hi) {//i.e.e only one element in array
			 int[] ans = new int[1]; //array of size 1 in base case as only one element in array
			 ans[0] = arr[lo]; // or arr[hi]
			 return ans;
		  }
		  int mid = (hi+lo)/2;
		  int[] a = mergeSort(arr, lo, mid);
		  int[] b = mergeSort(arr, mid+1, hi);
		  int[] ans = mergeTwoSortedArrays(a, b);
		  return ans;
	}
	 
	public static void main(String[] args) {
		int[] arr = {30,-78,43,1,9,8};
		int[] ans = mergeSort(arr, 0, arr.length-1);
	    print(ans);

	}

}
