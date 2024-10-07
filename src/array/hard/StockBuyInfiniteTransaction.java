package array.hard;

public class StockBuyInfiniteTransaction {

	/* Given array of stock prices for each day
	 * Calculate the maximum profit that can be gained by making infinite transaction only
	 * 
	 * Solution -  Analyze by making graph, for each upward line profit is calculated, Buy and sell is alternate
	 * BUY at each LOCAL minimal
	 * SELL after each GLOBAL maximal*/
	
	public static int stockOneTransaction(int[] arr) {		
		int finalProfit = 0;	
		for (int i = 0; i < arr.length-1; i++) {
			if(arr[i+1] >  arr[i])
				finalProfit+=arr[i+1] - arr[i];			
			}
		return finalProfit;
	}
	
	public static int stockSell(int[] arr) {
		int buy = 0;
		int sell = 0;
		int profit = 0;
		for (int i = 1; i < arr.length; i++) {
			if(arr[i] > arr[i-1]) {
				sell = i;
			}
			else {
				profit+=arr[sell] - arr[buy];
				buy = i;
				sell = i;
			}
		}
		profit+=arr[sell] - arr[buy];
		return profit;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,8,5,6,9,12,20,16,11};
		System.out.println(stockOneTransaction(arr));
		System.out.println(stockSell(arr));

	}

}
