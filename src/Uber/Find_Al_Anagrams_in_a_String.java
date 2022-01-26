package Uber;


import java.util.*;

//438
//Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
//
//An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
//Input: s = "cbaebabacd", p = "abc"
//Output: [0,6]
//Explanation:
//The substring with start index = 0 is "cba", which is an anagram of "abc".
//The substring with start index = 6 is "bac", which is an anagram of "abc".
public class
Find_Al_Anagrams_in_a_String {

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> ret = new ArrayList();
        int[] map = new int[26];

        char[] plist = p.toCharArray();
        char[] slist = s.toCharArray();


        //fill map
        for(char c : plist){
            map[c -'a']++;
        }

        int count = plist.length, j = 0;
        for(int i = 0; i < slist.length; i++){
            char c = slist[i];
            if(map[c - 'a'] > 0){
                count--;
            }
            map[c - 'a']--;
            while(count == 0){
                if(i-j == p.length()-1){
                    ret.add(j);
                }

                if( ++ map[ slist[j] - 'a'] > 0){
                    count++;
                }
                j++;
            }
        }
        return ret;
    }
}
