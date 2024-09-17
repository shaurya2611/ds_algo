package array.medium;

public class LongestSubarraySumK {

    static void optimalApproach(int[] arr, int k){
        int maxSubarrayLength= 0;
        int left = 0,right = 0;
        int sum = arr[left];

        while(right < arr.length){
           if(sum < k){
               right++;
               if (right < arr.length)
                   sum+=arr[right];
           }

           else if(sum > k){
               sum = sum - arr[left];
               left++;
           }
           else {
               int length = right - left + 1;
               maxSubarrayLength = Math.max(length, maxSubarrayLength);
               right++;
               if(right < arr.length){
                   sum = sum + arr[right] - arr[left];
                   left++;
               }
           }
        }
        System.out.println("Max Subaray : "+maxSubarrayLength);

    }

    public static void main(String[] args) {
        int[] arr = {1,7,1,4,2,1,9};
        optimalApproach(arr,9);
    }
}
