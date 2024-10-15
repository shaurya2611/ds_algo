package strings;

import java.util.Stack;

public class RemoveOutermostParentheses {

    /*
    This problem can be achived in to steps:
    1. Split outer most valid ()
    2. Remove the outer most ()

    Example:
    Input : "(()())(())" , Output : "()()()"
    Input: "()()" , Output: ""
    Input: "((()))" , Output: "(())"
    Input: "(()())(()(()))" , Output: "()()()(())"

    Solution:
        PUSH -> at "("
        POP -> at  ")"
        Before push check, If stack is not empty then keep adding in answer
        After pop check, If stack is not empty keep adding in answer
    */

    public static StringBuilder validateParenthesis(String s){
        StringBuilder ans = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            if (c=='('){
                if (!stack.isEmpty()){
                    ans.append(c);
                }
                stack.push(c);
            }else{
                stack.pop();
                if (!stack.isEmpty()){
                    ans.append(c);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args){
        String s = "(()())(()(()))";
        validateParenthesis(s);
    }

}
