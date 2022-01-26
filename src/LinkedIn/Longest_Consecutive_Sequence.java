package LinkedIn;

import java.util.*;


//Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
//
//You must write an algorithm that runs in O(n) time.
public class Longest_Consecutive_Sequence {


    //hashset
    //O(n)
    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();
        int max = 0;
        for(int n: nums){
            set.add(n);
        }



        for(int num: set){

            if(!set.contains(num-1)){  // 所以 才是 O(n),  6,5,4,3,2,1 input, only the value 1 is valid
                int cur = num;
                int localmax = 1;

                while(set.contains(cur+1)){
                    cur++;
                    localmax++;
                }
                max = Math.max(max, localmax);
            }


        }
        return max;
    }
}
