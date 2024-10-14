package array.hard;

import java.util.Arrays;

public class MergeSortedArray {

    /*Merge two sorted arrays without using extra space
      Example 1:
        Input: n = 4, arr1[] = [1 4 8 10]   and m = 3, arr2[] = [2 3 9]
        Output: arr1[] = [1 2 3 4] and arr2[] = [8 9 10]
        After merging the two non-decreasing arrays, we get, 1,2,3,4,8,9,10.

      Example 2:
        Input: n = 4, arr1[] = [1 3 5 7]   and m = 5, arr2[] = [0 2 6 8 9]
        Output: arr1[] = [0 1 2 3] and arr2[] = [5 6 7 8 9]
        After merging the two non-decreasing arrays, we get, 0 1 2 3 5 6 7 8 9.
    */


    /*
    Using the 2 pointers, we will swap the bigger elements of arr1[] with the smaller elements of arr2[] until
    the minimum of arr2[] becomes greater or equal to the maximum of arr1[]. And then sort both arrays
    Time: O(m+n + nlogn+ mlogn)
    * */

    public static void optimalApproach(int[] arr1, int[] arr2){
            int pointer1 = arr1.length-1; // traversal in array1
            int pointer2 = 0; //traversal in array2

        while (pointer1>0 && pointer2<arr2.length){
            if(arr1[pointer1]  > arr2[pointer2]){
                int temp = arr1[pointer1];
                arr1[pointer1] = arr2[pointer2];
                arr2[pointer2] = temp;
                pointer1--;
                pointer2++;
            }else {
                break;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);

    }

    public static void main(String[] args){
        int[] arr1 = {1, 4, 8, 10,78, 109, 230};
        int[] arr2 = {2, 3, 5, 6, 7};
        MergeSortedArray.optimalApproach(arr1,arr2);
        String s = "";
    }

}
