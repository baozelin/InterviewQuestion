package wepay;

import java.util.Stack;

public class Valid_Parentheses {
    public boolean isValid(String s) {
        char[] list =  s.toCharArray();
        Stack<Character> stack = new Stack();

        for(int i = 0; i < list.length; i++){

            char c = list[i];
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }

            if(c == ')' || c == ']' || c == '}'){
                if(stack.size() == 0) return false;

                char cur = stack.peek();

                if(c == ')' && cur != '('){
                    return false;
                }
                else if(c == ']' && cur != '['){
                    return false;
                }
                else if(c == '}' && cur != '{'){
                    return false;
                }else{
                    stack.pop();
                }
            }
        }
        return stack.size() == 0? true: false;

    }
}
