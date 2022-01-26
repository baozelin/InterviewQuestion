package Tinder;

import java.util.HashSet;
import java.util.Stack;

//1249
//Input: s = "lee(t(c)o)de)"
//Output: "lee(t(c)o)de"
public class Minimum_Remove_to_Make_Valid_Parentheses {
    public String minRemoveToMakeValid(String s) {

        HashSet<Integer> set = new HashSet(); // index
        Stack<Integer> stack = new Stack();

        for(int i = 0; i < s.length(); i++){

            char c = s.charAt(i);
            if(c == '('){
                stack.push(i);
            }

            if(c == ')'){

                if(stack.isEmpty()){
                    set.add(i);
                }else{
                    stack.pop();
                }

            }
        }


        while(!stack.isEmpty()){
            set.add(stack.pop());
        }



        //rebuild string
        String res = "";
        for(int i = 0; i < s.length(); i++){

            if(set.contains(i)){
                continue;
            }
            else{
                res += s.charAt(i);
            }
        }

        return res;
    }

}
