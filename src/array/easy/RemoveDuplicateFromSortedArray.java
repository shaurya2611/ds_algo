package array.easy;

import java.util.Arrays;

public class RemoveDuplicateFromSortedArray {
/*
* Remove the duplicate from sorted array
* e.g. [1,1,2,2,2,3,3,4,4,5]  --output->  [1,2,3,4,5,0,0,0,0,0]
* */
    static void removeDuplicate(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i]==arr[i+1]){
                arr[i] = 0;
            }
        }
    }
    static void sortArrayForZero(int[] arr){
        int flag = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=0){
                arr[flag] = arr[i];
                arr[i] = 0;
                flag++;
            }
        }
    }

    public static void main(String[] args){
        int[] arr = {1,1,2,2,2,3,3,4,4,5} ;
        System.out.println(Arrays.toString(arr));
        removeDuplicate(arr);
        System.out.println(Arrays.toString(arr));
        sortArrayForZero(arr);
        System.out.println(Arrays.toString(arr));


    }

}
