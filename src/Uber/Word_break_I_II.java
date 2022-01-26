package Uber;

import java.util.*;


//139, 140
public class Word_break_I_II {


    //Input: s = "leetcode", wordDict = ["leet","code"]
    //Output: true
    //Explanation: Return true because "leetcode" can be segmented as "leet code".

    //Time complexity : O(2^n)

    public boolean wordBreak_I(String s, List<String> wordDict) {
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        queue.offer(0);
        set.add(0);

        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int i = cur+1; i <= s.length(); i++){
                String str = s.substring(cur, i);
                if(wordDict.contains(str)){
                    if(i == s.length()){
                        return true;
                    }
                    if(set.contains(i)) continue;
                    queue.offer(i);
                    set.add(i);
                }
            }
        }

        return false;

    }



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
