package array.medium;

import java.util.HashMap;

public class CountSubarraySumK {

    /*
   Problem : Given array, find no of subarray whose summation = 3
   e.g. Input  -> {1,2,3,-3,1,1,1,4,2,-3}
        Output -> {1,2}, {3}, {1,2,3,-3}, {1,1,1}, {3,-3,1,1,1}, {4,2,-3}, {-3,1,1,1,4,2,-3}, {2,3,-3,1}
                  i.e. total 8 subarray with sum=3

   Solution : In this approach, we are going to use the concept of the prefix sum to solve this problem. Here,
   the prefix sum of a subarray ending at index i simply means the sum of all the elements of that subarray.

  The steps are as follows:
   1. First, we will declare a map to store the prefix sums and their counts.
   2. Then, we will set the value of 0 as 1 on the map.
   3. Then we will run a loop(say i) from index 0 to n-1(n = size of the array).
   4. For each index i, we will do the following:
        We will add the current element i.e. arr[i] to the prefix sum.
        We will calculate the prefix sum i.e. x-k, for which we need the occurrence.
        We will add the occurrence of the prefix sum x-k i.e. mpp[x-k] to our answer.
        Then we will store the current prefix sum in the map increasing its occurrence by 1.

    using hashing, Time -> O(nlogn), Space -> O(n)
   */


    static int optimalApproach(int[] arr, int k){
        HashMap<Integer,Integer> map = new HashMap();
        map.put(0,1);
        int count = 0 ;
        int prefixSum = 0;
        for (int i = 0; i < arr.length; i++) {
            prefixSum+=arr[i];

            if (map.containsKey(prefixSum - k)){
                count = count + map.get(prefixSum - k);
            }
            if(map.containsKey(prefixSum)){
                map.put(prefixSum, map.get(prefixSum)+1);
            }else{
                map.put(prefixSum, 1);
            }

        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,-3,1,1,1,4,2,-3};
        optimalApproach(arr,3);
    }
}
