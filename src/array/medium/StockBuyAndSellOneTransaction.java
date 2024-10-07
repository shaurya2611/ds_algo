package array.medium;

public class StockBuyAndSellOneTransaction {

    /*
    * Given: array of prices where prices[i] is the price of a given stock on an ith day.
             maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that
             stock. Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

      Example: prices = [7,1,5,3,6,4], output = 5 (buy:1, sell:6)
               prices = [7,6,4,3,1] , output = 0

      Solution: 1 (Brut Force)  simply use 2 loops and track every transaction and maintain a variable maxPro to contain the max value among all transactions.
                  Time -> O(n^2) , Space -> (1)

      Solution: 2 (Linear Traversal) Aim is to maximize profit, On each traversal
                  Maintain a minimum from the start of the array and compare it with every element of the array, if it is greater
                  than the minimum then take the difference and maintain it in max, otherwise update the minimum.
                  Time -> O(n^2) , Space -> (1)
    */

    public int optimalApproach(int[] arr){
        int maxPro = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            minPrice = Math.min(minPrice, arr[i]);
            maxPro = Math.max(maxPro, arr[i] - minPrice);
        }
        return maxPro;
    }
}
