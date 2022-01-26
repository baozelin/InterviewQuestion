package wepay;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Group_anagram {

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
