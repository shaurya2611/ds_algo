package array;

public class StockBuyOneTransaction {

	/* Given array of stock prices for each day
	 * 
	 * Calculate the maximum profit that can be gained by making one transaction only
	 * Solution -  Analyze by making graph*/
	
	public static int stockOneTransaction(int[] arr) {
		int profit = 0;
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] < min)
				min = arr[i];
			
			int currentProfit = arr[i] - min;
			if(currentProfit > profit)
				profit = currentProfit;
		}
		
		return profit;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
