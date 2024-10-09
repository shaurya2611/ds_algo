package array.hard;

import java.lang.reflect.Array;
import java.util.*;

public class ThreeSum {

/*
Given : array of N integers, your task is to find unique triplets that add up to give a sum of zero.
        In short, you need to return an array of all the unique triplets [arr[a], arr[b], arr[c]] such that i!=j, j!=k, k!=i,
        i.e same element can't be repeated and their sum is equal to zero.

Example: {-1,0,1,2,-1,-4}, Output -> [-1,-1, 2] , [-1, 0, 1]
         {-1,0,1,0}      , Output -> [-1, 0, 1]
*/

    // For all the tuple and find one wiht sum =0 and store tuple in set for unique data
    // Time O(n^3), Space O(n)
    public static void bruteForceApproach(int[] arr){
        Set<List<Integer>> uniqueTuple = new HashSet<>();

        //form all the possible triplet tuple i.e [ _ , _ ,_ ]
        for (int i=0; i<arr.length; i++){
            for (int j = i+1; j < arr.length; j++) {
                for (int k = j+1; k < arr.length; k++) {
                    if(arr[i] + arr[j] + arr[k] == 0){
                        List<Integer> tuple = Arrays.asList(arr[i], arr[j], arr[k]);
                        tuple.sort(null);
                        uniqueTuple.add(tuple);
                    }
                }

            }
        }
    }


    // Using same concept of two sum, sort the array and then find the find two other numbers.
    //Time O(nlogn + n^2), Space O(n)
    public static List<List<Integer>> optimalApproach(int[] nums){
        List<List<Integer>> listTriplets = new ArrayList<>();

        Arrays.sort(nums);// NLogN

        int target = 0;
        for (int i=0; i<nums.length; i++){ // N^2

            //intial check to remove duplicates
            if (i != 0 && nums[i] == nums[i - 1])
                continue;

            int newTar = target - nums[i];// since we have selected one number then new target
            // we have to get two numbers which can make up this new target
            int low = i+1;
            int high = nums.length-1;

            while (low<high && low<nums.length){
                if(nums[low] + nums[high] > newTar){
                    high--;
                } else if (nums[low] + nums[high] < newTar) {
                    low++;
                }else {// nums[low] + nums[high] == newTar
                    List<Integer> zeroSumTriplet = Arrays.asList(nums[i], nums[low], nums[high]);
                    listTriplets.add(zeroSumTriplet);
                    low++;
                    high--;
                    //below code to remove duplicates
                    while(low<high && nums[low]==nums[low-1]){
                        low++;
                    }
                    while(low<high && nums[high]==nums[high+1]){
                        high--;
                    }
                }
            }
        }

        return listTriplets;
    }

    public static void main(String[] args){
        int[] nums = {-1,0,1,0};
//        ThreeSum.bruteForceApproach(nums);
        ThreeSum.optimalApproach(nums);
    }

}
