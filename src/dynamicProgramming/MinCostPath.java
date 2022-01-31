package dynamicProgramming;

public class MinCostPath {

	/* Given a 2D array each, To each from (0,0) to (m,n) find the minimum cost path
	 * Movement possible --> Vertical, horizontal and diagonal*/
	
	
	public static int minCostPathRecursive(int[][] arr, int row, int column) {
		
		// bAse case
		if(row==0 && column==0)
			return arr[row][column];
		if(row<0 || column<0)
			return Integer.MAX_VALUE;
		
		//Hypothesis
		int recCost = Math.min(minCostPathRecursive(arr, row-1, column), 
				Math.min(minCostPathRecursive(arr, row, column-1), minCostPathRecursive(arr, row-1, column-1)));
		
		//Induction
		return arr[row][column] + recCost;
	}
	
	public static int minCostPathDP(int[][] arr, int row, int column) {
		int dpArr[][] = new int[row][column];
		
		
		for (int i = row-1; i >=0; i--) {
			for (int j = column-1; j >= 0; j--) {
				if(i==row-1 && j==column-1)
					dpArr[i][j] = arr[i][j];
				else if(i == row-1)
					dpArr[i][j] = arr[i][j] + dpArr[i][j+1];
				else if(j == column-1)
					dpArr[i][j] = arr[i][j] + dpArr[i+1][j];
				else
					dpArr[i][j]  = arr[i][j] + Math.min(dpArr[i+1][j], dpArr[i][j+1]);
			}
		}
		return dpArr[0][0]; 
	}
	
	public static void main(String[] args) {
		int[][] arr =  {{1,2,3},
						{4,8,2},
						{1,5,3}};
		int row = arr.length;
		int column = arr[0].length;
		System.out.println(minCostPathRecursive(arr, row-1, column-1));
		System.out.println(minCostPathDP(arr, row, column));

	}

}
