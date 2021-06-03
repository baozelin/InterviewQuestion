package DropboxOA;

import java.util.*;

//Input: s = "leetcode", wordDict = ["leet","code"]
//Output: true

public class wordbreak {
    public boolean wordBreak(String s, List<String> wordDict) {

        if(wordDict.contains(s)) return true;

        Set<Integer> set = new HashSet();

        Queue<Integer> queue  = new LinkedList();
        queue.offer(0);

        while(!queue.isEmpty()){
            int i = queue.poll();
            if(set.contains(i)) continue;

            for(int k = i+1; k <= s.length(); k++){

                String word = s.substring(i,k);

                if(wordDict.contains(word)){
                    if(k == s.length()) return true;
                    queue.offer(k);
                    set.add(i);

                }
            }
        }

        return false;
    }
}
