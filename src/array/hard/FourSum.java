package array.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {


    // Saem approch as of 2sum and 3 sum
    //Time O(n^3)
    public static List<List<Integer>> optimalApproach(int[] nums, int target){
        List<List<Integer>> ans = new ArrayList<>();

        // sort the given array:
        Arrays.sort(nums);

        //calculating the quadruplets:
        for (int i = 0; i < nums.length; i++) {
            // avoid the duplicates while moving i:
            if (i>0 && nums[i]==nums[i-1]) continue;
            for (int j = i+1; j < nums.length; j++) {
                // avoid the duplicates while moving j:
                if (j>i+1 && nums[j]==nums[j-1]) continue;
                int low = j+1;
                int high = nums.length-1;
                while (low < high){
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[low];
                    sum += nums[high];
                    if(sum > target){
                        high--;
                    } else if (sum < target) {
                        low++;
                    }else {// sum == target
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[low]);
                        temp.add(nums[high]);
                        ans.add(temp);
                        low++;
                        high--;
                        // skip the duplicates:
                        while(low<high && nums[low]==nums[low-1]){
                            low++;
                        }
                        while(low<high && nums[high]==nums[high+1]){
                            high--;
                        }
                    }
                }

            }
        }

        return ans;
    }

    public static void main(String[] args){
        int[] nums = {-1,0,1,0};
        ThreeSum.optimalApproach(nums);
    }
}
