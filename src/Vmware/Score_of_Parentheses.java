package Vmware;


import java.util.Stack;

//856
//Input: s = "(())"
//Output: 2
public class Score_of_Parentheses {

    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);  //initate score;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(c == '('){
                stack.push(0);
            }

            else{

                int v = stack.pop();
                int w = stack.pop();

                stack.push(w + Math.max(v*2, 1));
            }
        }

        return stack.pop();
    }
}
