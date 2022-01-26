package Amazon;

import java.util.*;

//49
//Given an array of strings strs, group the anagrams together. You can return the answer in any order.
//
//An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all
// the original letters exactly once.
public class Group_Anagrams {

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
}
