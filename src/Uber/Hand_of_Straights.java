package Uber;

import java.util.TreeMap;

public class
Hand_of_Straights {


    public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i : hand){
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        for(int key : map.keySet()){
            int count = map.get(key);
            if(count > 0){
                for(int i = key + groupSize -1; i>= key; i--){
                    if(map.getOrDefault(i, 0) < count){
                        return false;
                    }

                    map.put(i, map.get(i)-count);
                }
            }
        }

        return true;
    }

}
