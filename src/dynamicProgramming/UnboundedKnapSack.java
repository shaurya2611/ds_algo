package dynamicProgramming;

public class UnboundedKnapSack {

	/* In Unbounded knapsack repetition of element is allowed, unlike 0_1 knapsack where 
	each element can be used on be used only once*/
	public static int unboundedKnapSack(int[] arr, int[] value,int capacity, int size) {
		
		if(capacity==0)
			return 0;
		if(size==0)
			return 0;
		
		if(arr[size-1] <= capacity) {
			return Math.max(value[size-1] + unboundedKnapSack(arr, value, capacity - arr[size-1], size) ,
					        unboundedKnapSack(arr, value, capacity, size-1) );
		}
		else {
			return unboundedKnapSack(arr, value, capacity, size-1);
		}
	}
	
	
	public static int unboundedKnapSackDP(int[] arr, int[] value, int capacity, int size) {
		
		int[][] dpArr = new int[size+1][capacity+1];
		
		// Array initialize (base condition)
		for (int i = 0; i < size+1; i++) {
			for (int j = 0; j < capacity+1; j++) {
				if(i==0 || j==0)
					dpArr[i][j] = 0; 
			}
		}
		
		for (int i = 1; i < size+1; i++) { // i-> size , j-> capacity
			for (int j = 1; j < capacity+1; j++) {
				if(arr[i-1] <= j)
					dpArr[i][j] = Math.max(value[i-1] + dpArr[i][j-arr[i-1]], dpArr[i-1][j]);
				else
					dpArr[i][j] = dpArr[i-1][j];
					
			}
		}
		return dpArr[size][capacity];
	}
	
	public static void main(String[] args) {
		int[] arr = {10,5,7,2};
		int[] value = {10,50,40,2};
		int size = arr.length;
		int capacity = 9;
		System.out.println(unboundedKnapSack(arr, value, capacity, size));
		System.out.println(unboundedKnapSackDP(arr, value, capacity, size));

	}

}
