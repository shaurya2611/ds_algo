package array.easy;

import java.util.HashMap;
import java.util.Map;

public class MissingNumber {

    // Problem : in a given array containing natural number upto 'n' and one number is missing


    /*Solution: Sum of first natural number - sum of array = missing number
    * Time = 0(n) , Space )(1)
    * */
    public int missingNumberBetterSolution(int[] arr){
        int missingNumber = arr[arr.length-1]*(arr[arr.length-1] + 1) /2;  // n(n+1)/2
        for(int i =0; i<arr.length; i++){
            missingNumber = missingNumber - arr[i];
        }
        return missingNumber;
    }

    /*Using XOR bitwise operation  using concepts  -->
       -->  n ^ n = 0
       -->  n ^ 0 = n i.e. number itself
      XOR1 = 1^2^3^4^5
      XOR2 = 1^2^3^5
      XOR1 ^ XOR2 = 1^1^2^2^3^3^4^5^5 = 0^0^0^4^0 = 0^0^0^0^4 = 0^4 = 4 i.e. missing number

      Time = O(n) , Space = O(1)
    */
    public static int missingNumberOptimalSolution(int[] arr, int N){
        int xor1 = 0;
        int xor2 = 0;
        int n = N-1;
        for(int i=0; i<n; i++){
            // we have to multiply 2 array -->{1^2^3^5} ^ {1^2^3^4^5}
            xor1 = xor1 ^ arr[i];
            xor2 = xor2 ^ (i+1);
        }
        xor2 = xor2 ^ N;
        return xor1 ^ xor2;
    }

    public static void main(String[] args){
        int[] arr = {1,2,3,5};
        System.out.println(missingNumberOptimalSolution(arr,5));

    }
}
