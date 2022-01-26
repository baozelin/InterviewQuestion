package Vmware;


import java.util.ArrayList;
import java.util.List;

//Input: s = "()())()"
//Output: ["(())()","()()()"]

//  // O(2^n)
public class Remove_Invalid_Parentheses {
    int min = Integer.MAX_VALUE;
    List<String> res = new ArrayList<>();

    public List<String> removeInvalidParentheses(String s) {
        dfs(s, "", 0 ,0 , 0, 0);
        return res;
    }


    // every position: 2 remove or keep ( or )
    void dfs(String s, String cur, int index, int open, int close, int remove){
        //corner case
        if(index == s.length()){
            if(open == close){
                //update res
                if(remove < min){
                    res.clear();
                    res.add(cur);
                    min = remove;
                }

                // add cur to res
                else if(remove == min && !res.contains(cur))
                    res.add(cur);
            }
            return;
        }

        char c = s.charAt(index);

        // not ( or )
        if(c != '(' && c != ')'){
            dfs(s, cur+c, index+1, open, close, remove);
        }

        else{
            //case 1 remove ( or )
            dfs(s, cur, index+1, open, close, remove+1);

            //case 2: (
            if(c == '(')
                dfs(s, cur+c, index+1, open+1, close, remove);

            else{
                //case 3: )
                if(open > close)
                    dfs(s, cur+c, index+1, open, close+1, remove);
            }
        }
    }


}
