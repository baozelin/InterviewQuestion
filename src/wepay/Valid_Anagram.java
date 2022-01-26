package wepay;

import java.util.HashMap;

public class Valid_Anagram {

    public boolean isAnagram(String s, String t) {

        HashMap<Character, Integer> map = new HashMap();

        for(char c: s.toCharArray()){

            map.put(c, map.getOrDefault(c, 0) +1);

        }

        for(char c: t.toCharArray()){

            if(!map.containsKey(c)) return false;

            else
                map.put(c, map.get(c)-1);

        }

        for(char key: map.keySet()){

            if(map.get(key) != 0) return false;
        }

        return true;
    }
}
