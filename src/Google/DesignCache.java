package Google;


import java.security.Timestamp;
import java.util.HashMap;

//implement a cache, with put and get function, put(int key, int val, int duration), get(int key)
//follow: 如果一直put不get怎么办
//follow: 多线程之类的讨论
public class DesignCache {
    HashMap<Integer, Integer> map = new HashMap<>(); // key, value
    HashMap<Integer, Timestamp> times = new HashMap<>(); // key,  expiretime

    void put(int key, int val){

    }


    int get(int key){
        if(!checkIsExpired(key)) return -1;
        return 1;
    }

    //check expire
    boolean checkIsExpired(int key){
        return true;
    }
}
