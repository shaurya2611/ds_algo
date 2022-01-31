package sorting;

public class InsertSort extends CommonMethods {

	/*Solution -> Starting from left keep moving right element wise with keeping all the 
	              elements at left sorted. Taking new element and keeping it in sorted position in left
	 Complexity -> average-> O(n^2) , worst -> O(n^2)*/
	public static void insertionSort(int[] arr) {
	    for (int i = 0; i < arr.length-1; i++) {
			if(arr[i] > arr[i+1]) {
				int a=i; int b =i+1;
				while(a>=0) {
					if(isSmaller(arr, b, a)) {
						swap(arr, a, b);
						a--; 
						b--;
					}
					else
						break;
				}		
			}
		}
	    
	  }
	
	public static void main(String[] args) {
		int[] arr = {4,33,27,-10,35};
		
		insertionSort(arr);
		print(arr);

	}

}
