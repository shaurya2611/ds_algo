package dynamicProgramming;

public class SubSetSumPrint {

    /* For the given array and sum find all the subset that from array that makes that sum*/
    public static boolean subSetSumRecursive(int[] arr, int size, int sum, String subset){

        if(sum==0){
            System.out.println(subset);
            return true;
        }
        if (size==0)
            return false;

        if(arr[size-1]<=sum){
            boolean taken =  subSetSumRecursive(arr, size-1, sum-arr[size-1], subset+arr[size-1]+" ");
            boolean notTaken = subSetSumRecursive(arr, size-1, sum, subset);
            return taken|| notTaken;

        }else{
            return subSetSumRecursive(arr, size-1, sum, subset);
        }

    }
    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7};
        int sum = 7;
        int size = arr.length;
        System.out.println(subSetSumRecursive(arr, size, sum,""));
    }
}
