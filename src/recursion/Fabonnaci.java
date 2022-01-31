package recursion;

public class Fabonnaci {

    public static int febo(int n){
        if(n<=1) return 0;
        if(n==2) return 1;
        return febo(n-1)+febo(n-2);
    }

    public  static void main(String args[]){
        System.out.println(febo(10));
    }
}
