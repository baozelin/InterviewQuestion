package LinkedIn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Insert_Delete_Get_Random {
    List<Integer> list;
    HashMap<Integer, Integer> map;
    Random rand = new Random();
    /** Initialize your data structure here. */
    public Insert_Delete_Get_Random() {
        list = new ArrayList();
        map = new HashMap();
        //size = 0;
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;

        map.put(val,list.size());
        list.add(list.size(), val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int last = list.get(list.size()-1);
        int idx  = map.get(val);
        list.set(idx,last);
        map.put(last, idx);
        list.remove(list.size() -1);
        map.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {

        return list.get(rand.nextInt(list.size()));
    }
}
