package LinkedIn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 *    hashmap<String, list> </String,>
 */
public class Shortest_Word_DistanceII {

    //<String, list>
    HashMap<String, List<Integer>> map;

    public Shortest_Word_DistanceII(String[] wordsDict) {
        map = new HashMap();
        for(int i = 0; i < wordsDict.length; i++){
            if(!map.containsKey(wordsDict[i])){
                map.put(wordsDict[i], new ArrayList<Integer>());
            }
            map.get(wordsDict[i]).add(i);
        }
    }


    /**
     *   two pointer, 往后一
     * @param word1
     * @param word2
     * @return
     */
    public int shortest(String word1, String word2) {

        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);

        int l1 = 0, l2 = 0, diff = Integer.MAX_VALUE;

        while(l1 < list1.size() && l2 < list2.size()){

            diff = Math.min(diff, Math.abs(list1.get(l1)-list2.get(l2)));

            if(list1.get(l1) < list2.get(l2)){
                l1++;
            }else{
                l2++;
            }
        }

        return diff;


    }
}
