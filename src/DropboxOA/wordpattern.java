package DropboxOA;


// leetcode 290
//Input: pattern = "abba", s = "dog cat cat dog"
//Output: true

import java.util.HashMap;
import java.util.HashSet;

public class wordpattern {
    // easy hash map
    //Map<Character, String> map = new HashMap();
   // Set<String> m = new HashSet();


    public boolean wordPattern(String pattern, String s) {
        String[] list = s.split(" ");
        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();

        for(int i = 0; i < pattern.length(); i++){

            char c = pattern.charAt(i);

            if(!map.containsKey(c)){
                if(set.contains(list[i])) return false;

                map.put(c, list[i]);
                set.add(list[i]);
            }

            else {
                if (!map.get(c).equalsIgnoreCase(list[i])) {
                    return false;
                }
            }
        }
        return true;
    }

    //Input: pattern = "abab", s = "redblueredblue"
    //Output: true
    //no space
    //dfs + HashMap, set
    public boolean wordPatternMatch(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        return dfs(0, 0, pattern, s, map, set);
    }


    boolean dfs(int i, int j, String pattern, String str, HashMap<Character,String> map, HashSet set){

        if(i == pattern.length() && j == str.length()) return true;
        if(i == pattern.length() || j == str.length()) return false;

        char c = pattern.charAt(i);

        if(!map.containsKey(c)){
            for(int k = j; k < str.length(); k++){
                String s = str.substring(j,k+1);

                if(set.contains(s)) continue;
                map.put(c, s);
                set.add(s);

                if(dfs(i+1, k+1, pattern, str, map,set)) return true;
                map.remove(c);
                set.remove(s);

            }
        }

        else{
            String s = map.get(c);
            if(!str.startsWith(s,j)) return false;

            else{
                return dfs(i+1, j+1, pattern, s, map, set);
            }
        }

        return false;
    }

}
