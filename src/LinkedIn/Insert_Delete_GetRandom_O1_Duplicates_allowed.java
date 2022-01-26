package LinkedIn;


import java.util.*;

//381. Insert Delete GetRandom O(1) - Duplicates allowed
public class Insert_Delete_GetRandom_O1_Duplicates_allowed {
    ArrayList<Integer> list;
    HashMap<Integer, Set<Integer>> map;
    Random rand = new Random();

    public Insert_Delete_GetRandom_O1_Duplicates_allowed() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }



    public boolean insert(int val) {

        if(!map.containsKey(val)){
            map.put(val, new HashSet<>());
        }

        map.get(val).add(list.size());   //add val with location
        list.add(val);  //add val
        return map.get(val).size() == 1;

    }

    public boolean remove(int val) {
        if(!map.containsKey(val) || map.get(val).size() == 0) return false;

        int remove_idx = map.get(val).iterator().next();
        map.get(val).remove(remove_idx);
        int lastVal = list.get(list.size()-1);
        list.set(remove_idx, lastVal);


        map.get(lastVal).add(remove_idx);
        map.get(lastVal).remove(list.size()-1);
        list.remove(list.size()-1);
        return true;

    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
