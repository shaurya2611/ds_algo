package strings;

import java.util.*;

public class ValidParentheses {


    /*
    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
    An input string is valid if:
    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    Every close bracket has a corresponding open bracket of the same type.
    Example: Input: s = "()[]{}"  Output -> true, Input: s = "{([]})" , Output -> false

    Solution:
    Use a stack of characters.
    When you encounter an opening bracket, push it to the top of the stack.
    When you encounter a closing bracket, check if the top of the stack was the opening for it. If yes, pop it from the stack. Otherwise, return false.
    Time O(N)
    */

    public static boolean isValid(String s) {
        List<String> openBrackets  = Arrays.asList("(", "{", "[");
        Map<String, String> map = new HashMap<>();
        map.put(")","("); map.put("}","{"); map.put("]","[");

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            String currentChar = Character.toString(s.charAt(i));
            if (openBrackets.contains(currentChar)){
                stack.push(Character.toString(s.charAt(i)));
            }else{
                if(stack.isEmpty()) return false;
                String popChar = stack.pop(); // possible elements: ] ,} , )
                if(!map.get(currentChar).equals(popChar)) return false;
            }
        }
        if (stack.isEmpty()) return true;

        return false;
    }

    public static void main(String[] args){
        System.out.println(ValidParentheses.isValid("{()}()()"));
    }

}
