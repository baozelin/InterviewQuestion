package Facebook;


import java.util.*;

//347
//Input: nums = [1,1,1,2,2,3], k = 2
//Output: [1,2]
public class
Top_K_Frequent_Elements {


    public List<Integer> topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap();

        for(int i : nums){

            map.put(i, map.getOrDefault(i, 0) +1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue(k, new Comparator<Pair>(){

            public int compare(Pair a, Pair b){
                return b.count - a.count;
            }
        });

        for(int i : map.keySet()){

            pq.offer(new Pair(map.get(i), i));
        }

        List<Integer> ret = new ArrayList();


        for(int i = 0; i < k; i++){
            ret.add(pq.poll().value);
        }
        return ret;
    }


    class Pair{
        int count;
        int value;

        public Pair(int count, int value){
            this.count = count;
            this.value = value;
        }
    }
}
