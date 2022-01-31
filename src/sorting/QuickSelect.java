package sorting;

public class QuickSelect {

	//Using PARTITION Algorithm, finding the nth smallest/largest no ion the array
	/* Sol - Using PARTITION algorithm, will get the exact position of the element in the array
	 * Compare the required position with the found position of element and accordingly apply PARTITION again */
	public static int quickSelect(int[] arr, int lo, int hi, int k) {
		int pivot = arr[hi];
		int pivotIdx = partition(arr, pivot, lo, hi);
		
		if(pivotIdx > k) {
			return quickSelect(arr, lo, pivotIdx-1, k);
		}else if(pivotIdx < k) {
			return quickSelect(arr, pivotIdx+1,hi , k);
		}else // if(pivotIdx ==k) {
			return arr[pivotIdx];
	    
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
	    int[] arr = {7,9,1,4,2,0,5};
	    int k =4;
//	    System.out.println(quickSelect(arr,0,arr.length - 1,k - 1));
	  }
}
