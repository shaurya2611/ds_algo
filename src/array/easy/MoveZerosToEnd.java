package array.easy;

import java.util.Arrays;

public class MoveZerosToEnd {

    /*  move all the zeroes in array at the en dof array
        {0,1,0,0,2,3,0,4,0,0,5} --output--> {1,2,3,4,5,0,0,0,0,0}
        Solution : Using two pointer, moving non zeroes at starting.
        Time : O(n)
    * */
    public static void moveZeroToEndOptimal(int[] arr){
        int flag = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=0){
                int temp = arr[i];
                arr[i] = 0;
                arr[flag] = temp;
                flag++;
            }
        }
    }

    public static void main(String[] args){
        int[] arr = {0,1,0,0,2,3,0,4,0,0,5};
        System.out.println(Arrays.toString(arr));
        moveZeroToEndOptimal(arr);
        System.out.println(Arrays.toString(arr));
    }
}
