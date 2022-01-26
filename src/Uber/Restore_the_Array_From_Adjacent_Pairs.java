package Uber;


import java.util.*;

//1743
//Restore the Array From Adjacent Pairs
//Input: adjacentPairs = [[2,1],[3,4],[3,2]]
//Output: [1,2,3,4]
//Explanation: This array has all its adjacent pairs in adjacentPairs.
//Notice that adjacentPairs[i] may not be in left-to-right order.
public class Restore_the_Array_From_Adjacent_Pairs {


    //时间O(mn) , 空间O(n)
    //build graph
    public int[] restoreArray(int[][] adjacentPairs) {

        int n = adjacentPairs.length;
        int[] res = new int[n+1];
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        //build graph
        // [1, 2]
        for(int[] p: adjacentPairs){

            //1
            if(!map.containsKey(p[0])){
                map.put(p[0], new HashSet<>());
            }
            map.get(p[0]).add(p[1]);

            //2
            if(!map.containsKey(p[1])){
                map.put(p[1], new HashSet<>());
            }
            map.get(p[1]).add(p[0]);
        }

        HashSet<Integer> result = new HashSet<>();
        int cur = Integer.MAX_VALUE;
        int i = 0;

        //find head
        for (Map.Entry<Integer, HashSet<Integer>> e : map.entrySet()) {
            // 说明是数组的头部
            if (e.getValue().size() == 1) {
                cur = e.getKey();
                break;
            }
        }

        res[i] = cur;
        i++;

        result.add(cur);

        while(i < res.length){
            for(int next: map.remove(cur)){

                if(next != cur && !result.contains(next)){
                    result.add(cur);
                    res[i] = next;
                    i++;
                    cur = next;
                }
            }
        }



        return res;
    }
}
