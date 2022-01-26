package wepay.oa;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Array_Summation {

    //element in test as a target, return true if finding a pairs from inputs, otherwise return false
    public static boolean arraySum(List<Integer> inputs, List<Integer> tests){
        boolean result = false;

        for(int target: tests){
            HashSet<Integer> pairs = new HashSet();
            if(twoSum(inputs, target, pairs)) return true;
        }
        return result;
    }

    // using a set to store (target - element), return true if an element exist in set, otherwise return false
    public static boolean twoSum(List<Integer> inputs, int target, HashSet<Integer> pairs){
        for(int element : inputs){
            if(pairs.contains(target - element)) return true;
            pairs.add(element);
        }
        return false;
    }
}
