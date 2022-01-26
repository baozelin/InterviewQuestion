package Ebay;


import java.util.*;

//49
//Given an array of strings strs, group the anagrams together. You can return the answer in any order.
//
//An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all
// the original letters exactly once.
public class Group_anagram {

    //O(nKlogk)
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap();

        for(String str : strs){
            char[] c= str.toCharArray();
            Arrays.sort(c);
            String tmp = new String(c);
            if(!map.containsKey(tmp))
                map.put(tmp, new ArrayList());
            map.get(tmp).add(str);
        }
        List<List<String>> ret = new ArrayList();

        for(String key : map.keySet()){
            ret.add(new ArrayList(map.get(key)));
        }
        return ret;
    }


    //O(NK)
    public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
}
