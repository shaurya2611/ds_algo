package array.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class RemoveDuplicateFromSortedArray {

     //Using Set: place all element in set, result in unique element only
    //Time Complexity : O(nlogn) + O(n) and Space : O(n)

    public static void bruteForceApproachUsingSet(int[] arr){
        // Using a HashSet to keep track of unique elements (O(n) time, O(n) space)
        Set<Integer> uniqueSet = new HashSet<>();
        for (int element: arr){
            uniqueSet.add(element);
        }

        // Iterate over the elements using the iterator : O(n)
        // Copy unique elements back to the original array
        int index = 0;
        for (int element : uniqueSet) {
            arr[index++] = element; // Add unique elements to the array
        }
        // Fill remaining elements in the array with zero
        while (index < arr.length) {
            arr[index++] = 0;
        }
    }

    /*
    *  Using two pointer Approach: Since the array is sorted, compare element with its immediate next
    *  and if it not equal to current element place that elemnt at adjacent position and move both pointer
    * Time Complexity : O(n) and Space : O(1)
    */


    public static void optimalApproachTwoPointer(int[] arr){
        int i = 0; int j = 1;
        while(j< arr.length){
            if(arr[i]!=arr[j]){
                arr[i+1] = arr[j];
                i++;
            }
            j++;
        }
        i++;
        // filling remaining array with zeros
        while(i<arr.length) {
            arr[i] = 0;
            i++;
        }
    }


    public static void main(String[] args){
        int[] arr = {1,1,2,2,2,3,3,4,4,5} ;
//        RemoveDuplicateFromSortedArray.bruteForceApproachUsingSet(arr);
        RemoveDuplicateFromSortedArray.optimalApproachTwoPointer(arr);
        System.out.println(Arrays.toString(arr));
    }

}
