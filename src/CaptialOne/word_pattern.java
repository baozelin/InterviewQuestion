package CaptialOne;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class word_pattern {
    public boolean wordPattern(String pattern, String s) {
        String[] list = s.split(" ");

        if(list.length != pattern.length()) return false;
        Map<Character, String> map = new HashMap<>();  // c : word
        Set<String> m = new HashSet<>();   // word

        for(int i = 0; i < pattern.length(); i++){
            char c = pattern.charAt(i);

            if(!map.containsKey(c)){

                if(m.contains(list[i])) return false;

                map.put(c, list[i]);
                m.add(list[i]);
            }

            else{
                if(!map.get(c).equals(list[i])) return false;
            }
        }
        return true;
    }

}
