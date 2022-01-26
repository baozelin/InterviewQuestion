package Uber;

import java.util.*;

public class LFUCache {

    public LFUCache(int capacity) {
        cap = capacity;
        map = new HashMap<>();
        freq = new HashMap<>();
        list = new HashMap<>();
        minFreq = 1;
    }
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        int count = freq.get(key);
        list.get(count).remove(key);
        freq.put(key, count + 1);
        if(list.get(minFreq).size() == 0)
            minFreq++;
        if(!list.containsKey(count + 1)){
            LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();
            set.add(key);
            list.put(count+1, set);
        }else{
            list.get(count+1).add(key);
        }
        return map.get(key);
    }
    public void put(int key, int value) {
        if(cap <= 0)
            return;
        if(get(key) != -1){
            map.put(key, value);
            return;
        }
        if(map.size() >= cap){
            Integer removeKey = list.get(minFreq).iterator().next();
            map.remove(removeKey);
            list.get(minFreq).remove(removeKey);
            freq.remove(removeKey);
        }
        //System.out.println(map.toString());
        map.put(key, value);
        freq.put(key, 1);
        if(!list.containsKey(1)){
            LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();
            set.add(key);
            list.put(1, set);
        }else{
            list.get(1).add(key);
        }
        minFreq = 1;
    }

    private int cap;
    private int minFreq;
    private HashMap<Integer, Integer> map;
    private HashMap<Integer, Integer> freq;
    private HashMap<Integer, LinkedHashSet<Integer>> list;
}