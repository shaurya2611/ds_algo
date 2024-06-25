package array.easy;

public class SingleNumber {

   /* Problem Statement :
    * Given a non-empty array of integers nums, every element appears twice except for one.
    * Find that single one

    * Using XOR bitwise operation  using concepts  -->
            -->  n ^ n = 0
            -->  n ^ 0 = n i.e. number itself
        XOR1 = 1^2^3^4^5
        XOR2 = 1^2^3^5
        XOR1 ^ XOR2 = 1^1^2^2^3^3^4^5^5 = 0^0^0^4^0 = 0^0^0^0^4 = 0^4 = 4 i.e. missing number

        Time = O(n) , Space = O(1)
    */
    public static int singleNumberOptimalSolution(int[] arr){
        int singleNumber = 0;
        for (int i = 0; i < arr.length; i++) {
            singleNumber = singleNumber ^ arr[i];
        }
        return singleNumber;
    }

    /* Use hasing, use unordered map i.e. HashMap to store array item as key and value
        as their occurrence and then iterate over map to get key with value = 1

        Time = O(n + n) , Space = O(n)
       */
    public static void singleNumberBruteSolution(){

    }
    public static void main(String[] args){
        int[] arr = {1,2,2,3,3,5,5,1,6};
        System.out.println(singleNumberOptimalSolution(arr));

    }
}
