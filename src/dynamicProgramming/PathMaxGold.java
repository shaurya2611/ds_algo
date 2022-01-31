package dynamicProgramming;

public class PathMaxGold {

	/* Given 2D array, select the path that give max parg --> starting from extreme left of matrix 
	 * any position till till the extreme right any position
	 * Possible movement --> Horizontal one step, Diagonal down and Diagonal upward one step */
	
	public static int maxGoldPath(int[][] arr, int row, int column) {
		
		// An element of dpArr represent -->If started from that element max Gold it has collected before reaching extreme right
		int[][] dpArr = new int[row][column];
		
		//Initializing last column same as original array by above meaning.
		for (int i = 0; i < row; i++)
			dpArr[i][column-1] = arr[i][column-1];
		
		// Traversal column wise, since last column is initialized
		for(int j = column-2; j>= 0; j--) {
			for (int i = row-1; i >= 0; i--) {
				if(i==row-1)
					dpArr[i][j] = Math.max(dpArr[i][j+1], dpArr[i-1][j+1]) + arr[i][j];
				else if(i==0)
					dpArr[i][j] = Math.max(dpArr[i][j+1], dpArr[i+1][j+1]) + arr[i][j];
				else
					dpArr[i][j] = Math.max(dpArr[i][j+1],Math.max(dpArr[i-1][j+1], dpArr[i+1][j+1])) + arr[i][j];
			}
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i <row; i++)
			max = Math.max(max, dpArr[i][0]);
		
		return max;
	}
	
	public static void main(String[] args) {
		int[][] arr = {{0,6,0},{5,8,7},{0,9,0}};
		int row = arr.length;
		int column = arr[0].length;
		System.out.println(maxGoldPath(arr, row, column));

	}

}
