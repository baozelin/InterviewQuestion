package Ebay;


import java.util.Stack;

//20
//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//An input string is valid if:
//
//Open brackets must be closed by the same type of brackets.
//Open brackets must be closed in the correct order.
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
