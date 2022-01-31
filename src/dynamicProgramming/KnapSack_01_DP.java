package dynamicProgramming;

public class KnapSack_01_DP {

	/* Objective - To get the MAX PROFIT without exceeding bag capacity
	 * Recursive code can be changed into DP code by few changes only
	 * 'capacity' and 'size' are variable parameters
	 * 'weight' and 'value' constant parameters */
	public static void KnapSack(int[] weight, int[] value, int capacity, int size) {
		
		//making 2D array for variable parameters
		int dpArr[][] = new int[size + 1][capacity + 1];
		
		//Base case = Array initialization (check by making table)
		//table of variables(size & capacity) and each element represent OBJECTIVE(max profit)
		for (int i = 0; i < size+1; i++) {
			for (int j = 0; j < capacity+1; j++) {
				if(i==0 || j==0)
					dpArr[i][j] = 0;
			}
		}
		
		// loops to fill 2D array in place of recursion (i-> size, j-> capacity)
		//Loops start from '1' as they were already initialized 
		for (int i = 1; i <size+1; i++){
	        for(int j = 1; j < capacity+1; j++){
	        	if(weight[i-1] <= j)
	        		dpArr[i][j] = Math.max(value[i-1] + dpArr[i-1][j-weight[i-1]],
	        								dpArr[i-1][j]);
	        	else
	        		dpArr[i][j] = dpArr[i-1][j];
	        }
	     }
		 System.out.println(dpArr[size][capacity]);
		}
	
	
	public static void main(String[] args) {
		int[] value = { 60, 100, 120 };
	    int[] weight = { 10, 20, 30 };
	    int capacity = 60;
	    int size = value.length;
	    KnapSack(weight, value, capacity, size);

	}

}
