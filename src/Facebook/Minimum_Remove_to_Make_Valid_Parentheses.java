package Facebook;


import java.util.HashSet;
import java.util.Stack;

//1249
//Given a string s of '(' , ')' and lowercase English characters.
//
//Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.
//Input: s = "lee(t(c)o)de)"
//Output: "lee(t(c)o)de"
//Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
public class Minimum_Remove_to_Make_Valid_Parentheses {

    // set + stack <position>
    public String minRemoveToMakeValid(String s) {
        if(s.length() == 0) return "";
        // position
        Stack<Integer> stack = new Stack<>();
        HashSet<Integer> set = new HashSet();

        for(int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.add(i);
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
            if(set.contains(i)) continue;
            else
                res += s.charAt(i);
        }
        return res;

    }
}
