package recursion;

public class ZZDemo {

    public static int displayName(int n){
        //base case
        if(n<=0)
            return 0;
        int sum = displayName(n-1);
        System.out.println(n);
        return n+sum;


    }


    public static boolean reveseArray(int[] arr, int start, int end){
        if(start>=end)
            return true;

        if(arr[start]!=arr[end])
            return false;
        return reveseArray(arr,start+1, end-1);

    }

//    public static int finonnaci(int n, int sum){
//        if(n-2<=0)
//            return 0;
//
//
//
//    }

public static  void main(String[] args){
//        int sum = displayName(5);
//        int arr[] = {1,2,3,3,2,1};
//    System.out.println(reveseArray(arr,0,arr.length-1));
//        for (int i:arr) System.out.println(i);
}

}
