package hashing;

import java.util.HashMap;

public class LargestSubArraySumK {
/* SUBARRAY - sub-array are always continuous set of elements from the array
    No of subarray = n(n+1)/2
    no of subsequences = 2^n

     Problem :  Given an array arr containing n integers and an integer k.
                Your task is to find the length of the longest Sub-Array with the sum of the
                elements equal to the given value k.

        Input : arr[] = {10, 5, 2, 7, 1, 9}, k = 15
        Output : 4 , sub-array is {5, 2, 7, 1}

        Input : arr[] = {-1, 2, 3}, k = 6
        Output : 0 , There is no such sub-array with sum 6.
    */

    public static void hasingSumK(int[] arr, int sumK){
    // array --{    3,  9,  -2,     4,  1,  7,  2,  6,  -5,     8,  3,  -7,     6,  2,  1  }
    // k = 5
    // sum --    0, 3,  12,  10,   14,  15
        HashMap<Integer,Integer> hm = new HashMap<>();
        int sum = 0;
        hm.put(0,1);
        int noOfSubarray = 0;
        for (int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(hm.containsKey(sum-sumK)){
                noOfSubarray++;
            }else {
                hm.put(sum,1);
            }
        }
    }
}
