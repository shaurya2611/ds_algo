package array.medium;

public class MaximumSubarraySum {

    /* Kadane's Algorithm : Maximum Subarray Sum in an Array
    Problem : Given an integer array arr, find the contiguous subarray (containing at least one number) which
    has the largest sum and returns its sum and prints the subarray.
    e.g. :  Input: arr = [-2,1,-3,4,-1,2,1,-5,4]  , Output:6

    Solution : The intuition of the algorithm is not to consider the subarray as a part of the answer if its sum
    is less than 0. A subarray with a sum less than 0 will always reduce our answer and so this type of subarray
    cannot be a part of the subarray with maximum sum.
    Here, we will iterate the given array with a single loop and while iterating we will add the elements in a
    sum variable. Now, if at any point the sum becomes less than 0, we will set the sum as 0 as we are not going to
    consider any subarray with a negative sum. Among all the sums calculated, we will consider the maximum one.
    */


    public static long maxSubarraySum(int[] arr, int n) {
        long maxi = Long.MIN_VALUE; // maximum sum
        long sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum > maxi) {
                maxi = sum;
            }
            // If sum < 0: discard the sum calculated
            if (sum < 0) {
                sum = 0;
            }
        }
        // To consider the sum of the empty subarray
        // uncomment the following check:
        //if (maxi < 0) maxi = 0;
        return maxi;
    }

    public static long getSubarrayWithMaxSum(int[] arr, int n) {
        long maxi = Long.MIN_VALUE; // maximum sum
        long sum = 0;
        int ansStart = -1;
        int ansEnd = -1;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum > maxi) {
                maxi = sum;
            }
            // If sum < 0: discard the sum calculated
            if (sum < 0) {
                sum = 0;
            }
        }
        // To consider the sum of the empty subarray
        // uncomment the following check:
        //if (maxi < 0) maxi = 0;
        return maxi;
    }



    public static void main(String args[]) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4};
        int n = arr.length;
        long maxSum = maxSubarraySum(arr, n);
        System.out.println("The maximum subarray sum is: " + maxSum);

    }


}
