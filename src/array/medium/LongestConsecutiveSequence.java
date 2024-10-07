package array.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {


    /*
    Given : array of ‘N’ integers. You need to find the length of the longest sequence which contains the consecutive elements.
            elements may or may not be present in sequence and can be repeated
    Example: [100, 4, 200, 1, 3, 2, 3, 4] , Output -> 4  i.e. {1,2,3,4}
             [9, 3, 8, 5, 7, 6, 6],         Output -> 5  i.e. {5,6,7,8,9}
    */

    // Better approach: sort the array, then find the consecutive sequence
    // Time -> O(nlogn + n), Space -> O(1)
    public static int betterApproach(int[] arr){
        Arrays.sort(arr);
        int longestConsSeq = 0;
        int count = 1;
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i+1] - arr[i]==0){
                continue;
            } else if (arr[i+1] - arr[i]==1) {
                count++;
            }else {
                longestConsSeq = Math.max(longestConsSeq, count);
                count = 1;
            }
        }
        return Math.max(longestConsSeq, count);
    }

/* Optimal Approach : Using hash data set and then finding the
   Algo :
   * First, we will put all the array elements into the set data structure.
   * For every element, x, that can be a starting number(i.e. x-1 does not exist in the set) we will do the following:
     We will set the length of the current sequence(cnt) to 1.
   * Then, again using the set, we will search for the consecutive elements such as x+1, x+2, and so on, and find the maximum
     possible length of the current sequence. This length will be stored in the variable ‘cnt’.
   *  After that, we will compare ‘cnt’ and ‘longest’ and update the variable ‘longest’ with the maximum value
     (i.e. longest = max(longest, cnt)).
   * Finally, we will have the answer i.e. ‘longest’.
* */
    // Time -> O(n + n), Space -> O(n)
    public static int optimalApproach(int[] arr){
        int n = arr.length;
        if (n == 0)
            return 0;

        int longest = 1;
        Set<Integer> set = new HashSet<>();

        // put all the array elements into set
        for (int i = 0; i < n; i++) {
            set.add(arr[i]);
        }

        // Find the longest sequence
        for (int element : set) {
            // if 'element' is a starting number
            if((set.contains(element-1))){
                continue;
            }
            else {
                // find consecutive numbers
                int cnt = 1;
                int x = element;
                while (set.contains(x + 1)) {
                    x = x + 1;
                    cnt = cnt + 1;
                }
                longest = Math.max(longest, cnt);
            }
        }
        return longest;
    }



    public static void main(String[] args){
        int[] arr = {1,2,3,1,1,2,4,6,8,4,6,5,9,10};
//        int ans = LongestConsecutiveSequence.betterApproach(arr);
        int ans = LongestConsecutiveSequence.optimalApproach(arr);
        String s = "";
    }

}
