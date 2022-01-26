package Facebook;

import java.util.Stack;


//71
//Input: path = "/home/"
//Output: "/home"
//Explanation: Note that there is no trailing slash after the last directory name.
public class Simplify_Path {

    // stack
    public String simplifyPath(String path) {

        String ret = "";
        String[] list = path.split("/");

        Stack<String> stack = new Stack<>();

        for(int i = 0; i < list.length; i++){
            String cur = list[i];

            if(cur.equals(".") || cur.equals("")) continue;

            else if(cur.equals("..")){
                if(stack.isEmpty()) continue;
                stack.pop();
            }

            else{
                stack.add(cur);
            }
        }

        for(String s: stack){
            ret += "/";
            ret += s;
        }
        return ret.length() > 0 ? ret : "/";
    }
}
