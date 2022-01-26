package Ebay;

import java.util.*;


//140
public class Word_break_II {

    //Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
    //Output: ["cats and dog","cat sand dog"]
    public List<String> wordBreak_II(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        if(s == null || s.length() == 0)
            return res;
        dfs(s, wordDict, 0, "", res);
        return res;
    }

    void dfs(String s, List<String> wordDict, int start, String cur, List<String> res){
        if(start > s.length()) return;
        if(start == s.length()){
            res.add(cur);
            return;
        }

        for(int i = start+1; i <= s.length(); i++){
            String str = s.substring(start, i);
            if(wordDict.contains(str)){
                // not first word
                if(cur.length() > 0){
                    dfs(s, wordDict, i, cur + " " + str, res);

                }else{
                    // first word
                    dfs(s, wordDict, i, str, res);
                }
            }
        }
    }
}
