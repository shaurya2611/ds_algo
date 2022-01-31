package dynamicProgramming;


public class CoinChnageMinCoinsReq {

	/*---------------MINIMUM NO OF COINS REQUIRED TO MAKEUP SUM----------------------
	 * 
	 * Given a value V, if we want to make change for V cents, and we have infinite supply 
	 * of each of C = { C1, C2, .. , Cm} valued coins, what is the minimum number of coins 
	 * to make the change? If it’s not possible to make change, print -1.*/
	
	// ONLY DP ques in which 2nd row is also initialized.
	public static int coinChangeMinReq(int[] coins, int size, int sum) {
		
		int[][] dpArr = new int[size+1][sum+1];
	
		// 1st ROW initialization with MAX_VALUE
		for (int i = 0; i < sum+1; i++)
			dpArr[0][i] = Integer.MAX_VALUE-1;
		// 1st COLUMN initialization with 0
		for (int i = 1; i < size+1; i++)
			dpArr[i][0] = 0;
		// 2nd ROW initialization --
		// If first element of array is fully divide fill by quotient else by MAX_VALUE-1
		for (int i = 1; i < sum+1; i++) {
			if(i%coins[0]==0) 
				dpArr[1][i] = i/coins[0];
			else
				dpArr[1][i] = Integer.MAX_VALUE-1;
		}
		
		// same logic of unbounded knapsack wit minimum amount to consider
		for (int i = 2; i < size+1; i++) { // i-> size , j-> capacity
			for (int j = 1; j < sum+1; j++) {
				if(coins[i-1] <= j)
					dpArr[i][j] = Math.min(1 + dpArr[i][j-coins[i-1]], dpArr[i-1][j]);
				else
					dpArr[i][j] = dpArr[i-1][j];
					
			}
		}
		return dpArr[size][sum];
	}
	
	
	public static void main(String[] args) {
		int[] coins = {1,3,9,5,6};
		int size = coins.length;
		int sum = 11;
		System.out.println(coinChangeMinReq(coins, size, sum));

	}

}
