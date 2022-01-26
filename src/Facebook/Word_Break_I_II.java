package Facebook;

import java.util.*;


//139
//Input: s = "leetcode", wordDict = ["leet","code"]
//Output: true
public class Word_Break_I_II {

    //Time complexity : O(n^3)
    // ). For every starting index, the search can continue till the end of the given string.
    //Space complexity : O(n). Queue of at most nn size is needed.
    public boolean wordBreak(String s, List<String> wordDict) {

        Queue<Integer> queue = new LinkedList<>(); // index
        queue.offer(0);
        Set<Integer> set = new HashSet<>();

        while(!queue.isEmpty()){

            int cur = queue.poll();
            if(set.contains(cur)) continue;

            for(int i = cur+1; i <= s.length(); i++){

                String tmp = s.substring(cur, i);

                if(wordDict.contains(tmp)){

                    if(i == s.length()) return true;
                    queue.offer(i);
                    set.add(cur);
                }
            }
        }

        return false;
    }


    // WORD break 2

    public List<String> wordBreak_ii(String s, List<String> wordDict) {

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
                if(cur.length() > 0){
                    dfs(s, wordDict, i, cur + " " + str, res);
                }else{
                    dfs(s, wordDict, i, str, res);
                }
            }
        }
    }
}
