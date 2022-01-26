package Expedia;


//402 Given string num representing a non-negative integer num, and an integer k,
// return the smallest possible integer after removing k digits from num.

import java.util.Stack;

//Input: num = "1432219", k = 3
//Output: "1219"
public class Remove_K_Digits {

    //stack
    public String removeKdigits(String num, int k) {


        Stack<Character> stack = new Stack<>();

        // remove, keep it increasing
        for(char c: num.toCharArray()){

            while(!stack.isEmpty() && k > 0 && stack.peek() > c){
                stack.pop();
                k--;
            }

            //add new c
            stack.add(c);

        }

        // still need to remove, from stack top
        //since it is increasing
        for(int i=0; i < k; i++){
            stack.pop();
        }

        //build result
        StringBuilder sb = new StringBuilder();
        boolean zero = true;

        for(char c : stack){
            if(zero && c == '0') continue;
            zero = false;
            sb.append(c);
        }
        if (sb.length() == 0) return "0";
        return sb.toString();
    }
}
