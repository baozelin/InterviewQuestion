package Facebook;


import java.util.Stack;

//1047
//Input: s = "abbaca"
//Output: "ca"
//Explanation:
//For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.
// The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
public class Remove_All_Adjacent_Duplicates_In_String {

    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){

            if(!stack.isEmpty() && stack.peek() == c){
                stack.pop();
            }

            else{
                stack.add(c);
            }

        }
        for(char c : stack){
            sb.append(c);
        }
        return sb.toString();
    }
}
