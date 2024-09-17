package array.medium;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
 /*
  * Problem Statement: Given an array of integers arr[] and an integer target.
  * 1st variant: Return YES if there exist two numbers such that their sum is equal to the target.
    Otherwise, return NO.
  * 2nd variant: Return indices of the two numbers such that their sum is equal to the target.
    Otherwise, we will return {-1, -1}. */


    // Using brute force approach, For each element of the given array, we will try to search for another
    // element such that its sum is equal to the target. If such two numbers exist, we will return the indices or “YES” accordingly
    //  Time -> O(n^2), Space -> O(1)
    public static boolean bruteForceSolution(int[] arr, int target){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target){
                    System.out.println("Target Sum : "+arr[i]+ " and "+arr[j]);
                    return true;
                }
            }
        }
        return false;
    }


    /*  Basically, in the previous approach we selected one element and then searched for the other one
        using a loop. Here instead of using a loop, we will use the HashMap to check if the other element
        i.e. target-(selected element) exists.
        using hashing, Time -> O(nlogn), Space -> O(n)  // logn for map sarch operation
    */
    public static void betterSolution(int[] arr, int target){
        HashMap hashMap = new HashMap();
        for (int i = 0; i < arr.length; i++) {
            if(hashMap.containsKey(target-arr[i])){
                System.out.println("Target Sum : "+arr[i]+ " and "+ (target-arr[i]));
                return;
            }else{
                hashMap.put(arr[i],i);
            }
        }
        System.out.println("No such two pair exist!!");
    }


    /* Without using hashmap --> Sorting and using two pointer
    n this approach, we will first sort the array and will try to choose the numbers in a greedy way.
    We will keep a left pointer at the first index and a right pointer at the last index. Now until left < right,
    we will check the sum of arr[left] and arr[right]. Now if the sum < target, we need bigger numbers and so we
    will increment the left pointer. But if sum > target, we need to consider lesser numbers and so we will decrement the right pointer.
    * */
    public static void optimalSolution(int[] arr, int targetSum){
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length-1;
        while(left < right){
            int sum = arr[left] + arr[right];
            if (sum == targetSum){
                System.out.println("Target Sum : "+arr[left]+ " and "+ arr[right]);
                return;
            }else if (sum > targetSum){
                right--;
            }else{
                left++;
            }
        }
        return;
    }

    public static void main(String[] args){
        int[] arr = {2,6,5,8,1};
        int targetSum = 14;
//        betterSolution(arr, targetSum);
        optimalSolution(arr,targetSum);
    }
}
