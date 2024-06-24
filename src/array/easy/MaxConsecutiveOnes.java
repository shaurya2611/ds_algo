package array.easy;

public class MaxConsecutiveOnes {

    static int maxOneCount(int[] arr){
        int maxOneCount  = 0;
        int oneCount = 0;
        for (int i = 0; i< arr.length; i++){
            if (arr[i]==1) {
                oneCount++;
                if (oneCount > maxOneCount)
                    maxOneCount = oneCount;
            }else {
                oneCount = 0;
            }
        }
         return  maxOneCount;
    }


    public static void main(String[] args) {
        int[] arr = {0,1,1,1,0,1,1,0,1,1,1,1};
        int a = maxOneCount(arr);
    }
}
