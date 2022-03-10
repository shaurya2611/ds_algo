package hashing;

import java.util.HashMap;

public class LargestSubArraySumK {

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
