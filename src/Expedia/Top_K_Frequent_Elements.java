package Expedia;


//347. Top K Frequent Elements
//Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

import java.util.*;

public class
Top_K_Frequent_Elements {

    //bucket sort
    //O(n), O(n)
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int num: nums){
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }


        //bucket array, frecount will be index
        List<Integer>[] buckets = new List[nums.length + 1];
        for(int key : countMap.keySet()){
            int freq = countMap.get(key);

            if(buckets[freq] == null){
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(key);
        }

        //reverse buckets array
        int[] res = new int[k];
        for(int i = buckets.length-1, pos = 0; i >= 0 && pos < k; i--){
            if(buckets[i] != null){
                for(int key: buckets[i]){
                    res[pos] = key;
                    pos++;
                }
            }
        }
        return res;
    }
}
