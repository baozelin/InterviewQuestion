package Uber;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

//340
//Input: s = "eceba", k = 2
//Output: 3
//Explanation: The substring is "ece" with length 3.
public class Longest_Substring_with_At_Most_K_Distinct_Characters {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n = s.length();
        if (n == 0 || k == 0) {
            return 0;
        }

        int left = 0, right = 0;

        // c, position
        Map<Character, Integer> rightPosition = new HashMap<>();

        int max = 1;

        while(right < n){
            rightPosition.put(s.charAt(right), right);
            right++;


            if(rightPosition.size() == k+1){
                int low = Collections.min(rightPosition.values());
                rightPosition.remove(s.charAt(low));
                left = low+1;
            }

            max = Math.max(max, right - left);
        }

        return max;
    }
}
