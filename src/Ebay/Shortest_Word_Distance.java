package Ebay;

import java.util.*;

public class Shortest_Word_Distance {

    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        HashMap<String, List<Integer>> map = new HashMap();

        for(int i = 0; i < wordsDict.length; i++){

            String word = wordsDict[i];
            if(!map.containsKey(word)){
                map.put(word, new ArrayList());

            }

            map.get(word).add(i);
        }


        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);

        int l1 = 0, l2 = 0, diff = Integer.MAX_VALUE;

        while(l1 < list1.size() && l2 < list2.size()){

            diff = Math.min(Math.abs(list1.get(l1) - list2.get(l2)),diff);

            if(list1.get(l1) < list2.get(l2)){
                l1++;
            }else{
                l2++;
            }

        }

        return diff;


    }
}
