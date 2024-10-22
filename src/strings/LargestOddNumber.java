package strings;

import java.util.Arrays;

public class LargestOddNumber {

    public static String largestOddNumber(String num) {
        for(int i=num.length()-1;i>=0;i--)
        {
            int ch=num.charAt(i)-'0';
            if(ch%2==1)
            {
                return num.substring(0,i+1);
            }
        }
        return "";
    }

    public static boolean rotateString(String s, String goal) {
        if (s.equals(goal)){
            return true;
        }
        for (int i = 0; i < s.length()-1; i++) {
            s = s.substring(1) + s.substring(0,1);
            if (s.equals(goal)){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args){
        rotateString("abcdeabcde","eabcd");
        //largestOddNumber("35427");//35427 //52
    }
}
