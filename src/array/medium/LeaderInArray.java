package array.medium;

import java.util.ArrayList;
import java.util.List;

public class LeaderInArray {

    /*
    Given an array, print all the elements which are leaders.
        A Leader is an element, everything on the right should be smaller.
        Last element of array is always a leader element
    Example: {10,22,12,3,0,6}  , Output -> {22,12,6}

    */


    // As per the definition of leader, take a element and check if all its elemnts are smaller than it or not
    // Time O(n^2), Space O(n) for storing ans
    public static List<Integer> bruteForceApproach(int[] arr){
        List<Integer> leaders = new ArrayList<>();
        leaders.add(arr[arr.length-1]); // last element always a leader
        for (int i=0; i<arr.length-1;i++){
            boolean flag = true;
            for (int j=i+1; j<arr.length; j++){
                if(arr[i] < arr[j]){
                    flag = false;
                    break;
                }
            }
            if (flag==true){
                leaders.add(arr[i]);
            }
        }

        return leaders;
    }



    /*
    * Traversal of array form back
    * First, we'll start the traversal from the right. Then, we move toward the left. Whenever we encounter a new element,
      we check with the greatest element obtained so far.
    * If the current element is greater than the greatest so far, then the current element is one of the leaders and we update
      the greatest element */
    public static ArrayList<Integer> optimalApproach(int[] arr){
        int n = arr.length;
        ArrayList<Integer> ans= new ArrayList<>();

        // Last element of an array is always a leader,
        // push into ans array.
        int max = arr[n - 1];

        ans.add(arr[n-1]);

        // Start checking from the end whether a number is greater
        // than max no. from right, hence leader.
        for (int i = n - 2; i >= 0; i--)
            if (arr[i] > max) {
                ans.add(arr[i]);
                max = arr[i];
            }

        return ans;
    }

    public static void main(String[] args){
        int[] arr= {10,22,12,3,0,6};
        LeaderInArray.bruteForceApproach(arr);
    }
}
