package Tinder;


import java.util.ArrayList;
import java.util.List;

//301
//Input: s = "()())()"
//Output: ["(())()","()()()"]
public class Remove_Invalid_Parentheses {


    int minCount = Integer.MAX_VALUE;
    List<String> ret = new ArrayList();

    public List<String> removeInvalidParentheses(String s) {
        char[] list = s.toCharArray();
        dfs(list, "", 0, 0, 0, 0 );
        return ret;
    }

    void dfs(char[] s, String list, int index, int open, int close, int remove){

        if(index == s.length){
            if(open == close){
                if(remove < minCount){
                    ret.clear();
                    ret.add(list);
                    minCount = remove;
                }

                if(remove == minCount && !ret.contains(list)){
                    ret.add(list);
                }
            }
            return;
        }else{

            char c = s[index];

            // no ( )
            if(c != '(' && c !=')'){
                list += c;
                dfs(s, list, index+1, open, close, remove);
            }

            else{

                //remove ( or )

                dfs(s, list, index+1, open, close, remove+1);

                // (
                if(c == '('){
                    list += c;
                    dfs(s, list, index+1, open+1, close, remove);
                }

                // )
                else{
                    if(open > close){

                        list += c;
                        dfs(s, list, index+1, open, close+1, remove);
                    }
                }
            }

        }
    }
}
