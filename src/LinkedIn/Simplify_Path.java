package LinkedIn;


import java.util.Stack;

//Input: path = "/home/"
//Output: "/home"
public class Simplify_Path {

    public String simplifyPath(String path) {
        String ret = "";

        String[] list = path.split("/");
        Stack<String> stack = new Stack();

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
        return ret.length() > 0? ret : "/";

    }
}
