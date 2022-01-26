package Uber;

import java.util.*;


//Greedy问题. 感觉上是应该先排剩余frequency 最多的Character.
//
//用maxHeap来维护剩余的Character, 根据剩余的count.
//
//那么如何保持断开的距离大于k呢, 用queue来存放已经加过的Character, 只有当queue的size等于k时, 才允许把头上的Character放回到maxHeap中.
//
//Time Complexity: O(nlogn). n = s.length(). 都加入进maxHeap用时O(nlogn).
//
//Space: O(n).
public class Rearrange_String_k_Distance_Apart {


        public String rearrangeString(String s, int k) {
            if(s == null || s.length() == 0){
                return s;
            }

            HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
            for(int i = 0; i<s.length(); i++){
                hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0)+1);
            }

            PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<Map.Entry<Character, Integer>>(
                    (a, b) -> b.getValue() - a.getValue()
            );
            maxHeap.addAll(hm.entrySet());

            LinkedList<Map.Entry<Character, Integer>> que = new LinkedList<Map.Entry<Character, Integer>>();
            StringBuilder sb = new StringBuilder();
            while(!maxHeap.isEmpty()){
                Map.Entry<Character, Integer> cur = maxHeap.poll();
                sb.append(cur.getKey());
                cur.setValue(cur.getValue()-1);
                que.add(cur);

                if(que.size() < k){
                    continue;
                }

                Map.Entry<Character, Integer> head = que.poll();
                if(head.getValue() > 0){
                    maxHeap.add(head);
                }
            }
            return sb.length() == s.length() ? sb.toString() : "";
        }

}
