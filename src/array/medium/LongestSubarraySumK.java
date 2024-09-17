package array.medium;

public class LongestSubarraySumK {

    static void optimalApproach(int[] arr, int k){
        int maxSubarrayLength= 0;
        int left = 0,right = 0;
        int sum = arr[left];

        while(right < arr.length){
            // if sum > k, move left pointer towards right and decrease sum
            while(left<=right && sum > k) {
                sum = sum - arr[left];
                left++;
            }
            // if sum==k, update the length
            if(sum==k){
                int length = right - left + 1;
                maxSubarrayLength = Math.max(maxSubarrayLength, length);
            }
            // if sum < k, move right pointer and increase sum
            if( sum<k){
                right++;
                if(right<arr.length)
                    sum+=arr[right];
            }
        }
        System.out.println("Max Subaray : "+maxSubarrayLength);

    }

    public static void main(String[] args) {
        int[] arr = {5,2,3,1,7,2,1,9};
        optimalApproach(arr,10);
    }
}
