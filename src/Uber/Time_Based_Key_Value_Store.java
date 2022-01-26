package Uber;
import java.util.*;


//981. Time Based Key-Value Store
//Design a time-based key-value data structure that can store multiple values for the same key at different time
// stamps and retrieve the key's value at a certain timestamp.
//
//Implement the TimeMap class:
//
//TimeMap() Initializes the object of the data structure.
//void set(String key, String value, int timestamp) Stores the key key with the value value at the given time timestamp.
//String get(String key, int timestamp) Returns a value such that set was called previously, with timestamp_prev <= timestamp.
// If there are multiple such values, it returns the value associated with the largest timestamp_prev. If there are no values,
// it returns "".
public class Time_Based_Key_Value_Store {
    Map<String, List<Integer>> timeMap;
    Map<String, List<String>> valMap;

    public Time_Based_Key_Value_Store() {

        this.timeMap = new HashMap<>();
        this.valMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {

        if(!timeMap.containsKey(key)){
            timeMap.put(key, new ArrayList<>());
            valMap.put(key, new ArrayList<>());
        }

        timeMap.get(key).add(timestamp);
        valMap.get(key).add(value);
    }

    public String get(String key, int timestamp) {

        if(!timeMap.containsKey(key) || timeMap.get(key).get(0) > timestamp) return "";
        List<Integer> times = timeMap.get(key);

        // 1, 2, 3, ,4 ,5        4
        // binary
        int l = 0, r = times.size();
        while(l < r){
            int m = (l+r)/2;


            if(times.get(m) <= timestamp){
                l = m+1;
            }else if(times.get(m) > timestamp){
                r = m;
            }
            else{
                return valMap.get(key).get(m);
            }
        }

        return valMap.get(key).get(l-1);
    }
}
