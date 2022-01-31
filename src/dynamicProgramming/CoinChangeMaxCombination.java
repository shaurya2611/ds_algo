package dynamicProgramming;

public class CoinChangeMaxCombination {

	/*--------------COIN CHANGE MAX NO WAYS TO GET A SUM (given infinite supply of coins)--------------
	 * Sol - Given infinite supply of coins, hence unbounded knapsack
	 * WE have to make a change by adding coins and found the max possible combinations
	 * thus SUBSET SUM COUNT logic 
	 * Here max combinations asked not permutation
	 * e.g. Valid combinations --> {2,2,3} , {2,5} 
	 *      Valid permutation  --> {2,2,3} , {3,2,2}, {2,3,2}, {2,5}, {5,2}*/
	public static int coinChangeWays(int[] coins, int sum, int size) {
		
		if(sum==0)
			return 1;
		if(size==0)
			return 0;
		
		if(coins[size-1] <= sum)
			return coinChangeWays(coins, sum - coins[size-1], size) + coinChangeWays(coins, sum, size-1);
		else
			return coinChangeWays(coins, sum, size-1);
	}
	
	
	public static void main(String[] args) {
		int[] coins = {2, 5, 3};
		int size = coins.length;
		int sum = 7;
		System.out.println(coinChangeWays(coins, sum, size));

	}

}
