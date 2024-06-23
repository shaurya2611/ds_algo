package array.easy;

import java.util.Arrays;

public class RotateArray {

    // input = {1,2,3,4,5} --output--> {2,3,4,5,1}
    // Time : O(n) , Space : O(1)
    static void rotateArrayLeftByOne(int[] arr){
        //take first element as temp and now shift remaining element to left by one place
        int temp = arr[0];
        for (int i = 1 ; i < arr.length; i++) {
            arr[i-1] = arr[i];
        }
        arr[arr.length-1] = temp;
    }


    /* rotate array left by 'd', input = {1,2,3,4,5}, rotate by 3 --output--> {4,5,1,2,3}
       Solution: Same as above, store first d element in another array and then shift remaining to left
       Time : O(n + d) , Space : O(d)
     */
    static void rotateArrayLeftByDBruteSolution(int[] arr, int d){
        if (d == arr.length){// as if no of rotation = length array, output array is same as  input array
            return;
        }

        d = d % arr.length;
        // store first 'd' elemnt in temp array
        int[] temp = new int[d];
        for (int i=0; i<d; i++){
            temp[i] = arr[i];
        }
        //Shift remaining element to left array by 'd' places
        for (int j=d; j<arr.length; j++){
            arr[j-d] = arr[j];
        }

        // filling temp[] at last 'd' places of array
        int flag = arr.length - d;
        for (int t= 0; t<temp.length;t++){
            arr[flag] = temp[t];
            flag++;
        }
    }


    /*
    * Solution : reverse first d element , reverse remaining element, and then reverse whole array
    * Time : O(2n) , Space : O(1)
    * */
    static void rotateArrayLeftByOptimalSolution(int[] arr, int d){
        d = d % arr.length;

        reverseArray(arr, 0,d-1); //  O(d)
        reverseArray(arr,d,arr.length-1);   // O(n-d)
        reverseArray(arr,0,arr.length-1); // O(n)
    }

    static void reverseArray(int[] arr, int startIndex, int endIndex){
        while(startIndex<endIndex){
            int temp = arr[startIndex];
            arr[startIndex] = arr[endIndex];
            arr[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
    }

    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7} ;
        System.out.println(Arrays.toString(arr));
//        rotateArrayLeftByOne(arr);
        rotateArrayLeftByOptimalSolution(arr,3);
        System.out.println(Arrays.toString(arr));
    }
}
