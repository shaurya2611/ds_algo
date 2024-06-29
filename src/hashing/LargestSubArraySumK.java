package hashing;

import java.util.HashMap;
/* Subarray : contiguous part of an array. This means all the elements of the subarray appear
				  in the same order as in the original array and are next to each other.
		No of subarray = n(n+1)/2
		Subarray of [1, 2, 3] = [1], [1,2], [1,2,3], [2], [2,3], [3]

	   Subset : A subset is any combination of elements from an array, regardless of their order and contiguity.
	   			This includes the empty set and the set itself.
		no of subsequences = 2^n
		Subset of [1,2,3] = [], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]
	*/
public class LargestSubArraySumK {


     /*Problem :  Given an array arr containing n integers and an integer k.
                Your task is to find the length of the longest Sub-Array with the sum of the
                elements equal to the given value k.

        Input : arr[] = {10, 5, 2, 7, 1, 9}, k = 15
        Output : 4 , sub-array is {5, 2, 7, 1}

        Input : arr[] = {-1, 2, 3}, k = 6
        Output : 0 , There is no such sub-array with sum 6.
    */

    //Using hashing with unordered map: Time o(n) and space O(n)
    public static int largestSubArraySumKBetterSolution(int[] arr, int k){
       int sum = 0;
       int largestLengthSubarray = 0;
       HashMap<Integer, Integer> hashMap = new HashMap<>();
       hashMap.put(0,0);
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            if (sum == k){
                largestLengthSubarray = Math.max(i+1, largestLengthSubarray);
            }
            if(!hashMap.containsKey(sum)){
                hashMap.put(sum, i);
            }
            if (hashMap.containsKey(sum - k)){
                int currentLengthSubarray = i - hashMap.get(sum - k)  ;
                largestLengthSubarray = Math.max(currentLengthSubarray, largestLengthSubarray);
            }
        }
        return largestLengthSubarray;
    }

    /*
    * Using sliding window : two pointer to traverse throu the array
    *  Time o(n) and space O(1)
    * */
    public static int largestSubArraySumKOptimalSolution(int a[], int k){
        int left = 0, right = 0;
        long sum = a[0];
        int maxLen = 0;
        int n = a.length;

        while (right < n) {
            while (left <= right && sum > k) {
                sum -= a[left];
                left++;
            }
            if (sum == k)
                maxLen = Math.max(maxLen, right - left + 1);

            right++;
            if (right < n)
                sum += a[right];
        }
        return maxLen;
    }


    public static void main(String[] args){
        int[] arr  = {-1, 2, 3,0,0,1}; int k = 6;
        System.out.println(largestSubArraySumKOptimalSolution(arr,k));
    }
}
