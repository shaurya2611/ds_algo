package strings;

public class ReverseWordsInString {

    public static String optimalSolution(String s) {
      StringBuilder ans = new StringBuilder();
      String temp="";
      for (int i=s.length()-1; i>=0; i--){
          String currChar = Character.toString(s.charAt(i));
          if(currChar.equals(" ")){
              ans.append(temp);
              if (temp.length()>0) ans.append(" ");
              temp="";
          }else{
              temp = currChar+temp;
          }

      }
      ans.append(temp);

      return ans.toString().trim();
    }

    public static void main(String[] args){
        String sen = "   Shaurya singh DS     Algo     ";
        optimalSolution(sen);
    }
}
