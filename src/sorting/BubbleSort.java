package sorting;

public class BubbleSort extends CommonMethods {
	
	/*Swapping with the neighbors
	  Solution   --> In each iteration LARGEST number at the end of array
	  Complexity --> average-> O(n^2) , worst -> O(n^2)*/
	public static void SortingBubble(int[] arr) {
		for (int i = 0; i < arr.length-1; i++) {
			for(int j=0; j<arr.length-i; j++) {
				boolean ans = isSmaller(arr, j, j+1);
				if(ans==false)
					swap(arr, j, j+1);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {5,2,9,7,4,8};
	
		SortingBubble(arr);
		print(arr);
	}

}
