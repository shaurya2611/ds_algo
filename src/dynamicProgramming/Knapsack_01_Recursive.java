package dynamicProgramming;

public class Knapsack_01_Recursive {

	/* KnapSack is like filling bag with the available elements by making the maximum profit but
	   without exceeding the capacity of bag.
	 * 0_1 knapsack --> Each element available only once 
	 * For each element there are two choice either to take or not, decision made by 
	   considering MAXIMUM value for it
	   
	   Time Complexity: O(2^n)
	   Space Complexity : O(1)
	   */
	public static int knapSack0_1(int size, int[] value, int[] weight, int capacity) {
		// base case
		if(size<0 || capacity<=0)
			return 0;
		
		// Valid element case
		if(weight[size] <= capacity) {
			 // Choice 1--> where element CONSIDERED and added for further processing
			 // Choice 2--> element REJECTED
			 // return max(choice 1 , choice 2)
			return Math.max(value[size] + knapSack0_1(size-1, value, weight, capacity-weight[size]),
					         knapSack0_1(size-1, value, weight, capacity) );
		}
		// Invalid element case move to next element
		else {
			return knapSack0_1(size-1, value, weight, capacity);
		}
	}
	
	
	
	
	
	/* 0_1 KNAPSACK recursively with memorization.	
	    Time Complexity: O(N*W) 
		Auxiliary Space: O(N*W) 
	*/
	public static int knapSack0_1Memoize(int size, int[] value, int[] weight, int capacity,int[][] arr) {
		// base exit condition
		if(size<0 || capacity<=0)
			return 0;
		
		// checking if the value is already present in array (if not equals to -1)
		if(arr[size][capacity]!=-1)
			return arr[size][capacity];
		
		// else solving and storing the result in array "arr" 
		if(weight[size] <= capacity) {
			return arr[size][capacity] = Math.max(value[size] + knapSack0_1Memoize(size-1, value, weight, capacity-weight[size],arr),
					knapSack0_1Memoize(size-1, value, weight, capacity,arr) );
		}else {
			return arr[size][capacity] = knapSack0_1Memoize(size-1, value, weight, capacity,arr);
		}
	}
	public static void knapsackHelper(int size, int[] value, int[] weight, int capacity) {
		int[][] arr = new int[size+1][capacity+1]; // + bcz to store till that no as 0 is also included
		
		/*initializing all elements of array to -1
		 * Always make array of those variables which are NOT CONSTANT in the function parameters.
		   e.g. In above parameters --> 'capacity' and 'size' are changing few fn calls in whole fn.
		        where as all other parameters are remaining constant */
		for (int i = 0; i <size+1 ; i++) {
			for (int j = 0; j <capacity+1 ; j++) {
				arr[i][j] = -1;
			}
		}
		System.out.println(knapSack0_1Memoize(size,value,weight,capacity,arr));
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] value = { 60, 100, 120 };
	    int[] weight = { 10, 20, 30 };
	    int capacity = 65;
	    int size = value.length-1;
	    System.out.println(knapSack0_1(size, value, weight, capacity));
	    knapsackHelper(size, value, weight, capacity);

	}

}
